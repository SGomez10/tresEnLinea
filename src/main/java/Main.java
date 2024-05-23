import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);
        TUI tui = new TUI(sc);
        Joc joc = new Joc();

        File resources = new File("resources");
        if (resources.mkdir()) {
            tui.ResourcesCreat(resources);
        }
        File savedgames = new File("resources/savedgames");
        if (savedgames.mkdir()) {
            tui.SaveCreat(savedgames);
        }

        boolean partida = false;

        while (!partida){
            partida = menuPrincipal(tui, joc);
            while (partida) {
                tui.mostrarTorn(joc.getTorn());
                tui.mostrarTaulell(joc.getTaulell());
                int posicioActual[];
                posicioActual = jugada(tui, joc);
                if (posicioActual[0] == -1 && posicioActual[1] == -1) {
                    partida = false;
                    break;
                }

                if (joc.jugadaGuanyadora(posicioActual[0], posicioActual[1])) {
                    int guanyador = 3;
                    if (joc.getTorn() % 2 == 0) {
                        guanyador = 1;
                    } else if (joc.getTorn() % 2 != 0) {
                        guanyador = 2;
                    }
                    tui.fiDePartida(guanyador);
                    tui.mostrarTaulell(joc.getTaulell());
                    partida = false;
                }
                joc.incrementarTorn();
            }
        }
    }

    public static int[] jugada(TUI tui, Joc joc) throws IOException {
        int posicions[];
        posicions = tui.recollirJugada();
        if (joc.verificaJugada(posicions[0], posicions[1]) == 2) {
            joc.jugar(posicions[0], posicions[1]);
            return posicions;
        }else if (joc.verificaJugada(posicions[0], posicions[1]) == 0) {
            guardarPartidaMain(tui, joc);
            return posicions;
        } else {
            tui.jugadaNoValida();
            return jugada(tui, joc);
        }
    }

    public static boolean guardarPartidaMain(TUI tui, Joc joc) throws IOException {
        if(joc.guardarPartida(tui.guardarPartidaText()))
        {
            tui.guardarPartidaOk();
            return true;
        }
        else{
            tui.guardarPartidaError();
            return guardarPartidaMain(tui, joc);
        }
    }

    public static boolean menuPrincipal(TUI tui, Joc joc) throws IOException {
        while (true) {
            switch (tui.mostrarMenu()) {
                case '1':
                    joc.setTamany(tui.carregarMida());
                    novaPartida(joc);
                    return true;
                case '2':
                    carregarPartida(tui, joc);
                    return true;
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

    protected static void configuracio(TUI tui, Joc joc) throws IOException {
        configuracio:
        while (true) {
            switch (tui.mostrarMenuConfig()) {
                case '1':
                    guardarConfigMain(joc, tui);
                    break;
                case '2':
                    break configuracio;
                default:
                    break;
            }
        }
    }

    protected static boolean guardarConfigMain(Joc joc, TUI tui) throws IOException {
        if(joc.guardarConfiguracio(tui.guardarMidaTaullel())){
            tui.guardarMidaOK();
            return true;
        }
        else {
            tui.guardarMidaError();
            return guardarConfigMain(joc,tui);
        }
    }

    protected static void carregarPartida(TUI tui, Joc joc) throws FileNotFoundException {
        File file = joc.carregarPartidaFile(tui.carregarPartidaText());
        joc.setTaulell(tui.carregarPartidaTaulell(file));
        joc.setTorn(tui.carregarPartidaTorn(file));
    }

    protected static void novaPartida(Joc joc) {
        joc.novaPartida();
    }
}