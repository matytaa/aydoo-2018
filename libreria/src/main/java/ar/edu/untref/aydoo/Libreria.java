package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Libreria {

    private List<Compra> listaDeCompras = new LinkedList<>();

    public void registrarCompra(final Compra unaCompra) {
        this.listaDeCompras.add(unaCompra);
    }

    private void decrementarLibros(final Producto producto) {
    }

    public Double ventasDelMesAnioDeUnCliente(final Cliente unCliente,
                                              final int unMes,
                                              final int unAnio) {
        Iterator<Compra> iteradorCompras = this.listaDeCompras.iterator();
        Compra unaCompra;
        Double importeDelMes = 0.0;
        Producto unProducto;
        while (iteradorCompras.hasNext()) {
            unaCompra = iteradorCompras.next();
            if (mismoCliente(unCliente, unaCompra.darCliente())) {
                if (unaCompra.perteneceAlPeriodo(unAnio, unMes)) {
                    Iterator<Producto> iteradorProductos =
                            unaCompra.darListaDeProducto().iterator();
                    while (iteradorProductos.hasNext()) {
                        unProducto = iteradorProductos.next();
                        importeDelMes += unProducto.darPrecio();
                    }
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
