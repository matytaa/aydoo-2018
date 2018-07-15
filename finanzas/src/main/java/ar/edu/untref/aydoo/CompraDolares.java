package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.excepciones.InversionException;
import ar.edu.untref.aydoo.excepciones.MontoInicialException;

public class CompraDolares extends Inversion {

    private final Double cotizacionInicial;
    private final Double cotizacionFinal;

    public CompraDolares(Double monto, Double cotizacionInicial, Double cotizacionFinal) throws MontoInicialException {
        super(monto);
        this.cotizacionInicial = cotizacionInicial;
        this.cotizacionFinal = cotizacionFinal;
    }

    public Double obtenerGanacias() throws InversionException {
        Double unPorcentaje = (cotizacionFinal/cotizacionInicial) - 1;

        super.setPorcentajeGanancia(unPorcentaje);
        return super.obtenerGanacias();
    }
}
