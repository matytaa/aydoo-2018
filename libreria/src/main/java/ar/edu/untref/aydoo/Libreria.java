package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Libreria {

    private List<Compra> listaDeCompras;
    private final int limiteMeses = 13;
    private List<Cliente> listaDeClientesRegistrados;

    public Libreria(){
        listaDeCompras = new LinkedList<>();
        listaDeClientesRegistrados = new LinkedList<>();
    }

    public void registrarCompra(final Compra unaCompra) {
        this.listaDeCompras.add(unaCompra);
    }

    public Double comprasDelMesAnioDeUnCliente(final Cliente unCliente,
                                               final int unMes,
                                               final int unAnio) {
        Iterator<Compra> iteradorCompras = this.listaDeCompras.iterator();
        Compra unaCompra;
        Double importeDelMes = 0.0;
        while (iteradorCompras.hasNext()) {
            unaCompra = iteradorCompras.next();
            if (mismoCliente(unCliente, unaCompra.darCliente())) {
                if (unaCompra.perteneceAlPeriodo(unAnio, unMes)) {
                    importeDelMes += unaCompra.calcularValorDeLaCompra();
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

    public void registrarCliente(Cliente unCliente) {
        this.listaDeClientesRegistrados.add(unCliente);
    }

    public boolean clienteRegistrado(Cliente unCliente) {
        return this.listaDeClientesRegistrados.contains(unCliente);
    }
}
