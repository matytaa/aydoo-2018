package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.excepciones.InversionException;
import ar.edu.untref.aydoo.excepciones.MontoInicialException;
import ar.edu.untref.aydoo.excepciones.PorcentajeInversionException;

public class Inversion {
    private Double monto;
    private Double porcentajeGanancia;

    public Inversion(Double monto) throws MontoInicialException {
        if (monto<1000d) {
            throw new MontoInicialException();
        }
        this.monto = monto;
    }

    public void setPorcentajeGanancia(Double unPorcentaje){
        this.porcentajeGanancia = unPorcentaje;
    }

    public Double obtenerGanacias() throws InversionException {
        return this.monto*this.porcentajeGanancia;
    }

}
