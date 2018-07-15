package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.excepciones.InversionException;
import ar.edu.untref.aydoo.excepciones.MontoInicialException;
import ar.edu.untref.aydoo.excepciones.PlazoAcordadoException;
import ar.edu.untref.aydoo.excepciones.PorcentajeInversionException;
import org.junit.Test;
import org.junit.Assert;

public class PlazoFijoTest {

    @Test
    public void deberiaObtenerGanaciasDelPlazoFijo() throws InversionException {
        PlazoFijo unPlazoFijo = new PlazoFijo(1500d, 30, 10d);
        Double resultado = unPlazoFijo.obtenerGanacias();
        Assert.assertEquals(150d, resultado, 0.001);
    }

    @Test(expected = MontoInicialException.class)
    public void deberiaLanzarExcepcionDeMontoInicial() throws MontoInicialException {
        PlazoFijo unPlazoFijo = new PlazoFijo(15d, 30, 10d);
    }

    @Test(expected = PlazoAcordadoException.class)
    public void deberiaLanzarExcepcionDePlazoAcordado() throws InversionException {
        PlazoFijo unPlazoFijo = new PlazoFijo(1500d, 29, 10d);
        Double resultado = unPlazoFijo.obtenerGanacias();
    }

    @Test(expected = PorcentajeInversionException.class)
    public void deberiaLanzarExcepcionDePorcentajeDeInversion() throws InversionException {
        PlazoFijo unPlazoFijo = new PlazoFijo(1500d, 31, -10d);
        Double resultado = unPlazoFijo.obtenerGanacias();
    }
}
