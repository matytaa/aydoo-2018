package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.excepciones.InversionException;
import ar.edu.untref.aydoo.excepciones.MontoInicialException;
import org.junit.Test;
import org.junit.Assert;

public class CompraDolaresTest {
    @Test
    public void deberiaObtenerGanaciasDeLaCompraDeDolares() throws InversionException {
        CompraDolares compra = new CompraDolares(1500d, 28d, 28.5d);
        Double resultado = compra.obtenerGanacias();
        Assert.assertEquals(26.785d, resultado, 0.001);
    }

    @Test(expected = MontoInicialException.class)
    public void deberiaLanzarExcepcionMontoInicila() throws InversionException {
        CompraDolares compra = new CompraDolares(900d, 28d, 28.5d);
    }

    @Test
    public void deberiaObtenerPerdidaDeLaCompraDeDolares() throws InversionException {
        CompraDolares compra = new CompraDolares(15000d, 28d, 25d);
        Double resultado = compra.obtenerGanacias();
        Assert.assertEquals(-1607.142d, resultado, 0.001);
    }
}
