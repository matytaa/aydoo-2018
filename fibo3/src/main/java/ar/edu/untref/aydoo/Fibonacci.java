package ar.edu.untref.aydoo;

import java.util.ArrayList;

public class Fibonacci {

    private int resultadoParcial = 0;
    private int numeroFibonacci = 0;
    private String cuerpoTxt = "";
    private String cabeceraTxt;
    private GenerardorDeArchivos miGenerador;
    private String archivoDeSalida;
    private boolean salidaPorPantalla;
    private boolean continuar;
    private ArrayList<Integer> listaDeValores;

    public Fibonacci(int unNumeroFibonacci) {
        this.numeroFibonacci = unNumeroFibonacci;
        armarCabeceraDeSalida();
        this.archivoDeSalida = "";
        this.salidaPorPantalla = true;
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

    private void armarCabeceraDeSalida() {
        this.cabeceraTxt = "fibo<" + this.numeroFibonacci + ">";
    }


    public int ejecutarSumatoriaFibonacci() {
        int resultadoFinal = 0;
        for (int i = 0; i < this.numeroFibonacci + 1; i++) {
            resultadoFinal += calcularFibonacci(i);
        }
        //this.cuerpoTxt = "" + resultadoFinal;
        //imprimirSalida();
        listaDeValores.add(resultadoFinal);
        return resultadoFinal;
    }

    public int ejecutarFibonacciDirecto() {
        for (int i = 0; i < this.numeroFibonacci + 1; i++) {
            /*this.cuerpoTxt = this.cuerpoTxt
                    +
            this.unCompositor.imprimirFibonacci(calcularFibonacci(i));*/
            listaDeValores.add(calcularFibonacci(i));
        }
        //imprimirSalida();
        return this.resultadoParcial;
    }

    public int ejecutarFibonacciInverso() {
        for (int i = this.numeroFibonacci; i >= 0; i--) {
            //this.cuerpoTxt = this.cuerpoTxt
              //      + imprimirFibonacci(calcularFibonacci(i));
            listaDeValores.add(calcularFibonacci(i));
        }
        //imprimirSalida();
        return this.resultadoParcial;
    }

    private String imprimirFibonacci(int numeroFibonacciAImprimir) {
        String cadanaAImprimir = "";
        if (1==2/*this.vertical*/) {
            cadanaAImprimir = "\n" + numeroFibonacciAImprimir;
        } else {
            cadanaAImprimir = cadanaAImprimir + " " + numeroFibonacciAImprimir;
        }
        return cadanaAImprimir;
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
        miFibonacci.armarCabeceraDeSalida();
    }
}
