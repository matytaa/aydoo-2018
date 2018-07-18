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
        Assert.assertEquals(unaSalida,resultado);
    }

    @Test
    public void deberiaEjecutarCorrectamenteLaAplicacion() {
        String unaSalida = "ganancia: 128000.00, impuesto: 19200.00";
        String argumentosDol = "dol,20000,20,28";
        String argumentosPFT = "pft,90,40,250000";
        String argumentosPFP = "pfp,365,300,40,100000";
        String tipoInversor = "emp";
        String[] argumentos = {tipoInversor,argumentosDol,argumentosPFP,argumentosPFT};

        String resultado = SimuladorDeImpuestos.main(argumentos);
        Assert.assertEquals(unaSalida,resultado);
    }

    @Test
    public void deberiaLanzarExcepcionMontoInicial() {
        String unaSalida = "El monto a invertir debe ser mayor a 1000.";
        String argumentosDol = "dol,-20000,20,28";
        String argumentosPFT = "pft,90,40,250000";
        String argumentosPFP = "pfp,365,300,40,100000";
        String tipoInversor = "emp";
        String[] argumentos = {tipoInversor,argumentosDol,argumentosPFP,argumentosPFT};

        String resultado = SimuladorDeImpuestos.main(argumentos);
        Assert.assertEquals(unaSalida,resultado);
    }

    @Test
    public void deberiaLanzarExcepcionCotizacionDolarCotizacionInicial() {
        String unaSalida = "La cotización del dolar debe ser mayor a cero.";
        String argumentosDol = "dol,20000,-20,28";
        String argumentosPFT = "pft,90,40,250000";
        String argumentosPFP = "pfp,365,300,40,100000";
        String tipoInversor = "emp";
        String[] argumentos = {tipoInversor,argumentosDol,argumentosPFP,argumentosPFT};

        String resultado = SimuladorDeImpuestos.main(argumentos);
        Assert.assertEquals(unaSalida,resultado);
    }

    @Test
    public void deberiaLanzarExcepcionCotizacionDolarCotizacionFinal() {
        String unaSalida = "La cotización del dolar debe ser mayor a cero.";
        String argumentosDol = "dol,20000,20,-28";
        String argumentosPFT = "pft,90,40,250000";
        String argumentosPFP = "pfp,365,300,40,100000";
        String tipoInversor = "emp";
        String[] argumentos = {tipoInversor,argumentosDol,argumentosPFP,argumentosPFT};

        String resultado = SimuladorDeImpuestos.main(argumentos);
        Assert.assertEquals(unaSalida,resultado);
    }

    @Test
    public void deberiaLanzarExcepcionPlazoAcordadoPFT() {
        String unaSalida = "El plazo mínimo para un plazo fijo tradicional es de 30 días.";
        String argumentosDol = "dol,20000,20,28";
        String argumentosPFT = "pft,20,40,250000";
        String argumentosPFP = "pfp,365,300,40,100000";
        String tipoInversor = "emp";
        String[] argumentos = {tipoInversor,argumentosDol,argumentosPFP,argumentosPFT};

        String resultado = SimuladorDeImpuestos.main(argumentos);
        Assert.assertEquals(unaSalida,resultado);
    }

    @Test
    public void deberiaLanzarExcepcionPlazoAcordadoPFP() {
        String unaSalida = "El plazo mínimo para un plazo fijo precancelable es de 60 días.";
        String argumentosDol = "dol,20000,20,28";
        String argumentosPFT = "pft,90,40,250000";
        String argumentosPFP = "pfp,40,300,40,100000";
        String tipoInversor = "emp";
        String[] argumentos = {tipoInversor,argumentosDol,argumentosPFP,argumentosPFT};

        String resultado = SimuladorDeImpuestos.main(argumentos);
        Assert.assertEquals(unaSalida,resultado);
    }

    @Test
    public void deberiaLanzarExcepcionPorcentageDeInversionPFT() {
        String unaSalida = "El porcentaje de la inversión debe ser mayor a cero.";
        String argumentosDol = "dol,20000,20,28";
        String argumentosPFT = "pft,90,-40,250000";
        String argumentosPFP = "pfp,70,300,40,100000";
        String tipoInversor = "emp";
        String[] argumentos = {tipoInversor,argumentosDol,argumentosPFP,argumentosPFT};

        String resultado = SimuladorDeImpuestos.main(argumentos);
        Assert.assertEquals(unaSalida,resultado);
    }

    @Test
    public void deberiaLanzarExcepcionPorcentageDeInversionPFP() {
        String unaSalida = "El porcentaje de la inversión debe ser mayor a cero.";
        String argumentosDol = "dol,20000,20,28";
        String argumentosPFT = "pft,90,40,250000";
        String argumentosPFP = "pfp,70,300,-40,100000";
        String tipoInversor = "emp";
        String[] argumentos = {tipoInversor,argumentosDol,argumentosPFP,argumentosPFT};

        String resultado = SimuladorDeImpuestos.main(argumentos);
        Assert.assertEquals(unaSalida,resultado);
    }

    @Test
    public void deberiaLanzarExcepcionTipoInversor() {
        String unaSalida = "Tipo de inversor inválido.";
        String argumentosDol = "dol,20000,20,28";
        String argumentosPFT = "pft,90,40,250000";
        String argumentosPFP = "pfp,70,300,40,100000";
        String tipoInversor = "per";
        String[] argumentos = {tipoInversor,argumentosDol,argumentosPFP,argumentosPFT};

        String resultado = SimuladorDeImpuestos.main(argumentos);
        Assert.assertEquals(unaSalida,resultado);
    }

    @Test
    public void deberiaLanzarExcepcionTipoInversorPorLargo() {
        String unaSalida = "Tipo de inversor inválido.";
        String argumentosDol = "dol,20000,20,28";
        String argumentosPFT = "pft,90,40,250000";
        String argumentosPFP = "pfp,70,300,40,100000";
        String tipoInversor = "pind";
        String[] argumentos = {tipoInversor,argumentosDol,argumentosPFP,argumentosPFT};

        String resultado = SimuladorDeImpuestos.main(argumentos);
        Assert.assertEquals(unaSalida,resultado);
    }

    @Test
    public void deberiaLanzarExcepcionTipoInversorPorLargo2() {
        String unaSalida = "Tipo de inversor inválido.";
        String argumentosDol = "dol,20000,20,28";
        String argumentosPFT = "pft,90,40,250000";
        String argumentosPFP = "pfp,70,300,40,100000";
        String tipoInversor = "indd";
        String[] argumentos = {tipoInversor,argumentosDol,argumentosPFP,argumentosPFT};

        String resultado = SimuladorDeImpuestos.main(argumentos);
        Assert.assertEquals(unaSalida,resultado);
    }
}
