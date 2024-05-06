import java.util.Locale;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);

        TUI tui = new TUI(sc);
        Joc joc = new Joc();
        boolean partida = false;

        menuPrincipal:
        while (true){
            switch (tui.mostrarMenu()){
                case '1':
                    novaPartida(joc);
                    partida = true;
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
        while (partida){
            tui.mostrarTaulell(joc.taulell, joc.getTorn());
            tui.recollirJugada();
            int posicions[];
            posicions = tui.recollirJugada();
            joc.verificaJugada(posicions[0], posicions[1], joc.taulell);

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

    protected static void novaPartida(Joc joc) {joc.novaPartida();}
}