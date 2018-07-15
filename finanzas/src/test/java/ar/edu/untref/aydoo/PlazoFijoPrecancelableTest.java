package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.excepciones.InversionException;
import ar.edu.untref.aydoo.excepciones.MontoInicialException;
import ar.edu.untref.aydoo.excepciones.PlazoAcordadoException;
import ar.edu.untref.aydoo.excepciones.PorcentajeInversionException;
import org.junit.Test;
import org.junit.Assert;

public class PlazoFijoPrecancelableTest {
    @Test
    public void deberiaDeObtenerGananciaTotalDeUnPlazoFijoPrecancelable() throws InversionException {
        PlazoFijoPrecancelable prestamo = new PlazoFijoPrecancelable(1500d,90, 90,20d);
        Double resultado = prestamo.obtenerGanacias();
        Assert.assertEquals(300d, resultado, 0.001);
    }

    @Test
    public void deberiaDeObtenerGananciaParcialDeUnPlazoFijoPrecancelable() throws InversionException {
        PlazoFijoPrecancelable prestamo = new PlazoFijoPrecancelable(1500d,90, 80,20d);
        Double resultado = prestamo.obtenerGanacias();
        Assert.assertEquals(150d, resultado, 0.001);
    }

    @Test(expected = MontoInicialException.class)
    public void deberiaLanzarExcepcionDeMontoInicial() throws InversionException {
        PlazoFijoPrecancelable prestamo = new PlazoFijoPrecancelable(500d,90, 80,20d);
    }

    @Test(expected = PorcentajeInversionException.class)
    public void deberiaLanzarExcepcionDePorcentajeInversion() throws InversionException {
        PlazoFijoPrecancelable prestamo = new PlazoFijoPrecancelable(1500d,90, 80,-20d);
        Double resultado = prestamo.obtenerGanacias();
    }

    @Test(expected = PlazoAcordadoException.class)
    public void deberiaLanzarExcepcionDePlazoAcordado() throws InversionException {
        PlazoFijoPrecancelable prestamo = new PlazoFijoPrecancelable(1500d,50, 50,20d);
        Double resultado = prestamo.obtenerGanacias();
    }
}
