package ar.edu.untref.aydoo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Compra {
    private Producto producto;
    private Date fechaDeVenta;
    private Cliente cliente;

    public Compra(final Cliente unCliente,
                  final Producto unProducto,
                  final Date unaFechaDeVenta) {
        this.cliente = unCliente;
        this.producto = unProducto;
        this.fechaDeVenta = unaFechaDeVenta;
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

    public Producto darProducto() {
        return this.producto;
    }
}
