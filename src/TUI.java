import java.util.Scanner;

public class TUI extends Main{

    Scanner sc;
    char input;

    public void getInput() {
        input = sc.next().charAt(0);
    }

    public int mostrarMenu() {
        System.out.println("1. Nova partida\n2. Carregar partida\n3. Configuració\n4. Sortir");
        getInput();
        return input;
        ///aaaaaa
    }

    public void mostrarTaulell(char[][] taulell, short torn){
        System.out.println("Torn " + torn);
        for (int fila = 0; fila < 3; fila++){
            for (int columna = 0; columna < 3; columna++){
                System.out.print(taulell[fila][columna]);
            }
            System.out.println();
        }
    }

    public short[][] recollirJugada(){
        System.out.println("Selecciona fila.");
        short fila = sc.nextShort();
        System.out.println("Selecciona columna.");
        short columna = sc.nextShort();
        return new short [fila][columna];
    }

    public void fiDePartida(short guanyador){
        if (guanyador == 1){
            System.out.println("Ha guanyat el jugador 1");
        }
        else if (guanyador == 2){
            System.out.println("Ha guanyat el jugador 2");
        }
        else if (guanyador == 3){
            System.out.println("Empat");
        }
        else{
            System.out.println("Sos hacker bro");
        }
    }

    public TUI(Scanner sc) {
        this.sc = sc;
    }
}