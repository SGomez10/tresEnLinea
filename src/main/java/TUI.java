import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class TUI extends Main {

    Scanner sc;

    public char getCharInput() {
        return sc.next().charAt(0);
    }

    public String getStringInput() {
        return sc.next();
    }

    public int mostrarMenu() {
        System.out.println("\n1. Nova partida\n2. Carregar partida\n3. Configuració\n4. Sortir");
        return getCharInput();
    }

    public int mostrarMenuConfig() {
        System.out.println("1. Cambiar mida del taulell\n2. Enrere");
        return getCharInput();
    }

    public void mostrarTorn(int torn) {
        System.out.println("Torn " + torn);
    }

    public void mostrarTaulell(char[][] taulell) {
        for (int fila = 0; fila < taulell.length; fila++) {
            for (int columna = 0; columna < taulell.length; columna++) {
                System.out.print(taulell[fila][columna] + " ");
            }
            System.out.println();
        }
    }

    public String guardarPartidaText() {
        System.out.println("Introdueix el nom de la partida");
        return getStringInput();
    }

    public void guardarPartidaOk() {
        System.out.println("Partida guardada correctament");
    }

    public void guardarPartidaError() {
        System.out.println("Ya existeix una partida amb aquest nom");
    }

    public String carregarPartidaText() {
        System.out.println("Escriu el nom de la partida que vols carregar");
        return sc.next();
    }

    public int guardarMidaTaullel(){
        System.out.println("Escriu la mida del taulell (minim 3, maxim 10)");
        return Integer.parseInt(sc.next());
    }

    public void guardarMidaError(){
        System.out.println("El número no entra en el rang definit");
    }

    public void guardarMidaOK(){
        System.out.println("S'ha guardat la mida del taulell correctament");
    }

    public int carregarPartidaTorn(File file) throws FileNotFoundException {
        Scanner fr = new Scanner(file);
        int torn = Integer.parseInt(fr.next());
        fr.close();
        return torn;
    }

    public int carregarMida() throws FileNotFoundException {
        Scanner fr = new Scanner(new File("resources/config.txt"));
        int numMida = Integer.parseInt(fr.next());
        fr.close();
        return numMida;
    }

    public char[][] carregarPartidaTaulell(File file) throws FileNotFoundException {
        Scanner fr = new Scanner(file);
        fr.next();
        int tamany = Integer.parseInt(fr.next());
        char[][] taulell = new char[tamany][tamany];
        for (int fila = 0; fila < taulell.length; fila++) {
            for (int columna = 0; columna < taulell.length; columna++) {
                taulell[fila][columna] = fr.next().charAt(0);
            }
        }
        fr.close();
        return taulell;
    }

    public int[] recollirJugada() {
        int posicions[];
        posicions = new int[2];
        System.out.println("Selecciona fila.");
        posicions[0] = Character.getNumericValue(getCharInput());
        System.out.println("Selecciona columna.");
        posicions[1] = Character.getNumericValue(getCharInput());
        return posicions;
    }

    public void fiDePartida(int guanyador) {
        if (guanyador == 1) {
            System.out.println("Ha guanyat el jugador 1");
        } else if (guanyador == 2) {
            System.out.println("Ha guanyat el jugador 2");
        } else if (guanyador == 3) {
            System.out.println("Empat");
        } else {
            System.out.println("Sos hacker bro");
        }
    }

    public void jugadaNoValida() {
        System.out.println("Aquesta jugada no es válida, introdueix una posició dins del taulell");
    }

    public TUI(Scanner sc) {
        this.sc = sc;
    }
}