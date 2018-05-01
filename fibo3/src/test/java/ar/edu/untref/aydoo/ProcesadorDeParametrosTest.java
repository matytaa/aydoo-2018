package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ProcesadorDeParametrosTest {
    @Test
    public void deberiaRecibirParametrosCorrectamente() {
        ProcesadorDeParametros miProcesador = new ProcesadorDeParametros();
        miProcesador.definirSalidaHorizontalOVertical("-o=vd");
        Assert.assertTrue(miProcesador.puedoContinuar());
    }

}
