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

    @Test
    public void deberiaPoderImprimirVertical() {
        ProcesadorDeParametros miProcesador = new ProcesadorDeParametros();
        miProcesador.definirSalidaHorizontalOVertical("-o=vd");
        Assert.assertTrue(miProcesador.imprimirEnVertical());
    }

    @Test
    public void deberiaPoderImprimirEnOrdenInverso() {
        ProcesadorDeParametros miProcesador = new ProcesadorDeParametros();
        miProcesador.definirSalidaHorizontalOVertical("-o=vi");
        Assert.assertTrue(miProcesador.esEjecucionInversa());
    }
}
