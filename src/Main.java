import java.util.Locale;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);

        TUI tui = new TUI(sc);

        menuPrincipal:
        while (true){
            switch (tui.mostrarMenu()){
                case '1':
                    novaPartida();
                    break menuPrincipal;
                case '2':
                    carregarPartida();
                    break menuPrincipal;
                case '3':
                    configuracio();
                    break menuPrincipal;
                case '4':
                    sortir();
                default:
                    break;
            }
        }
    }

    protected static void sortir() {
        System.exit(0);
    }

    protected static void configuracio() {
        System.out.println("3. Configuració");
    }

    protected static void carregarPartida() {
        System.out.println("2. Carregar partida");
    }

    protected static void novaPartida() {
        System.out.println("1. Nova partida");
    }
}