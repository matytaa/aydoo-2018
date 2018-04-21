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
    public void almacenarUnLibroYSolicitarLaCantidadDeLibros() {
        Libreria miLibreria = new Libreria();
        Libro biblografiaDBZ = new Libro(10);
        miLibreria.agregarLibro(biblografiaDBZ);
        Assert.assertEquals(1, miLibreria.cantidadDeLibros());
    }

    @Test
    public void almacenarUnaRevistaYSolicitarLaCantidadDePeriodicos() {
        Libreria miLibreria = new Libreria();
        Periodico revistaDBZ = new Periodico(10,3);
        miLibreria.agregarPeriodico(revistaDBZ);
        Assert.assertEquals(1, miLibreria.cantidadDePeriodicos());
    }

    @Test
    public void almacenarUnArticuloDeLibreriaYSolicitarLaCantidadDeArticulosDeLibreria() {
        Libreria miLibreria = new Libreria();
        ArticuloLibreria albumDBZ = new ArticuloLibreria(10, 10);
        miLibreria.agregarArticuloLibreria(albumDBZ);
        Assert.assertEquals(1, miLibreria.cantidadDeArticulos());
    }
}
