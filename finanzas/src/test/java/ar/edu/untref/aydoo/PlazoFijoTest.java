package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;

public class PlazoFijoTest {

    @Test
    public void deberiaObtenerGanaciasDelPlazoFijo(){
        PlazoFijo unPlazoFijo = new PlazoFijo(15d,30,10d);
        Double resultado = unPlazoFijo.obtenerGanacias(31);
        Assert.assertEquals(1.5, resultado, 0.001);
    }
}
