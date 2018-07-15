package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;


public class GabadorDeFinanzasTest
{
    @Test
    public void deberiaDevolverElMismoMontoEnviadoYaQueNoAplicaImpuesto()
    {
        GabadorDeFinanzas gabadorDeFinanzas = new GabadorDeFinanzas();
        Double result = gabadorDeFinanzas.grabarImpuestos(10d);
        Assert.assertEquals(10d, result,0.001);
    }

    @Test
    public void obtengo25KDeGananciasComprandoDolares()
    {
        Double monto = 20000d;
        Double cotizacionInicial = 20d;
        Double cotizacionFinal = 25d;

        CompraDolares compraDolares = new CompraDolares(monto, cotizacionInicial, cotizacionFinal);
        GabadorDeFinanzas gabadorDeFinanzas = new GabadorDeFinanzas();

        Double result = gabadorDeFinanzas.grabarImpuestos(compraDolares.obtenerGanacias());
        Assert.assertEquals(1250d, result,0.001);
    }

    @Test
    public void obtengo25KDeGananciasPlazoFijo()
    {
        Double monto = 20000d;
        int plazoAcordado = 90;
        Double interes = 10d;
        PlazoFijo plazoFijoTradicional = new PlazoFijo(monto, plazoAcordado, interes);
        GabadorDeFinanzas gabadorDeFinanzas = new GabadorDeFinanzas();
        Double result = gabadorDeFinanzas.grabarImpuestos(plazoFijoTradicional.obtenerGanacias(90));
        Assert.assertEquals(2000d, result,0.001);


    }

    @Test
    public void obtengo25KDeGananciasPlazoFijoPrecancelable()
    {
        Double monto = 20000d;
        int plazoAcordado = 180;
        Double interes = 10d;
        PlazoFijoPrecancelable plazoFijoPrecancelable = new PlazoFijoPrecancelable(monto, plazoAcordado, interes);
        GabadorDeFinanzas gabadorDeFinanzas = new GabadorDeFinanzas();
        Double result = gabadorDeFinanzas.grabarImpuestos(plazoFijoPrecancelable.obtenerGanacias(90));
        Assert.assertEquals(1000d, result,0.001);
    }
}
