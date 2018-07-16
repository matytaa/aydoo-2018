package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.excepciones.InversionException;
import ar.edu.untref.aydoo.excepciones.MontoInicialException;

public class Inversion {
    private static final double MONTO_MINIMO = 1000.0d;
    private Double monto;
    private Double porcentajeGanancia;

    public Inversion(Double monto) throws MontoInicialException {
        if (monto < MONTO_MINIMO) {
            throw new MontoInicialException();
        }
        this.monto = monto;
    }

    public void setPorcentajeGanancia(Double unPorcentaje) {
        this.porcentajeGanancia = unPorcentaje;
    }

    public Double obtenerGanacias() throws InversionException {
        return this.monto * this.porcentajeGanancia;
    }

}
