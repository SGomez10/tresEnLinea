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

       return false;

    }

    public boolean verificaJugada(short fila, short columna, char[][] taulell){

        if (fila > (3-1)  || fila < 0 || columna > (3-1) || columna < 0){
            return false;
        }
        else if (taulell[fila][columna]=='X' || taulell[fila][columna]=='O'){
            return false;
        }
        else return true;

    }



}
