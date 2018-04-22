package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Libreria {
    private List<Producto> misProductos = new LinkedList<>();
    private List<Compra> listaDeCompras = new LinkedList<>();

    public void agregarUnProducto(final Producto unProducto) {
        this.misProductos.add(unProducto);
    }

    public int cantidadDeProductos() {
        return this.misProductos.size();
    }

    public void registrarVenta(final Compra unaCompra) {
        decrementarLibros(unaCompra.darProducto());
        this.listaDeCompras.add(unaCompra);
    }

    private void decrementarLibros(final Producto producto) {
    }

    public Double ventasDelMesAnioDeUnCliente(final Cliente unCliente,
                                           final int unMes,
                                           final int unAnio) {
        Iterator<Compra> iteradorVentas = this.listaDeCompras.iterator();
        Compra unaCompra;
        Double importeDelMes = 0.0;
        while (iteradorVentas.hasNext()) {
            unaCompra = iteradorVentas.next();
            if (mismoCliente(unCliente, unaCompra.darCliente())) {
                if (unaCompra.perteneceAlPeriodo(unAnio, unMes)) {
                    importeDelMes = importeDelMes
                            + unaCompra.darProducto().darPrecio();
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
