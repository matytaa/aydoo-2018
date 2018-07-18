package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.excepciones.InversionException;
import ar.edu.untref.aydoo.excepciones.MontoInicialException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CreadorDeInversionesTest {
    @Test
    public void deberiaObtenerUnaListaConUnaInversionCompraDeDolares() throws InversionException {
        CreadorDeInversiones creador = new CreadorDeInversiones();
        String argumentosDol = "dol,20000,20,28";
        List<Inversion> unaLista = creador.crearInversion(argumentosDol);
        Assert.assertEquals(1,unaLista.size());
    }

    @Test(expected = MontoInicialException.class)
    public void noDeberiaObtenerUnaListaConUnaInversionCompraDeDolares() throws InversionException {
        CreadorDeInversiones creador = new CreadorDeInversiones();
        String argumentosDol = "dol,-20000,20,28";
        creador.crearInversion(argumentosDol);
    }

    @Test
    public void deberiaObtenerUnaListaConUnaInversionPlazoFijo() throws InversionException {
        CreadorDeInversiones creador = new CreadorDeInversiones();
        String argumentosPFT = "pft,90,40,250000";
        List<Inversion> unaLista = creador.crearInversion(argumentosPFT);
        Assert.assertEquals(1,unaLista.size());
    }

    @Test
    public void deberiaObtenerUnaListaConUnaInversionPlazoFijoPrecancelable() throws InversionException {
        CreadorDeInversiones creador = new CreadorDeInversiones();
        String argumentosPFP = "pfp,365,300,40,100000";
        List<Inversion> unaLista = creador.crearInversion(argumentosPFP);
        Assert.assertEquals(1,unaLista.size());
    }
}
