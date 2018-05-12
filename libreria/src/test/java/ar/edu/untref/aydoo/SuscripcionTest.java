package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class SuscripcionTest {
    @Test
    public void generarUnaSuscripcion() {
        Periodico rectaPrincipal = new Periodico(90.0, 3);
        Suscripcion unaSuscripcion = new Suscripcion(rectaPrincipal, TipoSuscripcion.ANUAL);
        Assert.assertEquals(rectaPrincipal, unaSuscripcion.darPeriodico());
    }

    @Test
    public void deberiaDarElPrecioConSuscripcionAnual() {
        Periodico rectaPrincipal = new Periodico(90.0, 3);
        Suscripcion unaSuscripcion = new Suscripcion(rectaPrincipal, TipoSuscripcion.ANUAL);
        Double precioBonificado = -18.0;
        Assert.assertEquals(precioBonificado, unaSuscripcion.darPrecio(),0.1);
    }

    @Test
    public void elPrecioConSuscripcionMensualDeberiaDar0() {
        Periodico rectaPrincipal = new Periodico(90.0, 3);
        Suscripcion unaSuscripcion = new Suscripcion(rectaPrincipal, TipoSuscripcion.MENSUAL);
        Double precioBonificado = 0.0;
        Assert.assertEquals(precioBonificado, unaSuscripcion.darPrecio(),0.1);
    }

    @Test
    public void elPrecioConSuscripcionSemanalDeberiaDar0() {
        Periodico rectaPrincipal = new Periodico(90.0, 3);
        Suscripcion unaSuscripcion = new Suscripcion(rectaPrincipal, TipoSuscripcion.SEMANAL);
        Double precioBonificado = 0.0;
        Assert.assertEquals(precioBonificado, unaSuscripcion.darPrecio(),0.1);
    }

}
