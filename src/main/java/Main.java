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

    public static int[] jugada(TUI tui, Joc joc){
        int posicions[];
        posicions = tui.recollirJugada();
        if(joc.verificaJugada(posicions[0], posicions[1], joc.taulell)){
            joc.jugar(posicions[0], posicions[1]);
            return posicions;
        }
        else{
            tui.jugadaNoValida();
            return jugada(tui, joc);
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