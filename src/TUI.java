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
    }

    public void mostrarTaulell(){

    }

    public short recollirJugada(short torn, char[] taulell){
        return 0;
    }

    public void fiDePartida(short guanyador){

    }

    public TUI(Scanner sc) {
        this.sc = sc;
    }
}