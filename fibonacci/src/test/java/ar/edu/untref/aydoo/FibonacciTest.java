package ar.edu.untref.aydoo;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import junit.framework.Assert;

public class FibonacciTest {

	Fibonacci miFibonacci = new Fibonacci();
	int resultado = 0;
	
	@Test
	public void fibonacciDe1() {
		resultado = miFibonacci.calcularFibonacci(1);
		Assert.assertEquals(1, resultado);
	}
	
	@Test
	public void fibonacciDe2() {
		resultado = miFibonacci.calcularFibonacci(2);
		Assert.assertEquals(1, resultado);
	}
	
	@Test
	public void fibonacciDe3() {
		resultado = miFibonacci.calcularFibonacci(3);
		Assert.assertEquals(2, resultado);
	}
	
	@Test
	public void fibonacciDe4() {
		resultado = miFibonacci.calcularFibonacci(4);
		Assert.assertEquals(3, resultado);
	}
	@Test
	public void fibonacciDe5() {
		resultado = miFibonacci.calcularFibonacci(5);
		Assert.assertEquals(5, resultado);
	}
	@Test
	public void fibonacciDe6() {
		resultado = miFibonacci.calcularFibonacci(6);
		Assert.assertEquals(8, resultado);
	}
	@Test
	public void fibonacciDe7() {
		resultado = miFibonacci.calcularFibonacci(7);
		Assert.assertEquals(13, resultado);
	}
	@Test
	public void fibonacciDe8() {
		resultado = miFibonacci.calcularFibonacci(8);
		Assert.assertEquals(21, resultado);
	}
	@Test
	public void fibonacciDe9() {
		resultado = miFibonacci.calcularFibonacci(9);
		Assert.assertEquals(34, resultado);
	}
	@Test
	public void fibonacciDe10() {
		resultado = miFibonacci.calcularFibonacci(10);
		Assert.assertEquals(55, resultado);
	}
	@Test
	public void fibonacciDe11() {
		resultado = miFibonacci.calcularFibonacci(11);
		Assert.assertEquals(89, resultado);
	}
	@Test
	public void fibonacciDe12() {
		resultado = miFibonacci.calcularFibonacci(12);
		Assert.assertEquals(144, resultado);
	}
}
