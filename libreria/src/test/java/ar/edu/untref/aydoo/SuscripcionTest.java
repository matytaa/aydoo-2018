package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class SuscripcionTest {
    @Test
    public void generarUnaSuscripcion() {
        Periodico rectaPrincipal = new Periodico(90.0, 3);
        Suscripcion unaSuscripcion = new Suscripcion(rectaPrincipal);
        Assert.assertEquals(rectaPrincipal, unaSuscripcion.darPeriodico());
    }

    @Test
    public void darPrecioBonificadoDeLaSuscripciom() {
        Periodico rectaPrincipal = new Periodico(90.0, 3);
        Suscripcion unaSuscripcion = new Suscripcion(rectaPrincipal);
        Double precioBonificado = 75.0;
        Assert.assertEquals(precioBonificado, unaSuscripcion.darPrecioBonificado(),0.1);
    }
}
