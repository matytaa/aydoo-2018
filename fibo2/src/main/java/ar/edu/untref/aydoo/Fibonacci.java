package ar.edu.untref.aydoo;

public class Fibonacci {
    private boolean vertical;
    private int resultadoParcial = 0;
    private int numeroFibonacci = 0;

    public Fibonacci(final int unNumeroFibonacci) {
        this.numeroFibonacci = unNumeroFibonacci;
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

    public int ejecutarFibonacci() {
        String cabecera = "fibo<" + this.numeroFibonacci + ">: ";
        String cuerpo = "";
        for (int i = 0; i < this.numeroFibonacci; i++) {
            //cuerpo = cuerpo + " " + calcularFibonacci(i);
            cuerpo = cuerpo + imprimirFibonacci(calcularFibonacci(i));
        }
        System.out.println(cabecera + cuerpo);
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

    public static void main(final String[] args) {
        if (args.length == 1) {
            int numeroFib = Integer.parseInt(args[0]);
            Fibonacci miFibonacci = new Fibonacci(numeroFib);
            miFibonacci.ejecutarFibonacci();

        }
    }

    public void definirTipoSalida(final boolean imprimeVertical) {
        this.vertical = imprimeVertical;
    }
}
