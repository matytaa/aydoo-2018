package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CruceroTest {
    @Test
    public void obtenerElSentidoDeUnCrucero(){
        Crucero unCruzero = new Crucero(2, Sentido.HORIZONTAL);
        Assert.assertEquals(Sentido.HORIZONTAL, unCruzero.obtenerSentido());
    }
}
