package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CasilleroTest {

    @Test
    public void casilleroVacioDeberiaEstarVacio() {
        Casillero casillero = new Casillero(1, 1);

        Assert.assertTrue(casillero.estaVacio());
    }

    @Test
    public void casilleroConBarcoNoEstaVacio() {
        Casillero casillero = new Casillero(2, 2);
        Barco barco = new Barco(23);
        casillero.ponerBarco(barco);

        Assert.assertFalse(casillero.estaVacio());
    }

    @Test
    public void casilleroRecibeSuPosicionEnConstructorYparaLuegoSolicitarla() {
        int fila = 2;
        int columna = 2;
        Casillero unCasillero = new Casillero(fila, columna);
        Assert.assertEquals(2, unCasillero.dameTuPosicioHorizontal());
        Assert.assertEquals(2, unCasillero.dameTuPosicioVertical());
    }

    @Test
    public void asignarBoteACasilleroYRecuperarTamanioDelBote() {
        int fila = 2;
        int columna = 2;
        Barco unBote = new Barco(1);
        Casillero unCasillero = new Casillero(fila, columna);
        unCasillero.ponerBarco(unBote);
        Assert.assertEquals(1, unCasillero.dameElBarco().obtenerTamanio());
    }

    @Test
    public void casilleroDisponibleSiNoRecibioDisparoASuPosicion() {
        int fila = 2;
        int columna = 2;
        Casillero unCasillero = new Casillero(fila, columna);
        Assert.assertTrue(unCasillero.estadoCasillero());
    }

    @Test
    public void casilleroDisponibleHastaQueRecibeDisparo() {
        int fila = 2;
        int columna = 2;
        Casillero unCasillero = new Casillero(fila, columna);
        Assert.assertTrue(unCasillero.estadoCasillero());
        unCasillero.recibirDisparo();
        Assert.assertFalse(unCasillero.estadoCasillero());
    }

}
