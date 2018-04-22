package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Libreria {
    private List<Producto> misProductos = new LinkedList<>();
    private List<Venta> listaDeVentas = new LinkedList<>();

    public void agregarUnProducto(final Producto unProducto) {
        this.misProductos.add(unProducto);
    }

    public int cantidadDeProductos() {
        return this.misProductos.size();
    }

    public void registrarVenta(final Venta unaVenta) {
        decrementarLibros(unaVenta.darProducto());
        this.listaDeVentas.add(unaVenta);
    }

    private void decrementarLibros(final Producto producto) {
    }

    public Double ventasDelMesAnioDeUnCliente(final Cliente unCliente,
                                           final int unMes,
                                           final int unAnio) {
        Iterator<Venta> iteradorVentas = this.listaDeVentas.iterator();
        Venta unaVenta;
        Double importeDelMes = 0.0;
        while (iteradorVentas.hasNext()) {
            unaVenta = iteradorVentas.next();
            if (mismoCliente(unCliente, unaVenta.darCliente())) {
                if (unaVenta.perteneceAlPeriodo(unAnio, unMes)) {
                    importeDelMes = importeDelMes
                            + unaVenta.darProducto().darPrecio();
                }
            }
        }
        return importeDelMes;
    }

    private boolean mismoCliente(final Cliente unCliente,
                                 final Cliente clienteVenta) {
        return unCliente.equals(clienteVenta);
    }
}
