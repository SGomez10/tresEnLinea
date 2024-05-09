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

    public boolean jugadaGuanyadora(int fila, int columna) {

        taulell = getTaulell();
        if (victoriaHorizontal(taulell, fila, torn) || victoriaVertical(taulell, columna, torn) || victoriaDiagonalInferior(taulell, fila, columna) || victoriaDiagonalSuperior(taulell,fila,columna))
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
            }
            else{
                contadorH=0;
            }
        }

        if (contadorH == 3) return true;
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
            }
            else{
                contadorV=0;
            }
        }

        if (contadorV == 3) return true;
        else return false;

    }

    public static boolean victoriaDiagonalSuperior(char[][] taulell, int fila, int columna) {

        int contadorDiaSup = 0;

        for(int i=1; fila+i< taulell.length && columna-i>=0; i++){
            if(taulell[fila][columna]==taulell[fila+i][columna-i]){
                contadorDiaSup++;
            }
            else{
                break;
            }
        }

        //Bucle que mira la diagonal secundaria desde la posición seleccionada hacia arriba a la derecha
        for (int i = 1; fila-i >= 0 && columna+i < taulell.length; i++){
            if(taulell[fila][columna] == taulell[fila-i][columna+i]){
                contadorDiaSup++;
            }
            else{
                break;
            }
        }

        if (contadorDiaSup == 3) return true;
        else return false;
    }

    public static boolean victoriaDiagonalInferior(char[][] taulell, int fila, int columna) {

        int contadorDiagInf = 1;

        for (int i = 1; fila+i <taulell.length && columna+i <taulell.length; i++){
            if(taulell[fila][columna] == taulell[fila+i][columna+i]){
                contadorDiagInf++;
            }
            else{
                break;
            }
        }

        for (int i = 1; fila-i >= 0 && columna-i >= 0; i++){
            if(taulell[fila][columna] == taulell[fila-i][columna-i]){
                contadorDiagInf++;
            }
            else {
                break;
            }
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
