package ar.edu.untref.aydoo;

public class Fibonacci {
    private boolean vertical;
    private boolean ordenInverso;
    private int resultadoParcial = 0;
    private int numeroFibonacci = 0;
    private String cuerpoTxt = "";
    private String cabeceraTxt;

    public Fibonacci(final int unNumeroFibonacci) {
        this.numeroFibonacci = unNumeroFibonacci;
        armarCabeceraDeSalida();
    }

    public int calcularFibonacci(final int unNumeroFibonacci) {

        if (verificarNumero(unNumeroFibonacci)) {
            int numeroAnterior = unNumeroFibonacci - 1;
            resultadoParcial = calcularFibonacci(numeroAnterior)
                    + calcularFibonacci(numeroAnterior - 1);
        }
        return resultadoParcial;
    }

    private boolean verificarNumero(final int unNumeroFibonacci) {
        if (unNumeroFibonacci == 0) {
            this.resultadoParcial = 0;
        } else {
            this.resultadoParcial = 1;
        }
        return (unNumeroFibonacci > 1);
    }

    private void armarCabeceraDeSalida() {
        this.cabeceraTxt = "fibo<" + this.numeroFibonacci + ">: ";
    }

    public int ejecutarFibonacci() {
        for (int i = 0; i < this.numeroFibonacci; i++) {
            this.cuerpoTxt = this.cuerpoTxt
                    + imprimirFibonacci(calcularFibonacci(i));
        }
        System.out.println(this.cabeceraTxt + this.cuerpoTxt);
        return this.resultadoParcial;
    }

    public int ejecutarFibonacciInverso() {
        for (int i = this.numeroFibonacci; i >= 0; i--) {
            this.cuerpoTxt = this.cuerpoTxt
                    + imprimirFibonacci(calcularFibonacci(i));
        }
        System.out.println(this.cabeceraTxt + this.cuerpoTxt);
        return this.resultadoParcial;
    }

    private String imprimirFibonacci(final int numeroFibonacciAImprimir) {
        String cadanaAImprimir = "";
        if (this.vertical) {
            cadanaAImprimir = "\n" + numeroFibonacciAImprimir + "\n";
        } else {
            cadanaAImprimir = cadanaAImprimir + " " + numeroFibonacciAImprimir;
        }
        return cadanaAImprimir;
    }

    public void imprimeEnVertical(final boolean imprimeVertical) {
        this.vertical = imprimeVertical;
    }

    public void ejecutarEnOrdenInverso(final boolean unOrden) {
        this.ordenInverso = unOrden;
    }

    public void recibirParamtetros(String parametros) {
        imprimeEnVertical(parametros.contains("v"));
        ejecutarEnOrdenInverso(parametros.contains("i"));
    }

    public static void main(final String[] args) {
        if (args.length == 1) {
            int numeroFib = Integer.parseInt(args[0]);
            Fibonacci miFibonacci = new Fibonacci(numeroFib);
            miFibonacci.ejecutarFibonacci();
            miFibonacci.armarCabeceraDeSalida();
        }
    }
}
