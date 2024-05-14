import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class JocTest {

    @org.junit.jupiter.api.Test
    void novaPartida_taulell() {

        Joc joc = new Joc();
        joc.setTamany(3);
        joc.novaPartida();
        char[][] taullelMètode = joc.getTaulell();
        char[][] taullelDeTesting = new char[joc.getTamany()][joc.getTamany()];
        for (int fila = 0; fila < taullelDeTesting.length; fila++) {
            for (int columna = 0; columna < taullelDeTesting.length; columna++) {
                taullelDeTesting[fila][columna] = '_';
            }
        }
        Assertions.assertArrayEquals(taullelDeTesting,taullelMètode);
    }

    @org.junit.jupiter.api.Test
    void novaPartida_jugador() {

        Joc joc = new Joc();
        joc.setTamany(3);
        joc.novaPartida();
        char[][] taullelMètode = joc.getTaulell();
        char[][] taullelDeTesting= new char[joc.getTamany()][joc.getTamany()];
        for (int fila = 0; fila < taullelDeTesting.length; fila++) {
            for (int columna = 0; columna < taullelDeTesting.length; columna++) {
                taullelDeTesting[fila][columna] = '_';
            }
        }
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

    @ParameterizedTest
    @CsvSource({"0", "1", "2", "3"})
    void jugadaGuanyadoraBuit(int caso) {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.jugar(0, 0);
        Assertions.assertFalse(joc.jugadaGuanyadora(0, 0, joc.getTaulell(), caso));
    }

    @ParameterizedTest
    @CsvSource({"0", "1", "2", "3"})
    void jugadaGuanyadoraHorizontal(int caso) {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.jugar(0, 0);
        joc.setTorn(3);
        joc.jugar(0, 1);
        joc.setTorn(5);
        joc.jugar(0, 2);
        if (caso ==  0){
            Assertions.assertTrue(joc.jugadaGuanyadora(0, 2, joc.getTaulell(), caso));
        }
        else{
            Assertions.assertFalse(joc.jugadaGuanyadora(0, 2, joc.getTaulell(), caso));
        }
    }

    @ParameterizedTest
    @CsvSource({"0", "1", "2", "3"})
    void jugadaGuanyadoraHorizontalMal(int caso) {
        Joc joc = new Joc();
        joc.setTamany(5);
        joc.novaPartida();
        joc.jugar(0, 0);
        joc.setTorn(3);
        joc.jugar(0, 1);
        joc.setTorn(5);
        joc.jugar(0, 3);
        Assertions.assertFalse(joc.jugadaGuanyadora(0, 3, joc.getTaulell(), caso));
    }

    @ParameterizedTest
    @CsvSource({"0", "1", "2", "3"})
    void jugadaGuanyadoraVertical(int caso) {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.jugar(0, 0);
        joc.setTorn(3);
        joc.jugar(1, 0);
        joc.setTorn(5);
        joc.jugar(2, 0);
        if (caso ==  1){
            Assertions.assertTrue(joc.jugadaGuanyadora(2, 0, joc.getTaulell(), caso));
        }
        else{
            Assertions.assertFalse(joc.jugadaGuanyadora(2, 0, joc.getTaulell(), caso));
        }
    }

    @ParameterizedTest
    @CsvSource({"0", "1", "2", "3"})
    void jugadaGuanyadoraVerticalMal(int caso) {
        Joc joc = new Joc();
        joc.setTamany(5);
        joc.novaPartida();
        joc.jugar(0, 0);
        joc.setTorn(3);
        joc.jugar(1, 0);
        joc.setTorn(5);
        joc.jugar(3, 0);
        Assertions.assertFalse(joc.jugadaGuanyadora(2, 0, joc.getTaulell(), caso));
    }

    @ParameterizedTest
    @CsvSource({"0", "1", "2", "3"})
    void jugadaGuanyadoraDiagonal1(int caso) {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.jugar(2, 0);
        joc.setTorn(3);
        joc.jugar(1, 1);
        joc.setTorn(5);
        joc.jugar(0, 2);
        if (caso ==  2){
            Assertions.assertTrue(joc.jugadaGuanyadora(0, 2, joc.getTaulell(), caso));
        }
        else{
            Assertions.assertFalse(joc.jugadaGuanyadora(0, 2, joc.getTaulell(), caso));
        }
    }

    @ParameterizedTest
    @CsvSource({"0", "1", "2", "3"})
    void jugadaGuanyadoraDiagonal1Mal(int caso) {
        Joc joc = new Joc();
        joc.setTamany(5);
        joc.novaPartida();
        joc.jugar(4, 0);
        joc.setTorn(3);
        joc.jugar(3, 1);
        joc.setTorn(5);
        joc.jugar(1, 3);
        Assertions.assertFalse(joc.jugadaGuanyadora(1, 3, joc.getTaulell(), caso));
    }

    @ParameterizedTest
    @CsvSource({"0", "1", "2", "3"})
    void jugadaGuanyadoraDiagonal2(int caso) {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.jugar(0, 0);
        joc.setTorn(3);
        joc.jugar(1, 1);
        joc.setTorn(5);
        joc.jugar(2, 2);
        if (caso ==  3){
            Assertions.assertTrue(joc.jugadaGuanyadora(2, 2, joc.getTaulell(), caso));
        }
        else{
            Assertions.assertFalse(joc.jugadaGuanyadora(2, 2, joc.getTaulell(), caso));
        }
    }

    @ParameterizedTest
    @CsvSource({"0", "1", "2", "3"})
    void jugadaGuanyadoraDiagonal2Mal(int caso) {
        Joc joc = new Joc();
        joc.setTamany(5);
        joc.novaPartida();
        joc.jugar(0, 0);
        joc.setTorn(3);
        joc.jugar(1, 1);
        joc.setTorn(5);
        joc.jugar(3, 3);
        Assertions.assertFalse(joc.jugadaGuanyadora(3, 3, joc.getTaulell(), caso));
    }

    @Test
    void verificaJugada() {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.verificaJugada(0,0, joc.getTaulell());
    }
}