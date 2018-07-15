package ar.edu.untref.aydoo;

public class CompraDolares extends Inversion {

    private final Double cotizacionInicial;
    private final Double cotizacionFinal;

    public CompraDolares(Double monto, Double cotizacionInicial, Double cotizacionFinal) {
        super(monto);
        this.cotizacionInicial = cotizacionInicial;
        this.cotizacionFinal = cotizacionFinal;
    }

    public Double obtenerGanacias(){
        super.setPorcentajeGanancia(cotizacionFinal/cotizacionInicial);
        return super.obtenerGanacias();
    }
}
