package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.excepciones.InversionException;
import org.junit.Test;
import org.junit.Assert;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class GrabadorDeImpuestoTest {
    @Test
    public void deberiaDevolverElMismoMontoEnviadoYaQueNoAplicaImpuesto() {
        GrabadorDeImpuesto grabadorDeFinanzas = new GrabadorDeImpuesto();
        Double result = grabadorDeFinanzas.grabarImpuestos(10d, true);
        Assert.assertEquals(0d, result, 0.001);
    }

    @Test
    public void obtengo5KDeGananciasComprandoDolaresYNoAplicaImpuesto() throws InversionException {
        Double monto = 20000d;
        Double cotizacionInicial = 20d;
        Double cotizacionFinal = 25d;

        CompraDolares compraDolares = new CompraDolares(monto, cotizacionInicial, cotizacionFinal);
        GrabadorDeImpuesto grabadorDeFinanzas = new GrabadorDeImpuesto();
        Double result = grabadorDeFinanzas.grabarImpuestos(compraDolares.obtenerGanacias(), false);
        Assert.assertEquals(0d, result, 0.001);
    }

    @Test
    public void obtengo2KDeGananciasPlazoFijoYNoAplicoImpuesto() throws InversionException {
        Double monto = 20000d;
        int plazoAcordado = 90;
        Double interes = 10d;

        PlazoFijo plazoFijoTradicional = new PlazoFijo(monto, plazoAcordado, interes);
        GrabadorDeImpuesto grabadorDeFinanzas = new GrabadorDeImpuesto();

        Double result = grabadorDeFinanzas.grabarImpuestos(plazoFijoTradicional.obtenerGanacias(), false);
        Assert.assertEquals(0d, result, 0.001);
    }

    @Test
    public void obtengo1KDeGananciasPlazoFijoPrecancelableYNoAplicoImpuesto() throws InversionException {
        Double monto = 20000d;
        int plazoAcordado = 180;
        int plazoReal = 90;
        Double interes = 10d;

        PlazoFijoPrecancelable plazoFijoPrecancelable = new PlazoFijoPrecancelable(monto, plazoAcordado, plazoReal, interes);
        GrabadorDeImpuesto grabadorDeFinanzas = new GrabadorDeImpuesto();

        Double result = grabadorDeFinanzas.grabarImpuestos(plazoFijoPrecancelable.obtenerGanacias(), false);
        Assert.assertEquals(0d, result, 0.001);
    }

    @Test
    public void deberiaAplicarEl5PorcientoDeImpuestoMonto30KPorSerEmpresa() {
        Inversor unInversor = mock(Inversor.class);
        when(unInversor.esEmpresa()).thenReturn(true);
        when(unInversor.calcularGanacias()).thenReturn(30000d);

        GrabadorDeImpuesto grabadorDeImpuesto = new GrabadorDeImpuesto();
        Double resultado = grabadorDeImpuesto.grabarImpuestos(unInversor.calcularGanacias(), unInversor.esEmpresa());
        Assert.assertEquals(1500d, resultado, 0.001);
    }

    @Test
    public void deberiaAplicarEl5PorcientoDeImpuestoMonto60KPorSerParticular() {
        Inversor unInversor = mock(Inversor.class);
        when(unInversor.esEmpresa()).thenReturn(false);
        when(unInversor.calcularGanacias()).thenReturn(60000d);

        GrabadorDeImpuesto grabadorDeImpuesto = new GrabadorDeImpuesto();
        Double resultado = grabadorDeImpuesto.grabarImpuestos(unInversor.calcularGanacias(), unInversor.esEmpresa());
        Assert.assertEquals(3000d, resultado, 0.001);
    }

    @Test
    public void deberiaAplicarEl8PorcientoDeImpuestoMonto110KPorSerParticular() {
        Inversor unInversor = mock(Inversor.class);
        when(unInversor.esEmpresa()).thenReturn(false);
        when(unInversor.calcularGanacias()).thenReturn(110000d);

        GrabadorDeImpuesto grabadorDeImpuesto = new GrabadorDeImpuesto();
        Double resultado = grabadorDeImpuesto.grabarImpuestos(unInversor.calcularGanacias(), unInversor.esEmpresa());
        Assert.assertEquals(8800d, resultado, 0.001);
    }

    @Test
    public void deberiaAplicarEl10PorcientoDeImpuestoMonto510KPorSerParticular() {
        Inversor unInversor = mock(Inversor.class);
        when(unInversor.esEmpresa()).thenReturn(false);
        when(unInversor.calcularGanacias()).thenReturn(510000d);

        GrabadorDeImpuesto grabadorDeImpuesto = new GrabadorDeImpuesto();
        Double resultado = grabadorDeImpuesto.grabarImpuestos(unInversor.calcularGanacias(), unInversor.esEmpresa());
        Assert.assertEquals(51000d, resultado, 0.001);
    }

    @Test
    public void deberiaAplicarEl10PorcientoDeImpuestoMonto60KPorSerEmpresa() {
        Inversor unInversor = mock(Inversor.class);
        when(unInversor.esEmpresa()).thenReturn(true);
        when(unInversor.calcularGanacias()).thenReturn(60000d);

        GrabadorDeImpuesto grabadorDeImpuesto = new GrabadorDeImpuesto();
        Double resultado = grabadorDeImpuesto.grabarImpuestos(unInversor.calcularGanacias(), unInversor.esEmpresa());
        Assert.assertEquals(6000d, resultado, 0.001);
    }

    @Test
    public void deberiaAplicarEl15PorcientoDeImpuestoMonto200KPorSerEmpresa() {
        Inversor unInversor = mock(Inversor.class);
        when(unInversor.esEmpresa()).thenReturn(true);
        when(unInversor.calcularGanacias()).thenReturn(200000d);

        GrabadorDeImpuesto grabadorDeImpuesto = new GrabadorDeImpuesto();
        Double resultado = grabadorDeImpuesto.grabarImpuestos(unInversor.calcularGanacias(), unInversor.esEmpresa());
        Assert.assertEquals(30000d, resultado, 0.001);
    }

    @Test
    public void deberiaAplicarEl20PorcientoDeImpuestoMonto600KPorSerEmpresa() {
        Inversor unInversor = mock(Inversor.class);
        when(unInversor.esEmpresa()).thenReturn(true);
        when(unInversor.calcularGanacias()).thenReturn(600000d);

        GrabadorDeImpuesto grabadorDeImpuesto = new GrabadorDeImpuesto();
        Double resultado = grabadorDeImpuesto.grabarImpuestos(unInversor.calcularGanacias(), unInversor.esEmpresa());
        Assert.assertEquals(120000d, resultado, 0.001);
    }
}
