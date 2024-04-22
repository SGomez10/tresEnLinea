import java.util.Locale;
import java.util.Scanner;

public class TUI {

    Scanner sc;
    char input;

    public void getInput() {
        input = sc.next().charAt(0);
    }

    public void menuIniciUI() {
        System.out.println("1. Nova partida\n2. Carregar partida\n3. Configuració\n4. Sortir");
    }

    public TUI(Scanner sc) {
        this.sc = sc;
    }
}