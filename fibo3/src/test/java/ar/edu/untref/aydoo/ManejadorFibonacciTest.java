package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ManejadorFibonacciTest {
    @Test
    public void deberiaPoderSetearParametrosCorrectamente(){
        ProcesadorDeParametros unProcesador = new ProcesadorDeParametros();
        ManejadorFibonacci miManejador = new ManejadorFibonacci(unProcesador);
        miManejador.procesarArgumentos("-m=s");
        Assert.assertTrue(miManejador.darProcesadorDeParemetros().puedoContinuar());
    }
}
