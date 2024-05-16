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

    public boolean verificaJugada(int fila, int columna) {

        if (fila > (3 - 1) || fila < 0 || columna > (3 - 1) || columna < 0) {
            return false;
        } else if (taulell[fila][columna] == 'X' || taulell[fila][columna] == 'O') {
            return false;
        } else return true;

    }


    public boolean guardarPartida(String string, int torn) throws IOException {
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
