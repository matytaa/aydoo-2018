package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {
    @Test
    public void crearUnCliente() {
        String nombre = "Rafael Nadal";
        String direccion = "Vinateros 954";
        Cliente rafaelNadal = new Cliente(nombre, direccion);
        String unNombre = rafaelNadal.darNombre();
        String unaDirección = rafaelNadal.darDireccion();
        Assert.assertEquals(nombre, unNombre);
        Assert.assertEquals(direccion, unaDirección);
    }
}
