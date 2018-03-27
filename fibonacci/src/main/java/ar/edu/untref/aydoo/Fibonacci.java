package ar.edu.untref.aydoo;

public class Fibonacci {
	private int resultadoParcial = 1;
	private int numerador = 0;
	private int denominador = 0;
	private int numero = 0;
	
	public int calcularFibonacci(int numeroFibonacci) {

		if (verificarNumero(numeroFibonacci)){
			int numeroAnterior = numeroFibonacci - 1;
			resultadoParcial = calcularFibonacci(numeroAnterior) + calcularFibonacci(numeroAnterior-1);
		}
		return resultadoParcial;
	}

	private boolean verificarNumero(int numeroFibonacci) {
		if (numeroFibonacci==0) {
			this.resultadoParcial = 0;
		}
		else {
			this.resultadoParcial = 1;
		}
		return (numeroFibonacci > 1);
	}

}
