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

    /**
     * Aquest mètode s'encarrega de comprovar si en fer una jugada en qualsevol posició, el jugador que fa la jugada ha guanyat o no.
     * Per a funcionar crida a altres quatre mètodes que comproven si hi ha un tres el línia de forma vertical, horitzontal, o qualsevol diagonal.
     * En cas d'haver-ho, retorna un true
     * @param fila
     *        Fila de la posició on es fa la jugada a comprovar
     *
     * @param columna
     *        Columna de la posició on es fa la jugada a comprovar
     *
     * @return
     *       Retorna true si el jugador ha guanyat, i false si no es troba una jugada que permeti guanyar al jugador
     */
    public boolean jugadaGuanyadora(int fila, int columna) {

        if (victoriaHorizontal(fila) || victoriaVertical(columna) || victoriaDiagonalInferior(fila, columna) || victoriaDiagonalSuperior(fila,columna))
            return true;
        else return false;

    }

    public boolean victoriaHorizontal(int fila) {

        int contadorH = 0;
        char simbol;

        if (torn % 2 != 0) simbol = 'X';
        else simbol = 'O';

        for (int c = 0; c < taulell.length; c++) {
            if (taulell[fila][c] == simbol) {
                contadorH++;
                if (contadorH==3) break;

            }
            else{
                contadorH=0;
            }
        }

        if (contadorH >= 3) return true;
        else return false;

    }

    public boolean victoriaVertical(int columna) {
        int contadorV = 0;
        char simbol;

        if (torn % 2 != 0) simbol = 'X';
        else simbol = 'O';

        for (int f = 0; f < taulell.length; f++) {
            if (taulell[f][columna] == simbol) {
                contadorV++;
                if (contadorV==3) break;
            }
            else{
                contadorV=0;
            }
        }

        if (contadorV == 3) return true;
        else return false;

    }

    public boolean victoriaDiagonalSuperior(int fila, int columna) {

        int contadorDiaSup = 0;
        char simbol;

        if(torn%2 !=0) simbol='X';
        else simbol='O';

        int filaIn= fila - Math.min(fila,columna);
        int colIn= columna - Math.min(fila,columna);

        while (filaIn<taulell.length && colIn<taulell.length){

            if(taulell[filaIn][colIn]==simbol){
                contadorDiaSup++;
                if(contadorDiaSup==3) break;

            }
            else contadorDiaSup=0;

            filaIn++;
            colIn++;
        }


        if(contadorDiaSup==3) return true;
        else return false;

    }

    public boolean victoriaDiagonalInferior(int fila, int columna) {

        int contadorDiagInf = 0;
        char simbol;

        if(torn%2!=0) simbol='X';
        else simbol='O';

        int filaIn= fila - Math.min(fila,taulell.length-1-columna);
        int colIn =  columna + Math.min(fila,taulell.length-1-columna);

        while( filaIn<taulell.length && colIn>=0){

            if(taulell[filaIn][colIn]==simbol){
                contadorDiagInf++;
                if(contadorDiagInf==3) break;
            }
            else contadorDiagInf=0;

            filaIn++;
            colIn--;
        }

        if (contadorDiagInf == 3) return true;
        else return false;
    }

    public int verificaJugada(int fila, int columna) {
        if (fila == -1 && columna == -1) {
            return 0;         // if de -1 -1 para guardar partida
        } else if (fila > (taulell.length - 1) || fila < 0 || columna > taulell.length - 1 || columna < 0 || taulell[fila][columna] == 'X' || taulell[fila][columna] == 'O') {
            return 1;
        } else return 2;
    }


    public boolean guardarPartida(String string) throws IOException {
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
