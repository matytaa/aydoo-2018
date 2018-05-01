package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ManejadorFibonacciTest {

    @Test
    public void deberiaPoderSetearParametrosCorrectamente() {
        ProcesadorDeParametros unProcesador = new ProcesadorDeParametros();
        ManejadorFibonacci miManejador = new ManejadorFibonacci(unProcesador, null);
        miManejador.procesarArgumentos("-m=s");
        Assert.assertTrue(miManejador.darProcesadorDeParemetros().puedoContinuar());
    }

    @Test
    public void fibonacciDe8VD() {
        ProcesadorDeParametros unProcesador = new ProcesadorDeParametros();
        ManejadorFibonacci miManejador = new ManejadorFibonacci(unProcesador, null);
        miManejador.procesarArgumentos("-o=vd");
        Assert.assertTrue(unProcesador.puedoContinuar());
        int resultado = 0;
        resultado = miManejador.ejecutarFibonnaci(8);
        Assert.assertEquals(21, resultado);
    }

    @Test
    public void fibonacciDe8VI() {
        ProcesadorDeParametros unProcesador = new ProcesadorDeParametros();
        ManejadorFibonacci miManejador = new ManejadorFibonacci(unProcesador, null);
        Fibonacci miFibonacci = new Fibonacci(8);
        unProcesador.recibirParametros("-o=vi");
        Assert.assertTrue(miManejador.darProcesadorDeParemetros().puedoContinuar());
        int resultado = 0;
        resultado = miFibonacci.ejecutarFibonacciInverso();
        Assert.assertEquals(0, resultado);
    }

}
