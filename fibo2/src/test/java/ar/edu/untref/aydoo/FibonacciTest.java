package ar.edu.untref.aydoo;


import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
    public void recibeParametro_vd_debeImprimirVerticalDirecto() throws Exception {
        Fibonacci miFibonacci = new Fibonacci(12);
        int resultado = 0;
        miFibonacci.recibirParamtetros("-o=vd");
        resultado = miFibonacci.ejecutarFibonacciInverso();
        Assert.assertEquals(0, resultado);
    }

    @Test (expected = Exception.class)
    public void recibeParametro_xy_debeLanzarExcepcion() throws Exception {
        Fibonacci miFibonacci = new Fibonacci(12);
        int resultado = 0;
        miFibonacci.recibirParamtetros("-o=xy");
        resultado = miFibonacci.ejecutarFibonacciInverso();
        Assert.assertEquals(0, resultado);
    }

    @Test
    public void fibonacciDe8VD() {
        Fibonacci miFibonacci = new Fibonacci(8);
        int resultado = 0;
        try {
            miFibonacci.recibirParamtetros("-o=vd");
        } catch (Exception e) {
            e.printStackTrace();
        }
        resultado = miFibonacci.ejecutarFibonacci();
        Assert.assertEquals(13, resultado);
    }

    @Test
    public void asd() {
        String argumento1 = "-o=vi";
        String argumento2 = "-o=vd";
        String argumento3 = "-o=hi";
        String argumento4 = "-o=hi";
    }
}
