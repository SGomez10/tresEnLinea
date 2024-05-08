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
        if (victoriaHorizontal(taulell, fila) || victoriaVertical(taulell, columna, torn) || victoriaDiagonalInferior(taulell, fila, columna, torn))
            return true;
        else return false;

    }

    private static boolean victoriaHorizontal(char[][] taulell, int fila) {
        int contadorH = 0;

        for (int c = 0; c < 3; c++) {
            if (taulell[fila][c] == 'X') {
                contadorH++;
            }
            else{
                contadorH=0;
            }
        }

        if (contadorH == 3) return true;
        else return false;

    }

    private static boolean victoriaVertical(char[][] taulell, int columna, int torn) {
        int contadorV = 0;
        char simbol;

        if (torn % 2 != 0) simbol = 'X';
        else simbol = 'O';

        for (int f = 0; f < 3; f++) {
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

    private static boolean victoriaDiagonalSuperior(char[][] tablero, int fila, int columna) {

        int contadorDiaSup = 0;

        for(int f=0; f>tablero.length; f++){

        }


        if (contadorDiaSup == 3) return true;
        else return false;
    }

    private static boolean victoriaDiagonalInferior(char[][] taulell, int fila, int columna, int torn) {

        int contadorDiagInf = 0;
        char simbol;

        if (torn % 2 != 0) simbol = 'X';
        else simbol = 'O';

        for (int i=fila; i<taulell.length-1; i++){
           if(taulell[fila][columna]==simbol){
               contadorDiagInf++;
           }
           else{
               break;
           }
           columna++;
           if( columna>taulell.length-1) break;
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

    public boolean victoriaDiagonal(char[][]taulell, int fila, int columna, int torn){

        char simbol;
        int contadorDiag=0;

        if(torn%2!=0) simbol ='X';
        else simbol='O';

        if( fila<0 || columna<0 || fila>=taulell.length || columna>=taulell.length) return false;
        else{
                boolean arribaDer=victoriaDiagonal(taulell,fila-1,columna+1,torn);
                boolean abajoDer=victoriaDiagonal(taulell,fila+1,columna+1,torn);
                boolean arribaIzq=victoriaDiagonal(taulell,fila-1,columna-1,torn);
                boolean abajoIzq=victoriaDiagonal(taulell,fila+1,columna-1,torn);

                boolean esSimbol= (arribaDer || abajoDer || arribaIzq || abajoIzq);

                if(esSimbol){
                    contadorDiag++;
                }

                if(contadorDiag==3) return true;
                else return false;
        }
    }

}
