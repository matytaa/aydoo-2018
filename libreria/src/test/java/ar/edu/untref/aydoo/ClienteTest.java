package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {
    @Test
    public void nombreYDireccionSeAsignanCorrectamente() {
        String nombre = "Rafael Nadal";
        String direccion = "Vinateros 954";
        Cliente rafaelNadal = new Cliente(nombre, direccion);
        String unNombre = rafaelNadal.darNombre();
        String unaDirección = rafaelNadal.darDireccion();
        Assert.assertEquals(nombre, unNombre);
        Assert.assertEquals(direccion, unaDirección);
    }

    @Test
    public void comprarSuscripcionDeUnProducto() {
        String nombre = "Kimi Raikkonen";
        String direccion = "Spa-Francorcharmps";
        Cliente kimi = new Cliente(nombre, direccion);
        Periodico rectaPrincipal = new Periodico(90.0, 3);
        Suscripcion unaSuscripcion = new Suscripcion(rectaPrincipal, TipoSuscripcion.ANUAL);
        kimi.comprarSuscripcion(unaSuscripcion);
        Assert.assertTrue(kimi.tieneSuscripciones());
    }

    @Test
    public void retornarListaDeSuscripcionesYConsultarTamanio() {
        String nombre = "Kimi Raikkonen";
        String direccion = "Spa-Francorcharmps";
        Cliente kimi = new Cliente(nombre, direccion);
        Periodico rectaPrincipal = new Periodico(90.0, 3);
        Suscripcion unaSuscripcion = new Suscripcion(rectaPrincipal, TipoSuscripcion.ANUAL);
        kimi.comprarSuscripcion(unaSuscripcion);
        Assert.assertEquals(1, kimi.darSuscripciones().size());
    }
}
