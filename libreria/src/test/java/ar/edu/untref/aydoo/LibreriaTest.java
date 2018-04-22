package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class LibreriaTest {

    @Test
    public void generarVentasYSolicitarLasVentasDelMesDeMarzoDeKimi() {
        Calendar unaFecha = Calendar.getInstance();
        unaFecha.set(2018, 2, 17);
        Date fechaDeVenta = unaFecha.getTime();

        Cliente kimiRaikkonen = new Cliente("Kimi Raikkonen", "Spa-Francorchamps");
        Libro eauRouge = new Libro(100.0);
        Compra unaCompra = new Compra(kimiRaikkonen, fechaDeVenta);
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

        Assert.assertEquals(resultado,miLibreria.ventasDelMesAnioDeUnCliente(kimiRaikkonen, 3, 2018),0.1);
    }

    @Test
    public void generarVentasYSolicitarLasVentasDelMesDeMarzoDeVettel() {
        Calendar unaFecha = Calendar.getInstance();
        unaFecha.set(2018, 3, 17);
        Date fechaDeVenta = unaFecha.getTime();

        Cliente kimiRaikkonen = new Cliente("Kimi Raikkonen", "Spa-Francorchamps");
        Cliente sebastianVettel = new Cliente("Sebastian Vettel", "Monza");
        Libro eauRouge = new Libro(100.0);
        Compra compra1 = new Compra(kimiRaikkonen, fechaDeVenta);
        compra1.agregarUnProducto(eauRouge);

        unaFecha.set(2018, 2, 17);
        fechaDeVenta = unaFecha.getTime();
        ArticuloLibreria parabolica = new ArticuloLibreria(90.0, 21);
        Compra compra2 = new Compra(sebastianVettel, fechaDeVenta);
        compra2.agregarUnProducto(parabolica);

        Periodico rectaPrincipal = new Periodico(90.0, 3);
        compra2.agregarUnProducto(rectaPrincipal);

        Libro boxes = new Libro(90.0);
        compra1.agregarUnProducto(boxes);

        Libreria miLibreria = new Libreria();
        miLibreria.registrarCompra(compra1);
        miLibreria.registrarCompra(compra2);
        Double resultado = 198.89;

        Assert.assertEquals(resultado,miLibreria.ventasDelMesAnioDeUnCliente(sebastianVettel, 3, 2018),0.01);
    }

}
