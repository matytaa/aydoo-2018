package ar.edu.untref.aydoo;

public class Suscripcion {
    private Periodico miPeriodico;
    private final Double descuento = 0.20;

    public Suscripcion(final Periodico unPeriodico) {
        this.miPeriodico = unPeriodico;
    }

    public Periodico darPeriodico() {
        return this.miPeriodico;
    }

    public Double obtenerDescuento() {
        return this.miPeriodico.darPrecio() * this.descuento;
    }
}
