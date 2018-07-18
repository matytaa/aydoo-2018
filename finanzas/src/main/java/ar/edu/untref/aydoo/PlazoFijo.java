package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.excepciones.InversionException;
import ar.edu.untref.aydoo.excepciones.PlazoAcordadoException;
import ar.edu.untref.aydoo.excepciones.PorcentajeInversionException;

public class PlazoFijo extends Inversion {
    private static final int DIAS_MINIMO = 30;
    private static final int INTERES_MINIMO = 0;
    private static final int PORCIENTOS = 100;
    private final int plazoAcordado;
    private final Double interes;

    public PlazoFijo(Double monto, int plazoAcordado, Double interes) throws InversionException {
        super(monto);
        if (plazoAcordado < DIAS_MINIMO) {
            throw new PlazoAcordadoException(DIAS_MINIMO);
        }
        if (interes < INTERES_MINIMO) {
            throw new PorcentajeInversionException();
        }
        this.plazoAcordado = plazoAcordado;
        this.interes = interes;
    }

    public Double obtenerGanacias() {
        super.setPorcentajeGanancia(interes / PORCIENTOS);
        return super.obtenerGanacias();
    }
}
