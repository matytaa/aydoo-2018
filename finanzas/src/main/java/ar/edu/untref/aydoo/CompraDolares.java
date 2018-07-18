package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.excepciones.CotizacionDolarException;
import ar.edu.untref.aydoo.excepciones.InversionException;

public class CompraDolares extends Inversion {

    private final Double cotizacionInicial;
    private final Double cotizacionFinal;

    public CompraDolares(Double monto, Double cotizacionInicial, Double cotizacionFinal) throws InversionException {
        super(monto);
        if(cotizacionFinal<=0||cotizacionInicial<=0){
            throw new CotizacionDolarException();
        }
        this.cotizacionInicial = cotizacionInicial;
        this.cotizacionFinal = cotizacionFinal;
    }

    public Double obtenerGanacias(){
        Double unPorcentaje = (cotizacionFinal / cotizacionInicial) - 1;

        super.setPorcentajeGanancia(unPorcentaje);
        return super.obtenerGanacias();
    }
}
