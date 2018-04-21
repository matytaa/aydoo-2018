package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class LibroTest {
    @Test
    public void crearUnLibroConPrecioYLuegoSolicitarlo(){
        Libro unLibro = new Libro(10);
        Assert.assertEquals(10, unLibro.darPrecio());
    }
}
