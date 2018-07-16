package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.excepciones.InversionException;
import ar.edu.untref.aydoo.excepciones.MontoInicialException;
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

    public PlazoFijoPrecancelable(Double monto, int plazoAcordado, int plazoReal, Double interes) throws MontoInicialException {
        super(monto);
        this.plazoAcordado = plazoAcordado;
        this.plazoReal = plazoReal;
        this.interes = interes;
    }

    public Double obtenerGanacias() throws InversionException {

        if (this.interes < INTERES_MINIMO) {
            throw new PorcentajeInversionException();
        }

        if (this.plazoAcordado < DIAS_MINIMO) {
            throw new PlazoAcordadoException(60);
        }

        if (this.plazoReal >= this.plazoAcordado) {
            super.setPorcentajeGanancia(interes / PORCIENTOS);
        } else {
            super.setPorcentajeGanancia((interes / PORCIENTOS) / MITAD);
        }
        return super.obtenerGanacias();
    }
}
