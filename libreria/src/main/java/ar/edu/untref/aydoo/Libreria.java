package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Libreria {
    private List<Libro> misLibros = new LinkedList<>();
    private List<Periodico> misPeriodicos = new LinkedList<>();
    private List<ArticuloLibreria> misArticulosLibreria = new LinkedList<>();
    private List<Venta> listaDeVentas = new LinkedList<>();

    public int cantidadDeProductos() {
        return 0;
    }

    public void agregarLibro(final Libro unLibro) {
        this.misLibros.add(unLibro);
    }

    public int cantidadDeLibros() {
        return this.misLibros.size();
    }

    public int cantidadDePeriodicos() {
        return this.misPeriodicos.size();
    }

    public void agregarPeriodico(final Periodico unPeriodico) {
        this.misPeriodicos.add(unPeriodico);
    }

    public void agregarArticuloLibreria(final ArticuloLibreria unArticulo) {
        this.misArticulosLibreria.add(unArticulo);
    }

    public int cantidadDeArticulos() {
        return this.misArticulosLibreria.size();
    }

    public void venderLibro(final Cliente unCliente, final Libro unLibro) {

    }

    public void venderLibro(final Venta unaVenta) {
        this.listaDeVentas.add(unaVenta);
    }
}
