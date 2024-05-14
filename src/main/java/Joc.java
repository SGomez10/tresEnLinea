import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Joc {

    private char[][] taulell;
    private int torn;
    private int tamany = 3;

    public char[][] getTaulell() {
        return taulell;
    }

    public void setTaulell(char[][] taulell) { this.taulell = taulell;}

    public char getPosicio(int fila, int columna) { return taulell[fila][columna];}

    public int getTorn() {
        return torn;
    }

    public void setTorn(int torn) {
        this.torn = torn;
    }

    public int getTamany() {
        return tamany;
    }

    public void setTamany(int tamany) {
        this.tamany = tamany;
    }

    public char[][] novaPartida() {

        torn = 1;
        taulell = new char[tamany][tamany];
        for (int fila = 0; fila < taulell.length; fila++) {
            for (int columna = 0; columna < taulell.length; columna++) {
                taulell[fila][columna] = '_';
            }
        }
        return taulell;
    }

    public File carregarPartidaFile(String string) {return new File("resources/savedgames/" + string + ".txt");}

    public void jugar(int fila, int columna) {

        char[][] taullel = getTaulell();

        if (taulell[fila][columna] == '_') {
            if (torn % 2 != 0) taullel[fila][columna] = 'X';
            else taullel[fila][columna] = 'O';
        }

        // añadir else

        torn += 1;
    }

    //esto va a haber que hacerlo de forma recursiva
    public boolean jugadaGuanyadora(int fila, int columna, int caso) {
        int contador = 0;
        char simbol;
        if (torn % 2 == 0){ simbol = 'X';}
        else{ simbol = 'O';}

        if (caso == 0) {
            //horizontal
            for (int c = 0; c < taulell.length; c++){
                if(taulell[fila][c] == simbol){
                    contador++;
                    if (contador==3) break;
                }
                else contador = 0;
            }
            if (contador >= 3) return true;
            else return false;
        }
        else if (caso == 1) {
            //vertical
            for (int f = 0; f < taulell.length; f++){
                if(taulell[f][columna] == simbol){
                    contador++;
                    if (contador==3) break;
                }
                else contador = 0;
            }
            if (contador >= 3) return true;
            else return false;
        }
        else if (caso == 2) {
            // diagonal 1
            int c = taulell.length - 1;
            for (int f = 0; f < taulell.length; f++) {
                if (contador >= 3) {
                    return true;
                } else if (taulell[f][c] == simbol) {
                    c--;
                    contador++;
                } else {
                    contador = 0;
                }
            }
        }
        else if (caso == 3) {
            //diagonal 2
            int c = 0;
            for (int f = 0; f < taulell.length; f++) {
                if (contador >= 3) {
                    return true;
                } else if (taulell[f][c] == simbol) {
                    contador++;
                } else {
                    contador = 0;
                }
                c++;
            }
        }
        else{
            return false;
        }
        return false;
    }

    public int verificaJugada(int fila, int columna, char[][] taulell) {
        if (fila == -1 && columna == -1) {
            return 0;         // if de -1 -1 para guardar partida
        } else if (fila > (taulell.length - 1) || fila < 0 || columna > taulell.length - 1 || columna < 0 || taulell[fila][columna] == 'X' || taulell[fila][columna] == 'O') {
            return 1;
        } else return 2;
    }

    public boolean guardarPartida(String string, char[][] taulell, int torn) throws IOException {
        File partidaguardada = new File("resources/savedgames/" + string + ".txt");
        if (partidaguardada.createNewFile()) {
            FileWriter text = new FileWriter("resources/savedgames/" + string + ".txt");   //filewrter crea el archicvo si no existe, modificar esto
            text.write(String.valueOf(torn) + " " + tamany + " ");
            for (int fila = 0; fila < taulell.length; fila++) {
                for (int columna = 0; columna < taulell.length; columna++) {
                    text.write(taulell[fila][columna] + " ");
                }
            }
            text.close();
            return true;
        }
        else{
            return false;
        }
    }
}
