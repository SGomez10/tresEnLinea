import java.util.Scanner;
import java.io.File;

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
    }

    public void mostrarTaulell(char[][] taulell, int torn){
        System.out.println("Torn " + torn);
        for (int fila = 0; fila < 3; fila++){
            for (int columna = 0; columna < 3; columna++){
                System.out.print(taulell[fila][columna]);
            }
            System.out.println();
        }
    }

    public int[] recollirJugada(){
        int posicions[];
        posicions = new int[2];
        System.out.println("Selecciona fila.");
        posicions[0]= sc.nextInt();
        System.out.println("Selecciona columna.");
        posicions[1] = sc.nextInt();
        return posicions;
    }

    public void fiDePartida(int guanyador){
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