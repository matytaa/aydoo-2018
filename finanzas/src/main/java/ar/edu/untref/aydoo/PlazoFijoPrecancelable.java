package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.excepciones.InversionException;
import ar.edu.untref.aydoo.excepciones.MontoInicialException;
import ar.edu.untref.aydoo.excepciones.PlazoAcordadoException;
import ar.edu.untref.aydoo.excepciones.PorcentajeInversionException;

public class PlazoFijoPrecancelable extends Inversion {
    private final int plazoAcordado;
    private final int plazoReal;
    private final Double interes;

    public PlazoFijoPrecancelable(Double monto, int plazoAcordado, int plazoReal, Double interes) throws MontoInicialException {
        super(monto);
        this.plazoAcordado = plazoAcordado;
        this.plazoReal = plazoReal;
        this.interes = interes;
    }

    public Double obtenerGanacias() throws InversionException {

        if (this.interes < 0d){
            throw new PorcentajeInversionException();
        }

        if (this.plazoAcordado < 60){
            throw new PlazoAcordadoException(60);
        }

        if (this.plazoReal >= this.plazoAcordado){
            super.setPorcentajeGanancia(interes/100);
        }else{
            super.setPorcentajeGanancia((interes/100)/2);
        }
        return super.obtenerGanacias();
    }
}
