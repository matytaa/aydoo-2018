package ar.edu.untref.aydoo;


import java.util.*;

public class Compra {
    private List<Producto> misProductos;
    private Date fechaDeVenta;
    private Cliente cliente;

    public Compra(final Cliente unCliente,
                  final Date unaFechaDeVenta) {
        this.cliente = unCliente;
        this.fechaDeVenta = unaFechaDeVenta;
        this.misProductos = new LinkedList<>();
    }

    public void agregarUnProducto(final Producto unProducto) {
        this.misProductos.add(unProducto);
    }

    public int cantidadDeProductos() {
        return this.misProductos.size();
    }

    public boolean perteneceAlMes(final int unMes) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(this.fechaDeVenta);
        return calendar.get(Calendar.MONTH) == (unMes - 1);
    }

    public boolean perteneceAlAnio(final int unAnio) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(this.fechaDeVenta);
        return calendar.get(Calendar.YEAR) == unAnio;
    }

    public Cliente darCliente() {
        return this.cliente;
    }

    public boolean perteneceAlPeriodo(final int unAnio, final int unMes) {
        return perteneceAlAnio(unAnio) && perteneceAlMes(unMes);
    }

    public Double calcularValorDeLaCompra() {
        Double importeDeLaCompra = 0.0;
        Producto unProducto;
        Iterator<Producto> iteradorProductos =
                this.misProductos.iterator();
        while (iteradorProductos.hasNext()) {
            unProducto = iteradorProductos.next();
            importeDeLaCompra += unProducto.darPrecio();
        }
        return importeDeLaCompra;
    }
}
