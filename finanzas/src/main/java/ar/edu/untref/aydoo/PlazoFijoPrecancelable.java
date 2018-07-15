package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.excepciones.InversionException;
import ar.edu.untref.aydoo.excepciones.MontoInicialException;

public class PlazoFijoPrecancelable extends Inversion {
    private final int plazoAcordado;
    private final Double interes;

    public PlazoFijoPrecancelable(Double monto, int plazoAcordado, Double interes) throws MontoInicialException {
        super(monto);
        this.plazoAcordado = plazoAcordado;
        this.interes = interes;
    }

    public Double obtenerGanacias(int diaARetirar) throws InversionException {
        if (diaARetirar >= this.plazoAcordado){
            super.setPorcentajeGanancia(interes/100);
        }else{
            super.setPorcentajeGanancia((interes/100)/2);
        }
        return super.obtenerGanacias();
    }
}
