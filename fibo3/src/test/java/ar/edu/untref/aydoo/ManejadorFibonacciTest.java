package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ManejadorFibonacciTest {
    @Test
    public void deberiaPoderSetearParametrosCorrectamente(){
        ProcesadorDeParametros unProcesador = new ProcesadorDeParametros();
        ManejadorFibonacci miManejador = new ManejadorFibonacci(unProcesador, null);
        miManejador.procesarArgumentos("-m=s");
        Assert.assertTrue(miManejador.darProcesadorDeParemetros().puedoContinuar());
    }

    @Test
    public void deberiaPoderEjecutarElFibonacciDe7(){

        Fibonacci unFibonacci = null;
        ManejadorFibonacci miManejador = new ManejadorFibonacci(null, unFibonacci);
        int resultado = 13;
        Assert.assertEquals(resultado, miManejador.ejecutarFibonnaci(7));
    }
}
