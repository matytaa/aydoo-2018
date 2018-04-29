package ar.edu.untref.aydoo;


import org.junit.Assert;
import org.junit.Test;


public class FibonacciTest {


    @Test
    public void fibonacciDe1() {
        Fibonacci miFibonacci = new Fibonacci(1);
        int resultado = 0;
        resultado = miFibonacci.ejecutarFibonacci();
        Assert.assertEquals(0, resultado);
    }

    @Test
    public void fibonacciDe2() {
        Fibonacci miFibonacci = new Fibonacci(2);
        int resultado = 0;
        resultado = miFibonacci.ejecutarFibonacci();
        Assert.assertEquals(1, resultado);
    }

    @Test
    public void fibonacciDe3() {
        Fibonacci miFibonacci = new Fibonacci(3);
        int resultado = 0;
        resultado = miFibonacci.ejecutarFibonacci();
        Assert.assertEquals(1, resultado);
    }

    @Test
    public void fibonacciDe4() {
        Fibonacci miFibonacci = new Fibonacci(4);
        int resultado = 0;
        resultado = miFibonacci.ejecutarFibonacci();
        Assert.assertEquals(2, resultado);
    }

    @Test
    public void fibonacciDe5() {
        Fibonacci miFibonacci = new Fibonacci(5);
        int resultado = 0;
        resultado = miFibonacci.ejecutarFibonacci();
        Assert.assertEquals(3, resultado);
    }

    @Test
    public void fibonacciDe6() {
        Fibonacci miFibonacci = new Fibonacci(6);
        int resultado = 0;
        resultado = miFibonacci.ejecutarFibonacci();
        Assert.assertEquals(5, resultado);
    }

    @Test
    public void fibonacciDe7() {
        Fibonacci miFibonacci = new Fibonacci(7);
        int resultado = 0;
        resultado = miFibonacci.ejecutarFibonacci();
        Assert.assertEquals(8, resultado);
    }

    @Test
    public void fibonacciDe8() {
        Fibonacci miFibonacci = new Fibonacci(8);
        int resultado = 0;
        resultado = miFibonacci.ejecutarFibonacci();
        Assert.assertEquals(13, resultado);
    }

    @Test
    public void fibonacciDe9() {
        Fibonacci miFibonacci = new Fibonacci(9);
        int resultado = 0;
        resultado = miFibonacci.ejecutarFibonacci();
        Assert.assertEquals(21, resultado);
    }

    @Test
    public void fibonacciDe10() {
        Fibonacci miFibonacci = new Fibonacci(10);
        int resultado = 0;
        resultado = miFibonacci.ejecutarFibonacci();
        Assert.assertEquals(34, resultado);
    }

    @Test
    public void fibonacciDe11() {
        Fibonacci miFibonacci = new Fibonacci(11);
        int resultado = 0;
        resultado = miFibonacci.ejecutarFibonacci();
        Assert.assertEquals(55, resultado);
    }

    @Test
    public void fibonacciDe12() {
        Fibonacci miFibonacci = new Fibonacci(12);
        int resultado = 0;
        resultado = miFibonacci.ejecutarFibonacci();
        Assert.assertEquals(89, resultado);
    }

    @Test
    public void imprimirFiboEnVertical() {
        Fibonacci miFibonacci = new Fibonacci(12);
        int resultado = 0;
        miFibonacci.imprimeEnVertical(true);
        resultado = miFibonacci.ejecutarFibonacci();
        Assert.assertEquals(89, resultado);
    }

    @Test
    public void imprimirFiboInverso() {
        Fibonacci miFibonacci = new Fibonacci(12);
        int resultado = 0;
        miFibonacci.imprimeEnVertical(false);
        miFibonacci.ejecutarEnOrdenInverso(true);
        resultado = miFibonacci.ejecutarFibonacciInverso();
        Assert.assertEquals(0, resultado);
    }

    @Test
    public void imprimirFiboInversoVertical() {
        Fibonacci miFibonacci = new Fibonacci(12);
        int resultado = 0;
        miFibonacci.imprimeEnVertical(true);
        miFibonacci.ejecutarEnOrdenInverso(true);
        resultado = miFibonacci.ejecutarFibonacciInverso();
        Assert.assertEquals(0, resultado);
    }

    @Test
    public void recibeParametro_vd_debeImprimirVerticalDirecto() {
        Fibonacci miFibonacci = new Fibonacci(12);
        miFibonacci.definirSalidaHorizontalOVertical("-o=vd");
        Assert.assertTrue(miFibonacci.puedoContinuar());
        int resultado = miFibonacci.ejecutarFibonacci();
        Assert.assertEquals(89, resultado);
    }

    @Test
    public void recibeParametro_xy_resultadoDebeSerCero() {
        Fibonacci miFibonacci = new Fibonacci(12);
        miFibonacci.definirSalidaHorizontalOVertical("-o=xy");
        Assert.assertFalse(miFibonacci.puedoContinuar());
        int resultado = 0;
        resultado = miFibonacci.ejecutarFibonacci();
        Assert.assertEquals(0, resultado);
    }

    @Test
    public void fibonacciDe8VD() {
        Fibonacci miFibonacci = new Fibonacci(8);
        miFibonacci.definirSalidaHorizontalOVertical("-o=vd");
        Assert.assertTrue(miFibonacci.puedoContinuar());
        int resultado = 0;
        resultado = miFibonacci.ejecutarFibonacci();
        Assert.assertEquals(13, resultado);
    }

    @Test
    public void fibonacciDe8VI() {
        Fibonacci miFibonacci = new Fibonacci(8);
        miFibonacci.definirSalidaHorizontalOVertical("-o=vi");
        Assert.assertTrue(miFibonacci.puedoContinuar());
        int resultado = 0;
        resultado = miFibonacci.ejecutarFibonacci();
        Assert.assertEquals(0, resultado);
    }

    @Test
    public void enviarSalidaErroneaYNoDeberiaPoderContinuar() {
        Fibonacci miFibonacci = new Fibonacci(8);
        miFibonacci.definirSalidaHorizontalOVertical("-o=xs");
        Assert.assertFalse(miFibonacci.puedoContinuar());
    }

    @Test
    public void generarArchivoConElResultadoDeLaEjecion(){
        Fibonacci miFibonacci = new Fibonacci(5);
        String resultado = "fibo<5>:\n" + "0\n" + "1\n" + "1\n" + "2\n" + "3";
        Assert.assertTrue(miFibonacci.generarArchivo("salida.txt"));
        miFibonacci.escribirResultado(resultado);
    }

    @Test
    public void puedoSumarValoresDeberiaDarFalso(){
        Fibonacci miFibonacci = new Fibonacci(5);
        Assert.assertFalse(miFibonacci.puedoSumarVaroles());
    }

    @Test
    public void cambiarSumaDeValoresAVerdadero(){
        Fibonacci miFibonacci = new Fibonacci(5);
        miFibonacci.aplicarSumaDeValores(true);
        Assert.assertTrue(miFibonacci.puedoSumarVaroles());
    }

    @Test
    public void sumarDeValoresDelFibonacciDe5DeberiaDar7(){
        Fibonacci miFibonacci = new Fibonacci(5);
        miFibonacci.aplicarSumaDeValores(true);
        int resultado = 7;
        Assert.assertEquals(resultado, miFibonacci.ejecutarFibonacci());
    }

    @Test
    public void sumarDeValoresDelFibonacciDe6DeberiaDar11(){
        Fibonacci miFibonacci = new Fibonacci(6);
        miFibonacci.aplicarSumaDeValores(true);
        int resultado = 12;
        Assert.assertEquals(resultado, miFibonacci.ejecutarFibonacci());
    }

    @Test
    public void recibirParametrosParaEjecutarListaDeberiaDar3ElFibonacciDe5(){
        Fibonacci miFibonacci = new Fibonacci(5);
        miFibonacci.definirSalidaListaOSumatoria("-m=l");
        int resultado = 3;
        Assert.assertEquals(resultado, miFibonacci.ejecutarFibonacci());
    }

    @Test
    public void recibirParametrosParaEjecutarSumatoriaDeberiaDar12(){
        Fibonacci miFibonacci = new Fibonacci(6);
        miFibonacci.definirSalidaListaOSumatoria("-m=s");
        int resultado = 12;
        Assert.assertEquals(resultado, miFibonacci.ejecutarFibonacci());
    }
}
