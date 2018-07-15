package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.excepciones.InversionException;
import ar.edu.untref.aydoo.excepciones.MontoInicialException;
import ar.edu.untref.aydoo.excepciones.PlazoAcordadoException;
import ar.edu.untref.aydoo.excepciones.PorcentajeInversionException;

public class PlazoFijo extends Inversion {
    private final int plazoAcordado;
    private final Double interes;

    public PlazoFijo(Double monto, int plazoAcordado, Double interes) throws MontoInicialException {
        super(monto);
        this.plazoAcordado = plazoAcordado;
        this.interes = interes;
    }

    public Double obtenerGanacias() throws InversionException {
        if (this.plazoAcordado < 30){
            throw new PlazoAcordadoException();
        }
        if (this.interes < 0d){
            throw new PorcentajeInversionException();
        }
        super.setPorcentajeGanancia(interes/100);
        return super.obtenerGanacias();
    }
}
