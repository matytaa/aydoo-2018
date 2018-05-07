package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class LibreriaTest {
    private Calendar unaFecha;
    private Cliente kimiRaikkonen;
    private Cliente sebastianVettel;
    private Libro eauRouge;
    private ArticuloLibreria parabolica;
    private Periodico rectaPrincipal;
    private Suscripcion unaSuscripcion;
    private Libro boxes;
    private Libreria miLibreria;

    @Before
    public void setUp() {
        unaFecha = Calendar.getInstance();
        kimiRaikkonen = new Cliente("Kimi Raikkonen", "Spa-Francorchamps");
        sebastianVettel = new Cliente("Sebastian Vettel", "Monza");
        eauRouge = new Libro(100.0);
        parabolica = new ArticuloLibreria(90.0, 21);
        rectaPrincipal = new Periodico(90.0, 3);
        unaSuscripcion = new Suscripcion(rectaPrincipal, TipoSuscripcion.ANUAL);
        boxes = new Libro(90.0);
        miLibreria = new Libreria();
    }

    @Test
    public void generarComprasYSolicitarLasComprasDelMesDeMarzoDeKimi() {
        unaFecha.set(2018, 2, 17);
        Date fechaDeCompra = unaFecha.getTime();

        Compra unaCompra = new Compra(kimiRaikkonen, fechaDeCompra);
        unaCompra.agregarUnProducto(eauRouge);
        unaCompra.agregarUnProducto(parabolica);
        unaCompra.agregarUnProducto(rectaPrincipal);
        unaCompra.agregarUnProducto(boxes);

        miLibreria.registrarCompra(unaCompra);
        Double resultado = 388.9;

        Assert.assertEquals(resultado, miLibreria.comprasDelMesAnioDeUnCliente(kimiRaikkonen, 3, 2018), 0.1);
    }

    @Test
    public void generarComprasYSolicitarLasComprasDelMesDeMarzoDeVettel() {
        unaFecha.set(2018, 3, 17);
        Date fechaDeCompra = unaFecha.getTime();

        Compra compra1 = new Compra(kimiRaikkonen, fechaDeCompra);
        compra1.agregarUnProducto(eauRouge);
        compra1.agregarUnProducto(boxes);

        unaFecha.set(2018, 2, 17);
        fechaDeCompra = unaFecha.getTime();
        Compra compra2 = new Compra(sebastianVettel, fechaDeCompra);
        compra2.agregarUnProducto(parabolica);
        compra2.agregarUnProducto(rectaPrincipal);

        miLibreria.registrarCompra(compra1);
        miLibreria.registrarCompra(compra2);
        Double resultado = 198.89;

        Assert.assertEquals(resultado, miLibreria.comprasDelMesAnioDeUnCliente(sebastianVettel, 3, 2018), 0.01);
    }

    @Test
    public void generarComprasYSolicitarLasComprasDelAnioDeKimi() {
        Calendar unaFecha = Calendar.getInstance();
        unaFecha.set(2018, Calendar.JANUARY, 17);
        Date fechaDeCompra = unaFecha.getTime();

        Compra compra1 = new Compra(kimiRaikkonen, fechaDeCompra);
        compra1.agregarUnProducto(eauRouge);

        unaFecha.set(2018, Calendar.JUNE, 17);
        fechaDeCompra = unaFecha.getTime();
        Compra compra2 = new Compra(kimiRaikkonen, fechaDeCompra);
        compra2.agregarUnProducto(parabolica);

        unaFecha.set(2018, Calendar.OCTOBER, 17);
        fechaDeCompra = unaFecha.getTime();
        Compra compra3 = new Compra(kimiRaikkonen, fechaDeCompra);
        compra3.agregarUnProducto(rectaPrincipal);

        unaFecha.set(2018, Calendar.DECEMBER, 17);
        fechaDeCompra = unaFecha.getTime();
        Compra compra4 = new Compra(kimiRaikkonen, fechaDeCompra);
        compra4.agregarUnProducto(boxes);

        miLibreria.registrarCompra(compra1);
        miLibreria.registrarCompra(compra2);
        miLibreria.registrarCompra(compra3);
        miLibreria.registrarCompra(compra4);
        Double resultado = 388.90;

        Assert.assertEquals(resultado, miLibreria.comprasDelAnioDeUnCliente(kimiRaikkonen, 2018), 0.01);
    }


    @Test
    public void generarComprasDeLibrosArticulosDeLibreriaYPeriodicosConSuscripcionesYSolicitarLasComprasDelAnio() {
        unaFecha.set(2018, Calendar.JANUARY, 17);
        Date fechaDeCompra = unaFecha.getTime();
        Compra compra1 = new Compra(kimiRaikkonen, fechaDeCompra);
        compra1.agregarUnProducto(eauRouge);

        unaFecha.set(2018, Calendar.JUNE, 17);
        fechaDeCompra = unaFecha.getTime();
        Compra compra2 = new Compra(kimiRaikkonen, fechaDeCompra);
        compra2.agregarUnProducto(parabolica);

        unaFecha.set(2018, Calendar.OCTOBER, 17);
        fechaDeCompra = unaFecha.getTime();
        Compra compra3 = new Compra(kimiRaikkonen, fechaDeCompra);
        compra3.agregarUnProducto(rectaPrincipal);
        compra3.agregarUnProducto(unaSuscripcion);

        unaFecha.set(2018, Calendar.DECEMBER, 17);
        fechaDeCompra = unaFecha.getTime();
        Compra compra4 = new Compra(kimiRaikkonen, fechaDeCompra);
        compra4.agregarUnProducto(boxes);


        miLibreria.registrarCompra(compra1);
        miLibreria.registrarCompra(compra2);
        miLibreria.registrarCompra(compra3);
        miLibreria.registrarCompra(compra4);
        Double resultado = 370.90;

        Assert.assertEquals(resultado, miLibreria.comprasDelAnioDeUnCliente(kimiRaikkonen, 2018), 0.01);
    }

    @Test
    public void elClienteDeberiaEstarRegistrado(){
        miLibreria.registrarCliente(kimiRaikkonen);
        Assert.assertTrue(miLibreria.clienteRegistrado(kimiRaikkonen));
    }

    @Test
    public void elClienteNoDeberiaEstarRegistrado(){
        Assert.assertFalse(miLibreria.clienteRegistrado(sebastianVettel));
    }
}
