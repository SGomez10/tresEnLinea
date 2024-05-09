import java.io.FileNotFoundException;
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
        boolean partida = false;

        while (!partida){
            partida = menuPrincipal(tui, joc);
            while (partida) {
                tui.mostrarTaulell(joc.getTaulell(), joc.getTorn());
                int posicioGuanyadora[];
                posicioGuanyadora = jugada(tui, joc);
                if (posicioGuanyadora[0] == -1 && posicioGuanyadora[1] == -1){
                    partida = false;
                    break;
                }
            /*
            if (joc.jugadaGuanyadora(posicioGuanyadora[0], posicioGuanyadora[1])){
                tui.fiDePar1tida(joc.getTorn());
                partida = false;
            */
                System.out.println("Fila:" + posicioGuanyadora[0] + " Columna:" + posicioGuanyadora[1]); // deberia ser tui
            }
        }
    }

    public static int[] jugada(TUI tui, Joc joc) throws IOException {
        int posicions[];
        posicions = tui.recollirJugada();
        if (joc.verificaJugada(posicions[0], posicions[1], joc.getTaulell()) == 2) {
            joc.jugar(posicions[0], posicions[1]);
            return posicions;
        } else if (joc.verificaJugada(posicions[0], posicions[1], joc.getTaulell()) == 0) {
            joc.guardarPartida(tui.guardarPartidaText(), joc.getTaulell(), joc.getTorn());
            return posicions;
        } else {
            tui.jugadaNoValida();
            return jugada(tui, joc);
        }
    }

    public static boolean menuPrincipal(TUI tui, Joc joc) throws FileNotFoundException {
        while (true) {
            switch (tui.mostrarMenu()) {
                case '1':
                    novaPartida(joc);
                    return true;
                case '2':
                    carregarPartida(tui, joc);
                    return false;
                case '3':
                    configuracio(tui, joc);
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

    protected static void configuracio(TUI tui, Joc joc) {
        configuracio:
        while (true) {
            switch (tui.mostrarMenuConfig()) {
                case '1':
                    // metodo de cambiar configracion
                    break;
                case '2':
                    break configuracio;
                default:
                    break;
            }
        }
    }

    protected static void carregarPartida(TUI tui, Joc joc) throws FileNotFoundException {
        File file = joc.carregarPartidaFile(tui.carregarPartidaText());
        tui.carregarPartidaTorn(file);
        tui.carregarPartidaTaulell(file);
        char[][] taulell = new char[3][3];

    }

    protected static void novaPartida(Joc joc) {
        joc.novaPartida();
    }
}