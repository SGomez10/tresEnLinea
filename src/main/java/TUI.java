import java.util.Scanner;

public class TUI extends Main {

    Scanner sc;

    public char getCharInput() {
        return sc.next().charAt(0);
    }

    public String getStringInput() {
        return sc.next();
    }

    public int mostrarMenu() {
        System.out.println("1. Nova partida\n2. Carregar partida\n3. Configuració\n4. Sortir");
        return getCharInput();
    }

    public void mostrarTaulell(char[][] taulell, int torn) {
        System.out.println("Torn " + torn);
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