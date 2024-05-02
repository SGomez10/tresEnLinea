import jdk.jshell.spi.ExecutionControl;

import java.util.Scanner;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Joc {

    char [][] taulell;
    short torn = 1;

    public char[][] getTaulell() {
        return taulell;
    }

    public short getTorn() {
        return torn;
    }

    public char[][] novaPartida(){

        taulell = new char[3][3];
        return taulell;
    }

    public void jugar(int fila, int columna ){

        char[][] taullel=getTaulell();
        getTorn();

        if (taulell[fila][columna] == 0){
            if(torn % 2!=0) taullel[fila][columna]='X';
            else taullel[fila][columna]='O';
        }

        // añadir else

        torn += 1;
    }

    public boolean jugadaGuanyadora(int fila, int columna){

        taulell = getTaulell();
        if(victoriaHorizontal(taulell,fila) || victoriaVertical(taulell,columna) || victoriaDiagonalInferior(taulell)) return true;
        else return false;

    }

    private static boolean victoriaHorizontal(char[][] taulell, int fila){
        int contadorH=0;

        for(int c=0; c<3; c++){
            if(taulell[fila][c]=='X'){
                contadorH++;
            }
        }

        if(contadorH==3) return true;
        else return false;

    }

    private static boolean victoriaVertical(char[][] taulell, int columna){
        int contadorV=0;

        for(int f=0; f<3; f++){
            if(taulell[f][columna]=='X'){
                contadorV++;
            }
        }

        if(contadorV==3) return true;
        else return false;

    }

    private static boolean victoriaDiagonalInferior(char[][] taulell){

        int contadorDiagInf=0;

        for(int i=0; i<3; i++){
            if(taulell[i][i]=='X'){
                contadorDiagInf++;
            }
        }

        if (contadorDiagInf==3) return true;
        else return false;
    }

    public boolean verificaJugada(int fila, int columna, char[][] taulell){

        if (fila > (3-1)  || fila < 0 || columna > (3-1) || columna < 0){
            return false;
        }
        else if (taulell[fila][columna]=='X' || taulell[fila][columna]=='O'){
            return false;
        }
        else return true;

    }



}
