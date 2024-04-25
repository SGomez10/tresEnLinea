import java.util.Scanner;

public class Joc {

    char [][] taulell;
    short torn;


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

    public void jugar(short fila, short columna ){

        char[][] taullel =getTaulell();
        short torn = getTorn();

        if(torn % 2!=0){
            if(taullel[fila][columna]==' '){
                taullel[fila][columna]='X';
            }
            else{
                System.out.println("Aquesta casella ja està ocupada");
            }
        }
        else{
            if(taullel[fila][columna]==' '){
                taullel[fila][columna]='O';
            }
            else{
                System.out.println("Aquesta casella ja està ocupada");
            }
        }

    }

    public boolean jugadaGuanyadora(short fila, short columna){


        return false;
    }

}
