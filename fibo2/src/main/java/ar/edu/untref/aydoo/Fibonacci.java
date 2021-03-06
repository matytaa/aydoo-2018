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
        if (esEjecucionInversa()) {
            return ejecutarFibonacciInverso();
        }
        return ejecutarFibonacciDirecto();
    }

    private boolean esEjecucionInversa() {
        return this.ordenInverso;
    }

    public int ejecutarFibonacciDirecto() {
        for (int i = 0; i < this.numeroFibonacci; i++) {
            this.cuerpoTxt = this.cuerpoTxt
                    + imprimirFibonacci(calcularFibonacci(i));
        }
        System.out.println(this.cabeceraTxt + this.cuerpoTxt);
        return this.resultadoParcial;
    }

    public int ejecutarFibonacciInverso() {
        for (int i = this.numeroFibonacci - 1; i >= 0; i--) {
            this.cuerpoTxt = this.cuerpoTxt
                    + imprimirFibonacci(calcularFibonacci(i));
        }
        System.out.println(this.cabeceraTxt + this.cuerpoTxt);
        return this.resultadoParcial;
    }

    private String imprimirFibonacci(final int numeroFibonacciAImprimir) {
        String cadanaAImprimir = "";
        if (this.vertical) {
            cadanaAImprimir = "\n" + numeroFibonacciAImprimir;
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

    public int ejecutarConParametros(final String parametros) {
        int valorRetorno = 0;
        if ((parametros.equals("-o=vi"))
                || (parametros.equals("-o=vd"))
                || (parametros.equals("-o=hi"))
                || (parametros.equals("-o=hd"))
                || (parametros.equals(""))) {
            imprimeEnVertical(parametros.contains("v"));
            ejecutarEnOrdenInverso(parametros.contains("i"));
            valorRetorno = ejecutarFibonacci();
            armarCabeceraDeSalida();
        } else {
            System.out.println("Opciones no validas");
        }
        return valorRetorno;
    }

    public static void main(final String[] args) {
        int numeroFib = -1;
        String argumentoTipoImpresion = "";
        if (args.length == 1) {
            numeroFib = Integer.parseInt(args[0]);
        } else if (args.length > 1) {
            argumentoTipoImpresion = args[0];
            numeroFib = Integer.parseInt(args[1]);
        }
        Fibonacci miFibonacci = new Fibonacci(numeroFib);
        miFibonacci.ejecutarConParametros(argumentoTipoImpresion);
    }
}
