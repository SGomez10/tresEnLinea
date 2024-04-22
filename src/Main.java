import java.util.Locale;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);

        TUI tui = new TUI(sc);

        menuPrincipal:
        while (true){
            tui.menuIniciUI();
            tui.getInput();
            switch (tui.input){
                case '1':
                    newGame();
                    break menuPrincipal;
                case '2':
                    loadGame();
                    break menuPrincipal;
                case '3':
                    settings();
                    break menuPrincipal;
                case '4':
                    exit();
                    break;
                default:
                    break;
            }
            System.out.println();
        }
    }

    private static void exit() {
        System.exit(0);
    }

    private static void settings() {
        System.out.println("3. Configuració");
    }

    private static void loadGame() {
        System.out.println("2. Carregar partida");
    }

    private static void newGame() {
        System.out.println("1. Nova partida");
    }
}