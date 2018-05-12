package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class LibroTest {
    @Test
    public void crearUnLibroConPrecioYLuegoSolicitarlo(){
        Libro unLibro = new Libro(10.0);
        Double unPrecio = 10.0;
        Assert.assertEquals(unPrecio, unLibro.darPrecio());
    }

}
