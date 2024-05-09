import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class JocTest {

    @org.junit.jupiter.api.Test
    void novaPartida_taulell() {

        Joc joc = new Joc();
        joc.novaPartida();
        char[][] taullelMètode = joc.taulell;
        char[][] taullelDeTesting= new char[3][3];
        Assertions.assertArrayEquals(taullelDeTesting,taullelMètode);
    }

    @org.junit.jupiter.api.Test
    void novaPartida_jugador() {

        Joc joc = new Joc();
        joc.novaPartida();
        char[][] taullelMètode = joc.taulell;
        char[][] taullelDeTesting= new char[3][3];
        short turnoTesting= 1;
        short turnoMetodo = joc.getTorn();
        Assertions.assertArrayEquals(taullelDeTesting,taullelMètode);
        Assertions.assertEquals(turnoTesting,turnoMetodo);
    }

    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1", "1,2", "2,0", "2,1", "2,2"})
    void jugar_primera(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.jugar(fila, columna);
        Assertions.assertEquals('X', joc.taulell[fila][columna]);
    }

    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1", "1,2", "2,0", "2,1", "2,2"})
    void jugar_segona(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.torn = 2;
        joc.jugar(fila, columna);
        Assertions.assertEquals('O', joc.taulell[fila][columna]);
    }

    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1", "1,2", "2,0", "2,1", "2,2"})
    void jugar_segona_bloquejada(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.jugar(fila, columna);
        joc.jugar(fila, columna);
        Assertions.assertEquals('X', joc.taulell[fila][columna]);
    }

    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1", "1,2", "2,0", "2,1", "2,2"})
    void jugar_tercera_bloquejada(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.torn = 2;
        joc.jugar(fila, columna);
        joc.jugar(fila, columna);
        Assertions.assertEquals('O', joc.taulell[fila][columna]);
    }

    @Test
    void verificaJugada() {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.verificaJugada(0,0, joc.taulell);

    }
    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1", "1,2", "2,0", "2,1", "2,2"})
    void jugada_guanyadora_buit(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida();
        Assertions.assertFalse(joc.jugadaGuanyadora(fila, columna));
    }

    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1", "1,2", "2,0", "2,1", "2,2"})
    void jugada_guanyadora_1(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.taulell[1][1] = 'X';
        Assertions.assertFalse(joc.jugadaGuanyadora(fila, columna));
    }

    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1", "1,2", "2,0", "2,1", "2,2"})
    void jugada_guanyadora_2(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.taulell[1][1] = 'X';
        joc.taulell[1][0] = 'X';
        if (joc.taulell[1][2] == 'X') Assertions.assertTrue(joc.jugadaGuanyadora(fila, columna));
        else Assertions.assertFalse(joc.jugadaGuanyadora(fila, columna));
    }

    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1", "1,2", "2,0", "2,1", "2,2"})
    void jugada_guanyadora_horizontal(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.taulell[1][1] = 'X';
        joc.taulell[1][0] = 'X';
        if (joc.taulell[1][2] == 'X') Assertions.assertTrue(joc.jugadaGuanyadora(fila, columna));
        else Assertions.assertFalse(joc.jugadaGuanyadora(fila, columna));
    }

    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1", "1,2", "2,0", "2,1", "2,2"})
    void jugada_guanyadora_diagonal(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.taulell[0][2] = 'X';
        joc.taulell[1][1] = 'X';
        if (joc.taulell[2][0] == 'X') Assertions.assertTrue(joc.jugadaGuanyadora(fila, columna));
        else Assertions.assertFalse(joc.jugadaGuanyadora(fila, columna));
    }

    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1", "1,2", "2,0", "2,1", "2,2"})
    void jugada_guanyadora_vertical(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.taulell[0][1] = 'X';
        joc.taulell[1][1] = 'X';
        if (joc.taulell[2][1] == 'X') Assertions.assertTrue(joc.jugadaGuanyadora(fila, columna));
        else Assertions.assertFalse(joc.jugadaGuanyadora(fila, columna));
    }

    @Test
    void victoriaHorizontal() {
        Joc joc = new Joc();
        joc.novaPartida();
        char[][] taullelEjemplo={{'X','X','X',},{'O','X','O'},{'X','O','O'}};
        Assertions.assertTrue(joc.victoriaHorizontal(taullelEjemplo,0,1));

    }

    @Test
    void victoriaVertical() {
        Joc joc = new Joc();
        joc.novaPartida();
        char[][] taullelEjemplo={{'X','X','O',},{'O','X','O'},{'X','X','_'}};
        Assertions.assertTrue(joc.victoriaVertical(taullelEjemplo,1,1));
    }

    @Test
    void victoriaDiagonalSuperior() {
        Joc joc = new Joc();
        joc.novaPartida();
        char[][] taullelEjemplo={{'X','O','X',},{'O','X','O'},{'X','O','_'}};
        Assertions.assertTrue(joc.victoriaDiagonalSuperior(taullelEjemplo,1,1));
    }

    @Test
    void victoriaDiagonalInferior() {
        Joc joc = new Joc();
        joc.novaPartida();
        char[][] taullelEjemplo={{'X','_','X',},{'O','X','O'},{'X','X','_'}};
        Assertions.assertTrue(joc.victoriaDiagonalInferior(taullelEjemplo,1,1));
    }
}