package ar.edu.untref.aydoo;

import cucumber.api.java.eo.Do;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class LibreriaTest {

    @Test
    public void generarComprasYSolicitarLasComprasDelMesDeMarzoDeKimi() {
        Calendar unaFecha = Calendar.getInstance();
        unaFecha.set(2018, 2, 17);
        Date fechaDeCompra = unaFecha.getTime();

        Cliente kimiRaikkonen = new Cliente("Kimi Raikkonen", "Spa-Francorchamps");
        Libro eauRouge = new Libro(100.0);
        Compra unaCompra = new Compra(kimiRaikkonen, fechaDeCompra);
        unaCompra.agregarUnProducto(eauRouge);

        unaFecha.set(2018, 2, 17);
        ArticuloLibreria parabolica = new ArticuloLibreria(90.0, 21);
        unaCompra.agregarUnProducto(parabolica);

        unaFecha.set(2018, 2, 7);
        Periodico rectaPrincipal = new Periodico(90.0, 3);
        unaCompra.agregarUnProducto(rectaPrincipal);

        unaFecha.set(2018, 2, 27);
        Libro boxes = new Libro(90.0);
        unaCompra.agregarUnProducto(boxes);

        Libreria miLibreria = new Libreria();
        miLibreria.registrarCompra(unaCompra);
        Double resultado = 388.9;

        Assert.assertEquals(resultado, miLibreria.comprasDelMesAnioDeUnCliente(kimiRaikkonen, 3, 2018), 0.1);
    }

    @Test
    public void generarComprasYSolicitarLasComprasDelMesDeMarzoDeVettel() {
        Calendar unaFecha = Calendar.getInstance();
        unaFecha.set(2018, 3, 17);
        Date fechaDeCompra = unaFecha.getTime();

        Cliente kimiRaikkonen = new Cliente("Kimi Raikkonen", "Spa-Francorchamps");
        Cliente sebastianVettel = new Cliente("Sebastian Vettel", "Monza");
        Libro eauRouge = new Libro(100.0);
        Compra compra1 = new Compra(kimiRaikkonen, fechaDeCompra);
        compra1.agregarUnProducto(eauRouge);

        unaFecha.set(2018, 2, 17);
        fechaDeCompra = unaFecha.getTime();
        ArticuloLibreria parabolica = new ArticuloLibreria(90.0, 21);
        Compra compra2 = new Compra(sebastianVettel, fechaDeCompra);
        compra2.agregarUnProducto(parabolica);

        Periodico rectaPrincipal = new Periodico(90.0, 3);
        compra2.agregarUnProducto(rectaPrincipal);

        Libro boxes = new Libro(90.0);
        compra1.agregarUnProducto(boxes);

        Libreria miLibreria = new Libreria();
        miLibreria.registrarCompra(compra1);
        miLibreria.registrarCompra(compra2);
        Double resultado = 198.89;

        Assert.assertEquals(resultado, miLibreria.comprasDelMesAnioDeUnCliente(sebastianVettel, 3, 2018), 0.01);
    }

    @Test
    public void generarComprasYSolicitarLasComprasDelAnioDeKimi() {
        Calendar unaFecha = Calendar.getInstance();
        Cliente kimiRaikkonen = new Cliente("Kimi Raikkonen", "Spa-Francorchamps");

        unaFecha.set(2018, Calendar.JANUARY, 17);
        Date fechaDeCompra = unaFecha.getTime();
        Libro eauRouge = new Libro(100.0);
        Compra compra1 = new Compra(kimiRaikkonen, fechaDeCompra);
        compra1.agregarUnProducto(eauRouge);

        unaFecha.set(2018, Calendar.JUNE, 17);
        fechaDeCompra = unaFecha.getTime();
        ArticuloLibreria parabolica = new ArticuloLibreria(90.0, 21);
        Compra compra2 = new Compra(kimiRaikkonen, fechaDeCompra);
        compra2.agregarUnProducto(parabolica);

        unaFecha.set(2018, Calendar.OCTOBER, 17);
        fechaDeCompra = unaFecha.getTime();
        Periodico rectaPrincipal = new Periodico(90.0, 3);
        Compra compra3 = new Compra(kimiRaikkonen, fechaDeCompra);
        compra3.agregarUnProducto(rectaPrincipal);

        unaFecha.set(2018, Calendar.DECEMBER, 17);
        fechaDeCompra = unaFecha.getTime();
        Libro boxes = new Libro(90.0);
        Compra compra4 = new Compra(kimiRaikkonen, fechaDeCompra);
        compra4.agregarUnProducto(boxes);

        Libreria miLibreria = new Libreria();
        miLibreria.registrarCompra(compra1);
        miLibreria.registrarCompra(compra2);
        miLibreria.registrarCompra(compra3);
        miLibreria.registrarCompra(compra4);
        Double resultado = 388.90;

        Assert.assertEquals(resultado, miLibreria.comprasDelAnioDeUnCliente(kimiRaikkonen, 2018), 0.01);
    }

    @Test
    public void verificarInstanciasDePeriodicos() {
        Libro eauRouge = new Libro(100.0);
        ArticuloLibreria albumDBZ = new ArticuloLibreria(10.0, 10);
        Periodico rectaPrincipal = new Periodico(90.0, 3);

        Libreria miLibreria = new Libreria();

        Assert.assertFalse(miLibreria.esPeridioco(eauRouge));
        Assert.assertFalse(miLibreria.esPeridioco(albumDBZ));
        Assert.assertTrue(miLibreria.esPeridioco(rectaPrincipal));
    }

    @Test
    public void obtenerDescuentosDeLaListaDeSuscripciones() {
        Cliente kimiRaikkonen = new Cliente("Kimi Raikkonen", "Spa-Francorchamps");
        Periodico rectaPrincipal = new Periodico(90.0, 3);
        Periodico boxes = new Periodico(90.0, 2);
        Libreria miLibreria = new Libreria();

        Suscripcion unaSuscripcion = new Suscripcion(rectaPrincipal);
        kimiRaikkonen.comprarSuscripcion(unaSuscripcion);
        Double unResultado = 18.0;
        Assert.assertEquals(unResultado, miLibreria.aplicarDescuento(kimiRaikkonen, rectaPrincipal));
        unResultado = 0.0;
        Assert.assertEquals(unResultado, miLibreria.aplicarDescuento(kimiRaikkonen, boxes));
    }
}
