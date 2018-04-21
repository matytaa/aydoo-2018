package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ProductoTest {
    @Test
    public void crearUnProductoYSolicitarPrecio() {
        Producto unProducto = new Producto(10);
        Assert.assertEquals(10, unProducto.darPrecio());
    }
}
