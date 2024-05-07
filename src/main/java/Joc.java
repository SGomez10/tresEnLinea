import java.io.File;
import java.io.IOException;

public class Joc {

    char[][] taulell;
    int torn = 1;

    public char[][] getTaulell() {
        return taulell;
    }

    public int getTorn() {
        return torn;
    }

    public char[][] novaPartida() {

        taulell = new char[3][3];
        for (int fila = 0; fila < taulell.length; fila++) {
            for (int columna = 0; columna < taulell.length; columna++) {
                taulell[fila][columna] = '_';
            }
        }
        return taulell;
    }

    public void jugar(int fila, int columna) {

        char[][] taullel = getTaulell();

        if (taulell[fila][columna] == '_') {
            if (torn % 2 != 0) taullel[fila][columna] = 'X';
            else taullel[fila][columna] = 'O';
        }

        // añadir else

        torn += 1;
    }

    public boolean jugadaGuanyadora(int fila, int columna) {

        return false;

    }

    public int verificaJugada(int fila, int columna, char[][] taulell) {

        if (fila == -1 && columna == -1) {
            return 0;         // if de -1 -1 para guardar partida
        } else if (fila > (taulell.length - 1) || fila < 0 || columna > taulell.length - 1 || columna < 0 || taulell[fila][columna] == 'X' || taulell[fila][columna] == 'O') {
            return 1;
        } else return 2;
    }

    public void guardarPartida(String string) throws IOException {
        File partidaguardada = new File("resources/savedgames/" + string + ".txt");
        if (partidaguardada.createNewFile()) {
            System.out.println("Partida guardada: " + partidaguardada.getName()); //mover al tui
        }
    }
}
