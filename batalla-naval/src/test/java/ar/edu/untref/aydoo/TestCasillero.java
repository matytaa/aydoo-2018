package ar.edu.untref.aydoo;

import static org.junit.Assert.assertTrue;

import gherkin.lexer.Ca;
import org.junit.Assert;
import org.junit.Test;

public class TestCasillero {

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
        int horizontal = 2;
        int vertical = 2;
        Casillero unCasillero = new Casillero(horizontal, vertical);
        Assert.assertEquals(2, unCasillero.dameTuPosicioHorizontal());
        Assert.assertEquals(2, unCasillero.dameTuPosicioVertical());
    }

    @Test
    public void asignar_bote_a_casillero_y_recuperar_tamanio_del_bote() {
        int horizontal = 2;
        int vertical = 2;
        Bote unBote = new Bote(1);
        Casillero unCasillero = new Casillero(horizontal, vertical);
        unCasillero.ponerBarco(unBote);
        Assert.assertEquals(1, unCasillero.dameElBarco().obtenerTamanio());
    }

}
