package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.excepciones.InversionException;
import ar.edu.untref.aydoo.excepciones.PlazoAcordadoException;
import ar.edu.untref.aydoo.excepciones.PorcentajeInversionException;

public class PlazoFijoPrecancelable extends Inversion {

    private static final int DIAS_MINIMO = 60;
    private static final int PORCIENTOS = 100;
    private static final int MITAD = 2;
    private static final int INTERES_MINIMO = 0;
    private final int plazoAcordado;
    private final int plazoReal;
    private final Double interes;

    public PlazoFijoPrecancelable(Double monto, int plazoAcordado, int plazoReal, Double interes) throws InversionException {
        super(monto);
        if (interes < INTERES_MINIMO) {
            throw new PorcentajeInversionException();
        }

        if (plazoAcordado < DIAS_MINIMO) {
            throw new PlazoAcordadoException("precancelable", DIAS_MINIMO);
        }
        this.plazoAcordado = plazoAcordado;
        this.plazoReal = plazoReal;
        this.interes = interes;
    }

    public Double obtenerGanacias(){

        if (this.plazoReal >= this.plazoAcordado) {
            super.setPorcentajeGanancia(interes / PORCIENTOS);
        } else {
            super.setPorcentajeGanancia((interes / PORCIENTOS) / MITAD);
        }
        return super.obtenerGanacias();
    }
}
