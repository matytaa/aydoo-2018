package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.excepciones.MontoInicialException;

public class ManejadorDeInversiones {
    private Inversion inversion;

    public Inversion crearInversion(Double monto, Double cotizacionInicial, Double cotizacionFinal) throws MontoInicialException {
        this.inversion = new CompraDolares(monto, cotizacionInicial, cotizacionFinal);
        return this.inversion;
    }

    public Inversion crearInversion(Double monto, int plazo, Double interes) throws MontoInicialException {
        this.inversion = new PlazoFijo(monto, plazo, interes);
        return this.inversion;
    }

    public Inversion crearInversion(Double monto, int plazo, int plazoReal, Double interes) throws MontoInicialException {
        this.inversion = new PlazoFijoPrecancelable(monto, plazo, plazoReal, interes);
        return this.inversion;
    }
}