package ar.edu.untref.aydoo;

public class Periodico extends Producto {
    private int periodicidad;

    public Periodico(final int precio, final int unaPeriodicidad) {
        super(precio);
        this.periodicidad = unaPeriodicidad;
    }

    public int darPeriodicidad() {
        return this.periodicidad;
    }
}
