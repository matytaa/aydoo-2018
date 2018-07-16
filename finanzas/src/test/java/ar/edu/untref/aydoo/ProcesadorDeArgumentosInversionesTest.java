package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.excepciones.InversionException;
import ar.edu.untref.aydoo.excepciones.InversionInvalidaException;
import org.junit.Assert;
import org.junit.Test;

public class ProcesadorDeArgumentosInversionesTest {
    @Test
    public void deberiaAdmitirElParametroParaInversionDeDolares() {
        String argumentosDol = "dol,20000,20,28";
        ProcesadorDeArgumentosInversiones procesador = new ProcesadorDeArgumentosInversiones(argumentosDol);
        Assert.assertTrue(procesador.puedeCrearInversion(argumentosDol));
    }

    @Test
    public void deberiaAdmitirElParametroParaInversionDePlazoFijo() {
        String argumentosPFT = "pft,90,40,250000";
        ProcesadorDeArgumentosInversiones procesador = new ProcesadorDeArgumentosInversiones(argumentosPFT);
        Assert.assertTrue(procesador.puedeCrearInversion(argumentosPFT));
    }

    @Test
    public void deberiaAdmitirElParametroParaInversionDePlazoFijoPrecancelable() {
        String argumentosPFP = "pfp,365,300,40,100000";
        ProcesadorDeArgumentosInversiones procesador = new ProcesadorDeArgumentosInversiones(argumentosPFP);
        Assert.assertTrue(procesador.puedeCrearInversionPlazoFijoPrecancelable(argumentosPFP));
    }

    @Test
    public void deberianSerValidosTodosLosArgumentos() throws InversionException {
        String argumentosDol = "dol,20000,20,28";
        String argumentosPFT = "pft,90,40,250000";
        String argumentosPFP = "pfp,365,300,40,100000";
        String argumentos = argumentosDol + " " + argumentosPFP + " " + argumentosPFT;
        ProcesadorDeArgumentosInversiones procesador = new ProcesadorDeArgumentosInversiones(argumentos);
        Assert.assertTrue(procesador.procesar());
    }

    @Test(expected = InversionInvalidaException.class)
    public void deberiaRetornarFalseYaQueExisteUnArgumentoInvalido() throws InversionException {
        String argumentosDol = "dol,20000,20,28";
        String argumentosPFT = "pft,90,40,250000";
        String argumentosPFP = "pfT,365,300,40,100000";
        String argumentos = argumentosDol + " " + argumentosPFP + " " + argumentosPFT;
        ProcesadorDeArgumentosInversiones procesador = new ProcesadorDeArgumentosInversiones(argumentos);
        Assert.assertFalse(procesador.procesar());
    }
}
