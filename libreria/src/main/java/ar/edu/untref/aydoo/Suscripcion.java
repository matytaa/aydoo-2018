package ar.edu.untref.aydoo;

public class Suscripcion extends Producto{
    private final TipoSuscripcion miTipoDeSuscripcion;
    private Periodico miPeriodico;
    private final Double descuento = -0.20;

    public Suscripcion(final Periodico unPeriodico, TipoSuscripcion unTipoDeSuscripcion) {
        super(unPeriodico.darPrecio());
        this.miPeriodico = unPeriodico;
        this.miTipoDeSuscripcion = unTipoDeSuscripcion;
    }

    public Periodico darPeriodico() {
        return this.miPeriodico;
    }

    public Double darPrecio() {
        Double unPrecio = 0.0;
        if(this.miTipoDeSuscripcion==TipoSuscripcion.ANUAL){
            unPrecio = super.darPrecio() * this.descuento;
        }
        return unPrecio;
    }
}
