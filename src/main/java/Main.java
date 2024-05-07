import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);

        File resources = new File("resources");
        if (resources.mkdir()) {
            System.out.println("Directori creat: " + resources.getName());
        }
        File savedgames = new File("resources/savedgames");
        if (savedgames.mkdir()) {
            System.out.println("Directori creat: " + savedgames.getName());
        }

        TUI tui = new TUI(sc);
        Joc joc = new Joc();

        boolean partida = menuPrincipal(tui, joc);
        while (partida) {
            tui.mostrarTaulell(joc.taulell, joc.getTorn());
            int posicioGuanyadora[];
            posicioGuanyadora = jugada(tui, joc);
            /*
            if (joc.jugadaGuanyadora(posicioGuanyadora[0], posicioGuanyadora[1])){
                tui.fiDePar1tida(joc.getTorn());
                partida = false;
            */
            System.out.println("Fila:" + posicioGuanyadora[0] + " Columna:" + posicioGuanyadora[1]);
        }
    }

    public static int[] jugada(TUI tui, Joc joc) throws IOException {
        int posicions[];
        posicions = tui.recollirJugada();
        if (joc.verificaJugada(posicions[0], posicions[1], joc.taulell) == 2) {
            joc.jugar(posicions[0], posicions[1]);
            return posicions;
        } else if (joc.verificaJugada(posicions[0], posicions[1], joc.taulell) == 0) {
            joc.guardarPartida(tui.guardarPartidaText());
            return posicions;
        } else {
            tui.jugadaNoValida();
            return jugada(tui, joc);
        }
    }

    public static boolean menuPrincipal(TUI tui, Joc joc) {
        while (true) {
            switch (tui.mostrarMenu()) {
                case '1':
                    novaPartida(joc);
                    return true;
                case '2':
                    carregarPartida();
                    return true;
                case '3':
                    configuracio();
                    return false;
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

    protected static void novaPartida(Joc joc) {
        joc.novaPartida();
    }
}