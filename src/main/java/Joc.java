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
        for (int fila = 0; fila < taulell.length; fila++) {
            for (int columna = 0; columna < taulell.length; columna++) {
                taulell[fila][columna] = '_';
            }
        }
        return taulell;
    }

    public void jugar(int fila, int columna ){

        char[][] taullel=getTaulell();
        getTorn();

        if (taulell[fila][columna] == '_'){
            if(torn % 2!=0) taullel[fila][columna]='X';
            else taullel[fila][columna]='O';
        }

        // añadir else

        torn += 1;
    }

    public boolean jugadaGuanyadora(int fila, int columna){

       return false;

    }

    public boolean verificaJugada(int fila, int columna, char[][] taulell){

        // if de -1 -1 para guardar partida
        if (fila > (taulell.length-1)  || fila < 0 || columna > taulell.length-1 || columna < 0){
            return false;
        }
        else if (taulell[fila][columna]=='X' || taulell[fila][columna]=='O'){
            return false;
        }
        else return true;

    }



}
