public class Joc {

    char[][] taulell;
    short torn = 1;

    public char[][] getTaulell() {
        return taulell;
    }

    public short getTorn() {
        return torn;
    }

    public char[][] novaPartida() {

        taulell = new char[3][3];
        return taulell;
    }

    public void jugar(int fila, int columna) {

        char[][] taullel = getTaulell();
        getTorn();

        if (taulell[fila][columna] == 0) {
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

        taulell = getTaulell();
        if (victoriaHorizontal(taulell, fila, torn) || victoriaVertical(taulell, columna, torn) || victoriaDiagonalInferior(taulell, fila, columna,torn) || victoriaDiagonalSuperior(taulell,fila,columna,torn))
            return true;
        else return false;

    }

    public boolean victoriaHorizontal(char[][] taulell, int fila, int torn) {

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

    public static boolean victoriaVertical(char[][] taulell, int columna, int torn) {
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

    public static boolean victoriaDiagonalSuperior(char[][] taulell, int fila, int columna, int torn) {

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

    public static boolean victoriaDiagonalInferior(char[][] taulell, int fila, int columna, int torn) {

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

    public boolean verificaJugada(int fila, int columna, char[][] taulell) {

        if (fila > (3 - 1) || fila < 0 || columna > (3 - 1) || columna < 0) {
            return false;
        } else if (taulell[fila][columna] == 'X' || taulell[fila][columna] == 'O') {
            return false;
        } else return true;

    }


}
