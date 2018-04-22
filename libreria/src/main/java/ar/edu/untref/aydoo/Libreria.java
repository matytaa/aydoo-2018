package ar.edu.untref.aydoo;

import java.util.Iterator;
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

    public void registrarVenta(final Venta unaVenta) {
        this.listaDeVentas.add(unaVenta);
    }

    public int ventasDelMes(final Cliente unCliente,
                            final int unMes, final int unAnio) {
        Iterator<Venta> iteradorVentas = this.listaDeVentas.iterator();
        Venta unaVenta;
        int cantidadDeVentas = 0;
        while (iteradorVentas.hasNext()) {
            unaVenta = iteradorVentas.next();
            if (mismoCliente(unCliente, unaVenta.darCliente())) {
                if (unaVenta.perteneceAlPeriodo(unAnio, unMes)) {
                    cantidadDeVentas++;
                }
            }
        }
        return cantidadDeVentas;
    }

    private boolean mismoCliente(final Cliente unCliente,
                                 final Cliente clienteVenta) {
        return unCliente.equals(clienteVenta);
    }
}
