package ar.edu.untref.aydoo;

import cucumber.api.java.eo.Do;
import org.junit.Assert;
import org.junit.Test;

public class ArticuloLibreriaTest {
    @Test
    public void crearArticuloDeLibreriaYSolicitarIva() {
        ArticuloLibreria unArticulo = new ArticuloLibreria(10.0, 21);
        Assert.assertEquals(21, unArticulo.darIva());
    }

    @Test
    public void crearArticuloDeLibreriaYSolicitarPrecio() {
        ArticuloLibreria unArticulo = new ArticuloLibreria(10.0, 21);
        Double precioConIva = 12.1;
        unArticulo.darPrecio();
        Assert.assertEquals(precioConIva, unArticulo.darPrecio());
    }

}
