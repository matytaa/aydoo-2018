package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ArticuloLibreriaTest {
    @Test
    public void crearArticuloDeLibreriaYSolicitarPrecio (){
        ArticuloLibreria unArticulo = new ArticuloLibreria(10, 21);
        Assert.assertEquals(10, unArticulo.darPrecio());
    }

    @Test
    public void crearArticuloDeLibreriaYSolicitarIva (){
        ArticuloLibreria unArticulo = new ArticuloLibreria(10, 21);
        Assert.assertEquals(21, unArticulo.darIva());
    }
}
