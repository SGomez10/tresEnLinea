import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

    @org.junit.jupiter.api.Test
    void jugar_primera_00() {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.jugar((short) 0, (short) 0);
        Assertions.assertEquals('X', joc.taulell[0][0]);
    }

    @Test
    void verificaJugada() {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.verificaJugada((short)0,(short)0, joc.taulell);

    }
}