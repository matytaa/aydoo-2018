package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class LibreriaTest {
    @Test
    public void crearLibreriaVaciaYSolicitarLaCantidadDeProductos_debeDarCero() {
        Libreria miLibreria = new Libreria();
        Assert.assertEquals(0, miLibreria.cantidadDeProductos());
    }

    @Test
    public void almacenarUnLibroYSolicitarLaCantidadDeLibros() {
        Libreria miLibreria = new Libreria();
        Libro biblografiaDBZ = new Libro(10);
        miLibreria.agregarUnProducto(biblografiaDBZ);
        Assert.assertEquals(1, miLibreria.cantidadDeProductos());
    }

    @Test
    public void almacenarUnaRevistaYSolicitarLacantidadDeProductos() {
        Libreria miLibreria = new Libreria();
        Periodico revistaDBZ = new Periodico(10, 3);
        miLibreria.agregarUnProducto(revistaDBZ);
        Assert.assertEquals(1, miLibreria.cantidadDeProductos());
    }

    @Test
    public void almacenarUnArticuloDeLibreriaYSolicitarLaCantidadDeArticulosDeLibreria() {
        Libreria miLibreria = new Libreria();
        ArticuloLibreria albumDBZ = new ArticuloLibreria(10, 10);
        miLibreria.agregarUnProducto(albumDBZ);
        Assert.assertEquals(1, miLibreria.cantidadDeProductos());
    }

    @Test
    public void clienteCompraYLuegoCantidadDeLibrosDebeDarCero() {
        Libreria miLibreria = new Libreria();
        Libro biblografiaDBZ = new Libro(10);
        miLibreria.agregarUnProducto(biblografiaDBZ);
        Cliente unCliente = new Cliente("Rafeal Nadal", "Vinateros 954");
        Date fechaDeVenta = new Date();
        Venta unaVenta = new Venta(unCliente, biblografiaDBZ, fechaDeVenta);
        miLibreria.registrarVenta(unaVenta);
    }

    @Test
    public void generarVentasYSolicitarLasVentasDelMesDeMarzoDeKimi() {
        Calendar unaFecha = Calendar.getInstance();
        unaFecha.set(2018, 3, 17);
        Date fechaDeVenta = unaFecha.getTime();

        Cliente kimiRaikkonen = new Cliente("Kimi Raikkonen", "Spa-Francorchamps");
        Libro eauRouge = new Libro(100);
        Venta venta1 = new Venta(kimiRaikkonen, eauRouge, fechaDeVenta);

        unaFecha.set(2018, 2, 17);
        fechaDeVenta = unaFecha.getTime();
        ArticuloLibreria parabolica = new ArticuloLibreria(90, 21);
        Venta venta2 = new Venta(kimiRaikkonen, parabolica, fechaDeVenta);

        unaFecha.set(2018, 2, 7);
        fechaDeVenta = unaFecha.getTime();
        Periodico rectaPrincipal = new Periodico(90, 3);
        Venta venta3 = new Venta(kimiRaikkonen, rectaPrincipal, fechaDeVenta);

        unaFecha.set(2018, 2, 27);
        fechaDeVenta = unaFecha.getTime();
        Libro boxes = new Libro(90);
        Venta venta4 = new Venta(kimiRaikkonen, boxes, fechaDeVenta);

        Libreria miLibreria = new Libreria();
        miLibreria.registrarVenta(venta1);
        miLibreria.registrarVenta(venta2);
        miLibreria.registrarVenta(venta3);
        miLibreria.registrarVenta(venta4);
        Double resultado = 270.0;

        Assert.assertEquals(resultado,miLibreria.ventasDelMesAnioDeUnCliente(kimiRaikkonen, 3, 2018));
    }

    @Test
    public void generarVentasYSolicitarLasVentasDelMesDeMarzoDeVettel() {
        Calendar unaFecha = Calendar.getInstance();
        unaFecha.set(2018, 3, 17);
        Date fechaDeVenta = unaFecha.getTime();

        Cliente kimiRaikkonen = new Cliente("Kimi Raikkonen", "Spa-Francorchamps");
        Cliente sebastianVettel = new Cliente("Sebastian Vettel", "Monza");
        Libro eauRouge = new Libro(100);
        Venta venta1 = new Venta(kimiRaikkonen, eauRouge, fechaDeVenta);

        unaFecha.set(2018, 2, 17);
        fechaDeVenta = unaFecha.getTime();
        ArticuloLibreria parabolica = new ArticuloLibreria(90, 21);
        Venta venta2 = new Venta(sebastianVettel, parabolica, fechaDeVenta);

        unaFecha.set(2018, 2, 7);
        fechaDeVenta = unaFecha.getTime();
        Periodico rectaPrincipal = new Periodico(90, 3);
        Venta venta3 = new Venta(sebastianVettel, rectaPrincipal, fechaDeVenta);

        unaFecha.set(2018, 2, 27);
        fechaDeVenta = unaFecha.getTime();
        Libro boxes = new Libro(90);
        Venta venta4 = new Venta(kimiRaikkonen, boxes, fechaDeVenta);

        Libreria miLibreria = new Libreria();
        miLibreria.registrarVenta(venta1);
        miLibreria.registrarVenta(venta2);
        miLibreria.registrarVenta(venta3);
        miLibreria.registrarVenta(venta4);
        Double resultado = 180.0;

        Assert.assertEquals(resultado,miLibreria.ventasDelMesAnioDeUnCliente(sebastianVettel, 3, 2018));
    }
}
