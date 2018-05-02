package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TableroTest {

    Tablero tablero;
    Barco unBote;
    Casillero casilleroADisparar;
    ResultadoDelDisparo miDisparo;

    @Before
    public void setUp() {
        tablero = new Tablero();
        unBote = new Barco(1);
        casilleroADisparar = new Casillero(4, 4);
    }

    @Test
    public void casilleroTableroNullDebeDarQueNoHayBarcoEnCasillero() {
        Tablero tablero = new Tablero();
        for (int columna = 0; columna < tablero.cantidadColumnas(); columna++) {
            for (int fila = 0; fila < tablero.cantidadFilas(); fila++) {
                Assert.assertTrue(tablero.casilleroEstaVacion(fila, columna));
            }
        }
    }

    @Test
    public void inicializarTableroYCasillerosConSusRespectivasPosiciones() {
        Assert.assertEquals(25, tablero.verificarCasilleros());
    }

    @Test
    public void seDisparaAcasilleroVacioYElResultadoEsAgua() {
        miDisparo = tablero.disparar(casilleroADisparar);
        Assert.assertEquals(ResultadoDelDisparo.AGUA, miDisparo);
    }

    @Test
    public void seDisparaAUnBoteYSuEstadoEsHundido() {
        casilleroADisparar.ponerBarco(unBote);
        tablero.llenarCasillero(casilleroADisparar);
        miDisparo = tablero.disparar(casilleroADisparar);
        Assert.assertEquals(ResultadoDelDisparo.HUNDIDO, miDisparo);
    }

    @Test
    public void seDisparaAUnCruzeroYSuEstadoEsTocado() {
        Crucero unCruzero = new Crucero(2, Sentido.HORIZONTAL);
        casilleroADisparar.ponerBarco(unCruzero);
        tablero.llenarCasillero(casilleroADisparar);
        ResultadoDelDisparo miDisparo = tablero.disparar(casilleroADisparar);
        Assert.assertEquals(ResultadoDelDisparo.TOCADO, miDisparo);
    }

    @Test(expected = Exception.class)
    public void dispararMasDeUnaVezAUnCasilleroLanzaExcepcionMovimientoNoPermitido() {
        miDisparo = tablero.disparar(casilleroADisparar);
        Assert.assertEquals(ResultadoDelDisparo.AGUA, miDisparo);
        tablero.disparar(casilleroADisparar);
    }

    @Test
    public void noPermitirPonerBarcoHorizontalDeTamanioMayorA1EnUltimaColumna() {
        Assert.assertFalse(tablero.verificarLimites(3,4,Sentido.HORIZONTAL,1));
    }

    @Test
    public void permitirPonerBarcoHorizontalDeTamanioMayorA1EnAnteultimaColumna() {
        Assert.assertTrue(tablero.verificarLimites(3,3,Sentido.HORIZONTAL,1));
    }

    @Test
    public void noPermitirPonerBarcoVerticalDeTamanioMayorA1EnUltimaFila() {
        Assert.assertFalse(tablero.verificarLimites(4,4,Sentido.VERTICAL,1));
    }

    @Test
    public void permitirPonerBarcoVerticalDeTamanioMayorA1EnAnteultimaFila() {
        Assert.assertTrue(tablero.verificarLimites(3,3,Sentido.VERTICAL,1));
    }

    @Test
    public void ponerCruceroHorizontalEnCasillerosConsecutivos (){
        Crucero unCrucero = new Crucero(2,Sentido.HORIZONTAL);
        Casillero unCasillero = new Casillero(2,2);
        tablero.ponerBarcoEnCasillero(unCrucero,unCasillero);
        Assert.assertFalse(tablero.casilleroEstaVacion(2,2));
        Assert.assertFalse(tablero.casilleroEstaVacion(2,3));
    }

    @Test
    public void ponerCruceroVerticalEnCasillerosConsecutivos (){
        Crucero unCrucero = new Crucero(2,Sentido.VERTICAL);
        Casillero unCasillero = new Casillero(2,2);
        tablero.ponerBarcoEnCasillero(unCrucero,unCasillero);
        Assert.assertFalse(tablero.casilleroEstaVacion(2,2));
        Assert.assertFalse(tablero.casilleroEstaVacion(3,2));
    }
}
