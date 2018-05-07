package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Libreria {

    private List<Compra> listaDeCompras = new LinkedList<>();
    private final int limiteMeses = 13;

    public void registrarCompra(final Compra unaCompra) {
        this.listaDeCompras.add(unaCompra);
    }

    public Double comprasDelMesAnioDeUnCliente(final Cliente unCliente,
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
                        importeDelMes -=
                                aplicarDescuento(unCliente, unProducto);
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

    public Double comprasDelAnioDeUnCliente(final Cliente unCliente,
                                            final int unAnio) {
        Double resultado = 0.0;
        for (int mes = 1; mes < this.limiteMeses; mes++) {
            resultado += comprasDelMesAnioDeUnCliente(unCliente, mes, unAnio);
        }
        return resultado;
    }

    public boolean esPeridioco(final Producto unProducto) {
        return unProducto instanceof Periodico;
    }

    public Double aplicarDescuento(final Cliente unCliente,
                                   final Producto unPeriodico) {
        Double descuento = 0.0;

        if (esPeridioco(unPeriodico)) {
            List<Suscripcion> unaListaDeSuscripciones =
                    unCliente.darSuscripciones();
            Iterator<Suscripcion> itProductos =
                    unaListaDeSuscripciones.iterator();
            while (itProductos.hasNext()) {
                Suscripcion unaSuscripcion = itProductos.next();
                if (unPeriodico.equals(unaSuscripcion.darPeriodico())) {
                    descuento = unaSuscripcion.darPrecio();
                }
            }
        }
        return descuento;
    }
}
