package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class LibreriaTest {
    @Test
    public void crearLibreriaVaciaYSolicitarLaCantidadDeProductos_debeDarCero(){
        Libreria miLibreria = new Libreria();
        Assert.assertEquals(0, miLibreria.cantidadDeProductos());
    }
}
