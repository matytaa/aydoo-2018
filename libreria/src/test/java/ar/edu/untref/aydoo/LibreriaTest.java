package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class LibreriaTest {
    @Test
    public void crearLibreriaVaciaYSolicitarLaCantidadDeProductos_debeDarCero() {
        Libreria miLibreria = new Libreria();
        Assert.assertEquals(0, miLibreria.cantidadDeProductos());
    }

    @Test
    public void almacenarUnLibroYSolicitarLaCantidadDeProductos() {
        Libreria miLibreria = new Libreria();
        Libro sonGoku = new Libro(10);
        miLibreria.AgregarProducto(sonGoku);
        Assert.assertEquals(1, miLibreria.cantidadDeLibros());
    }
}