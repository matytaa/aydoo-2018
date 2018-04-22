package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class CompraTest {

    @Test
    public void almacenarUnLibroYSolicitarLaCantidadDeLibros() {
        Compra miCompra = new Compra(null,null);
        Libro biblografiaDBZ = new Libro(10);
        miCompra.agregarUnProducto(biblografiaDBZ);
        Assert.assertEquals(1,miCompra.cantidadDeProductos());
    }

    @Test
    public void almacenarUnaRevistaYSolicitarLacantidadDeProductos() {
        Compra miCompra = new Compra(null,null);
        Periodico revistaDBZ = new Periodico(10, 3);
        miCompra.agregarUnProducto(revistaDBZ);
        Assert.assertEquals(1,miCompra.cantidadDeProductos());
    }

    @Test
    public void almacenarUnArticuloDeCompraYSolicitarLaCantidadDeArticulosDeCompra() {
        Compra miCompra = new Compra(null,null);
        ArticuloLibreria albumDBZ = new ArticuloLibreria(10, 10);
        miCompra.agregarUnProducto(albumDBZ);
        Assert.assertEquals(1,miCompra.cantidadDeProductos());
    }

    @Test
    public void generarUnaCompraYSolicitarLaCantidadDeProductos() {
        Cliente kimiRaikkonen = new Cliente("Kimi Raikkonen", "Spa-Francorchamps");
        Libro eauRouge = new Libro(100);
        Calendar unaFecha = Calendar.getInstance();
        unaFecha.set(2018, 3, 17);
        Date fechaDeVenta = unaFecha.getTime();
        Compra unaCompra = new Compra(kimiRaikkonen, fechaDeVenta);
        unaCompra.agregarUnProducto(eauRouge);
        Assert.assertEquals(1, unaCompra.cantidadDeProductos());
    }

    @Test
    public void verificarVentaPertenecienteAlMesDeAbril() {
        Calendar unaFecha = Calendar.getInstance();
        unaFecha.set(2018, 3, 17);
        Date fechaDeVenta = unaFecha.getTime();

        Cliente kimiRaikkonen = new Cliente("Kimi Raikkonen", "Spa-Francorchamps");
        Libro eauRouge = new Libro(100);
        Compra unaCompra = new Compra(kimiRaikkonen, fechaDeVenta);
        unaCompra.agregarUnProducto(eauRouge);
        Assert.assertTrue(unaCompra.perteneceAlMes(4));
    }

    @Test
    public void verificarVentaPertenecienteAlAnio2018() {
        Calendar unaFecha = Calendar.getInstance();
        unaFecha.set(2018, 3, 17);
        Date fechaDeVenta = unaFecha.getTime();

        Cliente kimiRaikkonen = new Cliente("Kimi Raikkonen", "Spa-Francorchamps");
        Libro eauRouge = new Libro(100);
        Compra unaCompra = new Compra(kimiRaikkonen, fechaDeVenta);
        unaCompra.agregarUnProducto(eauRouge);
        Assert.assertTrue(unaCompra.perteneceAlAnio(2018));
    }

    @Test
    public void verificarVentaPertenecienteAlAnio2018MesAbril() {
        Calendar unaFecha = Calendar.getInstance();
        unaFecha.set(2018, 3, 17);
        Date fechaDeVenta = unaFecha.getTime();

        Cliente kimiRaikkonen = new Cliente("Kimi Raikkonen", "Spa-Francorchamps");
        Libro eauRouge = new Libro(100);
        Compra unaCompra = new Compra(kimiRaikkonen, fechaDeVenta);
        unaCompra.agregarUnProducto(eauRouge);
        Assert.assertTrue(unaCompra.perteneceAlPeriodo(2018, 4));
    }

    @Test
    public void crearUnaVentaYSolicitarElCliente() {
        Calendar unaFecha = Calendar.getInstance();
        unaFecha.set(2018, 3, 17);
        Date fechaDeVenta = unaFecha.getTime();

        Cliente kimiRaikkonen = new Cliente("Kimi Raikkonen", "Spa-Francorchamps");
        Libro eauRouge = new Libro(100);
        Compra unaCompra = new Compra(kimiRaikkonen, fechaDeVenta);
        unaCompra.agregarUnProducto(eauRouge);
        Assert.assertEquals(kimiRaikkonen, unaCompra.darCliente());
    }

}
