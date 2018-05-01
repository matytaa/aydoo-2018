package ar.edu.untref.aydoo;

import java.util.ArrayList;

public class Fibonacci {

    private int resultadoParcial = 0;
    private int numeroFibonacci = 0;
    private ArrayList<Integer> listaDeValores;

    public Fibonacci(int unNumeroFibonacci) {
        this.numeroFibonacci = unNumeroFibonacci;
        this.listaDeValores = new ArrayList<Integer>();
    }

    public int calcularFibonacci(int unNumeroFibonacci) {

        if (verificarNumero(unNumeroFibonacci)) {
            int numeroAnterior = unNumeroFibonacci - 1;
            resultadoParcial = calcularFibonacci(numeroAnterior)
                    + calcularFibonacci(numeroAnterior - 1);
        }
        return resultadoParcial;
    }

    private boolean verificarNumero(int unNumeroFibonacci) {
        if (unNumeroFibonacci == 0) {
            this.resultadoParcial = 0;
        } else if (unNumeroFibonacci > 0) {
            this.resultadoParcial = 1;
        }
        return (unNumeroFibonacci > 1);
    }

    public int ejecutarSumatoriaFibonacci() {
        int resultadoFinal = 0;
        for (int i = 0; i < this.numeroFibonacci + 1; i++) {
            resultadoFinal += calcularFibonacci(i);
        }
        listaDeValores.add(resultadoFinal);
        return resultadoFinal;
    }

    public int ejecutarFibonacciDirecto() {
        for (int i = 0; i < this.numeroFibonacci + 1; i++) {
            listaDeValores.add(calcularFibonacci(i));
        }
        return this.resultadoParcial;
    }

    public int ejecutarFibonacciInverso() {
        for (int i = this.numeroFibonacci; i >= 0; i--) {
            listaDeValores.add(calcularFibonacci(i));
        }
        return this.resultadoParcial;
    }


    public ArrayList<Integer> darListaDeValores() {
        return this.listaDeValores;
    }

    public static void main(String[] args) {
        int numeroFib = -1;
        String argumentoTipoImpresion = "";
        String argumentoArchivo = "";
        String argumentoSumatoria = "";

        int cantidadDeArgumentos = args.length;
        numeroFib = Integer.parseInt(args[cantidadDeArgumentos - 1]);

        Fibonacci miFibonacci = new Fibonacci(numeroFib);
        //miFibonacci.definirSalidaHorizontalOVertical(argumentoTipoImpresion);
        //miFibonacci.ejecutarFibonacci();
        //miFibonacci.armarCabeceraDeSalida();
    }
}
