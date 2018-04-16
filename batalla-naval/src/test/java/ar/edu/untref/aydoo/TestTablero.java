package ar.edu.untref.aydoo;

import gherkin.lexer.Ca;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestTablero {
<<<<<<< HEAD

    @Test
    public void sfsdf() {
        Tablero tablero = new Tablero();

        for (int columna = 0; columna < tablero.cantidadColumnas(); columna++) {
            for (int fila = 0; fila < tablero.cantidadFilas(); fila++) {
                Assert.assertFalse(tablero.hayBarcoEnPosicion(columna, fila));
            }
        }
    }
=======
>>>>>>> batalla-naval

    Tablero tablero;
    Bote unBote;
    Casillero casilleroADisparar;
    ResultadoDelDisparo miDisparo;

    @Before
    public void setUp() {
        tablero = new Tablero();
        unBote = new Bote(1);
        casilleroADisparar = new Casillero(4, 4);
    }

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
        Assert.assertEquals(25, tablero.verificarCasilleros());
    }

    @Test
    public void se_dispara_a_casillero_vacio_y_el_resultado_es_agua() {
        miDisparo = tablero.disparar(casilleroADisparar);
        Assert.assertEquals(ResultadoDelDisparo.AGUA, miDisparo);
    }

    @Test
    public void se_dispara_a_un_bote_y_su_estado_es_hundido() {
        casilleroADisparar.ponerBarco(unBote);
        tablero.llenarCasillero(casilleroADisparar);
        miDisparo = tablero.disparar(casilleroADisparar);
        Assert.assertEquals(ResultadoDelDisparo.HUNDIDO, miDisparo);
    }

    @Test
    public void se_dispara_a_un_cruzero_y_su_estado_es_tocado() {
        Crucero unCruzero = new Crucero(2, Sentido.HORIZONTAL);
        casilleroADisparar.ponerBarco(unCruzero);
        tablero.llenarCasillero(casilleroADisparar);
        ResultadoDelDisparo miDisparo = tablero.disparar(casilleroADisparar);
        Assert.assertEquals(ResultadoDelDisparo.TOCADO, miDisparo);
    }

    @Test(expected = Exception.class)
    public void disparar_mas_de_una_vez_a_un_casillero_lanza_excepcion_movimiento_no_permitido() {
        miDisparo = tablero.disparar(casilleroADisparar);
        Assert.assertEquals(ResultadoDelDisparo.AGUA, miDisparo);
        tablero.disparar(casilleroADisparar);
    }

    @Test
    public void no_permitir_poner_barco_horizontal_de_tamanio_mayor_a_1_en_ultima_columna() {
        Assert.assertFalse(tablero.verificarLimites(3,4,Sentido.HORIZONTAL,1));
    }

    @Test
    public void permitir_poner_barco_horizontal_de_tamanio_mayor_a_1_en_anteultima_columna() {
        Assert.assertTrue(tablero.verificarLimites(3,3,Sentido.HORIZONTAL,1));
    }

    @Test
    public void no_permitir_poner_barco_vertical_de_tamanio_mayor_a_1_en_ultima_fila() {
        Assert.assertFalse(tablero.verificarLimites(4,4,Sentido.VERTICAL,1));
    }

    @Test
    public void permitir_poner_barco_vertical_de_tamanio_mayor_a_1_en_anteultima_fila() {
        Assert.assertTrue(tablero.verificarLimites(3,3,Sentido.VERTICAL,1));
    }

    @Test
    public void poner_Crucero_Horizontal_En_Casilleros_Consecutivos (){
        Crucero unCrucero = new Crucero(2,Sentido.HORIZONTAL);
        Casillero unCasillero = new Casillero(2,2);
        tablero.ponerBarcoEnCasillero(unCrucero,unCasillero);
        Assert.assertFalse(tablero.casilleroEstaVacion(2,2));
        Assert.assertFalse(tablero.casilleroEstaVacion(2,3));
    }

    @Test
    public void poner_Crucero_Vertical_En_Casilleros_Consecutivos (){
        Crucero unCrucero = new Crucero(2,Sentido.VERTICAL);
        Casillero unCasillero = new Casillero(2,2);
        tablero.ponerBarcoEnCasillero(unCrucero,unCasillero);
        Assert.assertFalse(tablero.casilleroEstaVacion(2,2));
        Assert.assertFalse(tablero.casilleroEstaVacion(3,2));
    }
}
