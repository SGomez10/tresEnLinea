import jdk.jshell.spi.ExecutionControl;

import java.util.Scanner;

public class Joc {

    char [][] taulell;
    short torn;

    public char[][] getTaulell() {
        return taulell;
    }

    public short getTorn() {
        this.torn=1;
        return torn;
    }

    public char[][] novaPartida(){

        taulell = new char[3][3];
        return taulell;
    }

    public void jugar(short fila, short columna ){

        char[][] taullel=getTaulell();
        getTorn();

        if(torn % 2!=0) taullel[fila][columna]='X';
        else taullel[fila][columna]='O';
    }

    public boolean jugadaGuanyadora(short fila, short columna){

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
