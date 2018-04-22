package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class CompraTest {
    @Test
    public void generarUnaVentaYSolicitarMontoDeVenta() {
        Cliente kimiRaikkonen = new Cliente("Kimi Raikkonen", "Spa-Francorchamps");
        Libro eauRouge = new Libro(100);
        Calendar unaFecha = Calendar.getInstance();
        unaFecha.set(2018, 3, 17);
        Date fechaDeVenta = unaFecha.getTime();
        Compra unaCompra = new Compra(kimiRaikkonen, eauRouge, fechaDeVenta);
        Assert.assertEquals(100, unaCompra.darProducto().darPrecio());
    }

    @Test
    public void verificarVentaPertenecienteAlMesDeAbril() {
        Calendar unaFecha = Calendar.getInstance();
        unaFecha.set(2018, 3, 17);
        Date fechaDeVenta = unaFecha.getTime();

        Cliente kimiRaikkonen = new Cliente("Kimi Raikkonen", "Spa-Francorchamps");
        Libro eauRouge = new Libro(100);
        Compra unaCompra = new Compra(kimiRaikkonen, eauRouge, fechaDeVenta);
        Assert.assertTrue(unaCompra.perteneceAlMes(4));
    }

    @Test
    public void verificarVentaPertenecienteAlAnio2018() {
        Calendar unaFecha = Calendar.getInstance();
        unaFecha.set(2018, 3, 17);
        Date fechaDeVenta = unaFecha.getTime();

        Cliente kimiRaikkonen = new Cliente("Kimi Raikkonen", "Spa-Francorchamps");
        Libro eauRouge = new Libro(100);
        Compra unaCompra = new Compra(kimiRaikkonen, eauRouge, fechaDeVenta);
        Assert.assertTrue(unaCompra.perteneceAlAnio(2018));
    }

    @Test
    public void verificarVentaPertenecienteAlAnio2018MesAbril() {
        Calendar unaFecha = Calendar.getInstance();
        unaFecha.set(2018, 3, 17);
        Date fechaDeVenta = unaFecha.getTime();

        Cliente kimiRaikkonen = new Cliente("Kimi Raikkonen", "Spa-Francorchamps");
        Libro eauRouge = new Libro(100);
        Compra unaCompra = new Compra(kimiRaikkonen, eauRouge, fechaDeVenta);
        Assert.assertTrue(unaCompra.perteneceAlPeriodo(2018, 4));
    }

    @Test
    public void crearUnaVentaYSolicitarElCliente() {
        Calendar unaFecha = Calendar.getInstance();
        unaFecha.set(2018, 3, 17);
        Date fechaDeVenta = unaFecha.getTime();

        Cliente kimiRaikkonen = new Cliente("Kimi Raikkonen", "Spa-Francorchamps");
        Libro eauRouge = new Libro(100);
        Compra unaCompra = new Compra(kimiRaikkonen, eauRouge, fechaDeVenta);
        Assert.assertEquals(kimiRaikkonen, unaCompra.darCliente());
    }

    @Test
    public void verificarExistenciaDeProducto() {
        Calendar unaFecha = Calendar.getInstance();
        unaFecha.set(2018, 3, 17);
        Date fechaDeVenta = unaFecha.getTime();

        Cliente kimiRaikkonen = new Cliente("Kimi Raikkonen", "Spa-Francorchamps");
        Libro eauRouge = new Libro(100);
        Compra unaCompra = new Compra(kimiRaikkonen, eauRouge, fechaDeVenta);
        Assert.assertEquals(eauRouge, unaCompra.darProducto());
    }
}
