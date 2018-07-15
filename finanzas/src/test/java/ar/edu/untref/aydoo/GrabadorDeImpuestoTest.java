package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.excepciones.InversionException;
import org.junit.Test;
import org.junit.Assert;


public class GrabadorDeImpuestoTest {
    @Test
    public void deberiaDevolverElMismoMontoEnviadoYaQueNoAplicaImpuesto() {
        GrabadorDeImpuesto gabadorDeFinanzas = new GrabadorDeImpuesto();
        Double result = gabadorDeFinanzas.grabarImpuestos(10d);
        Assert.assertEquals(10d, result, 0.001);
    }

    @Test
    public void obtengo25KDeGananciasComprandoDolares() throws InversionException {
        Double monto = 20000d;
        Double cotizacionInicial = 20d;
        Double cotizacionFinal = 25d;

        CompraDolares compraDolares = new CompraDolares(monto, cotizacionInicial, cotizacionFinal);
        GrabadorDeImpuesto gabadorDeFinanzas = new GrabadorDeImpuesto();

        Double result = gabadorDeFinanzas.grabarImpuestos(compraDolares.obtenerGanacias());
        Assert.assertEquals(5000d, result, 0.001);
    }

    @Test
    public void obtengo25KDeGananciasPlazoFijo() throws InversionException {
        Double monto = 20000d;
        int plazoAcordado = 90;
        Double interes = 10d;
        PlazoFijo plazoFijoTradicional = new PlazoFijo(monto, plazoAcordado, interes);
        GrabadorDeImpuesto gabadorDeFinanzas = new GrabadorDeImpuesto();
        Double result = gabadorDeFinanzas.grabarImpuestos(plazoFijoTradicional.obtenerGanacias());
        Assert.assertEquals(2000d, result, 0.001);
    }

    @Test
    public void obtengo25KDeGananciasPlazoFijoPrecancelable() throws InversionException {
        Double monto = 20000d;
        int plazoAcordado = 180;
        int plazoReal = 90;
        Double interes = 10d;
        PlazoFijoPrecancelable plazoFijoPrecancelable = new PlazoFijoPrecancelable(monto, plazoAcordado, plazoReal, interes);
        GrabadorDeImpuesto gabadorDeFinanzas = new GrabadorDeImpuesto();
        Double result = gabadorDeFinanzas.grabarImpuestos(plazoFijoPrecancelable.obtenerGanacias());
        Assert.assertEquals(1000d, result, 0.001);
    }
}
