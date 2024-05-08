import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class JocTest {

    @org.junit.jupiter.api.Test
    void novaPartida_taulell() {

        Joc joc = new Joc();
        joc.novaPartida();
        char[][] taullelMètode = joc.getTaulell();
        char[][] taullelDeTesting= new char[3][3];
        Assertions.assertArrayEquals(taullelDeTesting,taullelMètode);
    }

    @org.junit.jupiter.api.Test
    void novaPartida_jugador() {

        Joc joc = new Joc();
        joc.novaPartida();
        char[][] taullelMètode = joc.getTaulell();
        char[][] taullelDeTesting= new char[3][3];
        int turnoTesting= 1;
        int turnoMetodo = joc.getTorn();
        Assertions.assertArrayEquals(taullelDeTesting,taullelMètode);
        Assertions.assertEquals(turnoTesting,turnoMetodo);
    }

    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1", "1,2", "2,0", "2,1", "2,2"})
    void jugar_primera(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.jugar(fila, columna);
        Assertions.assertEquals('X', joc.getPosicio(fila, columna));
    }

    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1", "1,2", "2,0", "2,1", "2,2"})
    void jugar_segona(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.setTorn(2);
        joc.jugar(fila, columna);
        Assertions.assertEquals('O', joc.getPosicio(fila, columna));
    }

    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1", "1,2", "2,0", "2,1", "2,2"})
    void jugar_segona_bloquejada(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.jugar(fila, columna);
        joc.jugar(fila, columna);
        Assertions.assertEquals('X', joc.getPosicio(fila, columna));
    }

    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "1,0", "1,1", "1,2", "2,0", "2,1", "2,2"})
    void jugar_tercera_bloquejada(int fila, int columna) {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.setTorn(2);
        joc.jugar(fila, columna);
        joc.jugar(fila, columna);
        Assertions.assertEquals('O', joc.getPosicio(fila, columna));
    }

    @Test
    void verificaJugada() {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.verificaJugada((short)0,(short)0, joc.getTaulell());

    }
}