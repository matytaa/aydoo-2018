package ar.edu.untref.aydoo;

import gherkin.lexer.Ca;
import org.junit.Assert;
import org.junit.Test;


public class TestTablero {

    @Test
    public void casillero_tablero_null_debe_dar_que_no_hay_barco_en_casillero() {
        Tablero tablero = new Tablero();
        for (int columna = 0; columna < tablero.cantidadColumnas(); columna++) {
            for (int fila = 0; fila < tablero.cantidadFilas(); fila++) {
                Assert.assertTrue(tablero.casilleroEstaVacion(fila, columna));
            }
        }
    }

    @Test
    public void inicializar_tablero_y_casilleros_con_sus_respectivas_posiciones() {
        Tablero tablero = new Tablero();
        Assert.assertEquals(25, tablero.verificarCasilleros());
    }

    @Test
    public void se_dispara_a_casillero_vacio_y_el_resultado_es_agua() {
        Tablero tablero = new Tablero();
        Casillero casilleroADisparar = new Casillero(4, 4);
        ResultadoDelDisparo miDisparo = tablero.disparar(casilleroADisparar);
        Assert.assertEquals(ResultadoDelDisparo.AGUA, miDisparo);
    }

    @Test
    public void se_dispara_a_un_bote_y_su_estado_es_hundido() {
        Tablero tablero = new Tablero();
        Bote unBote = new Bote(1);
        Casillero casilleroADisparar = new Casillero(4, 4);
        casilleroADisparar.ponerBarco(unBote);
        tablero.llenarCasillero(casilleroADisparar);
        ResultadoDelDisparo miDisparo = tablero.disparar(casilleroADisparar);
        Assert.assertEquals(ResultadoDelDisparo.HUNDIDO, miDisparo);
    }

    @Test
    public void se_dispara_a_un_cruzero_y_su_estado_es_tocado() {
        Tablero tablero = new Tablero();
        Crucero unCruzero = new Crucero(2, Sentido.HORIZONTAL);
        Casillero casilleroADisparar = new Casillero(4, 4);
        casilleroADisparar.ponerBarco(unCruzero);
        tablero.llenarCasillero(casilleroADisparar);
        ResultadoDelDisparo miDisparo = tablero.disparar(casilleroADisparar);
        Assert.assertEquals(ResultadoDelDisparo.TOCADO, miDisparo);
    }
}
