package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.excepciones.InversionException;
import org.junit.Assert;
import org.junit.Test;

public class SimuladorDeImpuestosTest {
    @Test
    public void deberiaObtenerGanaciasPorInversionEnDolares() throws InversionException {
        String argumentos = " dol,1000,20,28";
        Boolean esEmpresa = false;
        SimuladorDeImpuestos simulador = new SimuladorDeImpuestos(esEmpresa, argumentos);
        Assert.assertEquals(400d, simulador.obtenerGanancias(), 0.001);
    }

    @Test
    public void deberiaAplicarImpuestoPorGanaciaObtenidaYSerEmpresa() throws InversionException {
        String argumentos = " dol,100000,20,28";
        Boolean esEmpresa = true;
        SimuladorDeImpuestos simulador = new SimuladorDeImpuestos(esEmpresa, argumentos);
        Assert.assertEquals(40000d, simulador.obtenerGanancias(), 0.001);
        Assert.assertEquals(2000d, simulador.aplicarImpuesto(), 0.001);
    }

    @Test
    public void deberiaArmarSalidaConImpuestosAplicado() throws InversionException {
        String unaSalida = "ganancia: 40000.00, impuesto: 2000.00";
        String argumentos = " dol,100000,20,28";
        Boolean esEmpresa = true;
        SimuladorDeImpuestos simulador = new SimuladorDeImpuestos(esEmpresa, argumentos);
        String resultado = simulador.armarSalida();
        Assert.assertEquals(unaSalida,resultado);
    }

    @Test
    public void deberiaArmarSalidaConImpuestosAplicadoALaSumaDeLasGanancias() throws InversionException {
        String unaSalida = "ganancia: 128000.00, impuesto: 19200.00";
        String argumentosDol = "dol,20000,20,28";
        String argumentosPFT = "pft,90,40,250000";
        String argumentosPFP = "pfp,365,300,40,100000";
        String argumentos = argumentosDol + " " + argumentosPFP + " " + argumentosPFT;
        Boolean esEmpresa = true;
        SimuladorDeImpuestos simulador = new SimuladorDeImpuestos(esEmpresa, argumentos);
        String resultado = simulador.armarSalida();
        System.out.println(resultado);
        Assert.assertEquals(unaSalida,resultado);
    }
}
