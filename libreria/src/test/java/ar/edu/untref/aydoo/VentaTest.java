package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class VentaTest {
    @Test
    public void generarUnaVentaYSolicitarMontoDeVenta() {
        Cliente kimiRaikkonen = new Cliente("Kimi Raikkonen", "Spa-Francorchamps");
        Libro eauRouge = new Libro(100);
        Calendar unaFecha = Calendar.getInstance();
        unaFecha.set(2018,3,17);
        Date fechaDeVenta = unaFecha.getTime();
        Venta unaVenta = new Venta(kimiRaikkonen,eauRouge, fechaDeVenta);
        Assert.assertEquals(100, unaVenta.darPrecioProducto());
    }

    @Test
    public void verificarVentaPertenecienteAlMesDeAbril() {
        Calendar unaFecha = Calendar.getInstance();
        unaFecha.set(2018,3,17);
        Date fechaDeVenta = unaFecha.getTime();

        Cliente kimiRaikkonen = new Cliente("Kimi Raikkonen", "Spa-Francorchamps");
        Libro eauRouge = new Libro(100);
        Venta unaVenta = new Venta(kimiRaikkonen,eauRouge, fechaDeVenta);
        Assert.assertTrue(unaVenta.perteneceAlMes(4));
    }

    @Test
    public void verificarVentaPertenecienteAlAnio2018() {
        Calendar unaFecha = Calendar.getInstance();
        unaFecha.set(2018,3,17);
        Date fechaDeVenta = unaFecha.getTime();

        Cliente kimiRaikkonen = new Cliente("Kimi Raikkonen", "Spa-Francorchamps");
        Libro eauRouge = new Libro(100);
        Venta unaVenta = new Venta(kimiRaikkonen,eauRouge, fechaDeVenta);
        Assert.assertTrue(unaVenta.perteneceAlAnio(2018));
    }

}
