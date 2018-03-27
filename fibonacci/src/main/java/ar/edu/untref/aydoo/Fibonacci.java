package ar.edu.untref.aydoo;

public class Fibonacci {
	private int resultadoParcial = 0;
	private int numeroFibonaci = 0;
	//private int resultadoFinal = 0;
	
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
	
	public int ejecutarFibonacci(int numeroFibonacci) {
		String cabecera = "fibo<"+numeroFibonacci+">: ";
		String cuerpo = "";
		for (int i = 0; i < numeroFibonacci; i++) {
			cuerpo = cuerpo + " " + calcularFibonacci(i);
		}
		System.out.println(cabecera + cuerpo);
		return this.resultadoParcial;
	}
	

}
