package ar.edu.untref.aydoo;

public class Fibonacci {
    private boolean vertical;
    private boolean ordenInverso;
    private int resultadoParcial = 0;
    private int numeroFibonacci = 0;
    private String cuerpoTxt = "";
    private String cabeceraTxt;
    private boolean continuar;

    public Fibonacci(int unNumeroFibonacci) {
        this.numeroFibonacci = unNumeroFibonacci;
        armarCabeceraDeSalida();
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
        imprimirSalida();
        return this.resultadoParcial;
    }

    public void imprimirSalida() {
        if (this.continuar) {
            System.out.println(this.cabeceraTxt + this.cuerpoTxt);
        }
    }

    public int ejecutarFibonacciInverso() {
        for (int i = this.numeroFibonacci - 1; i >= 0; i--) {
            this.cuerpoTxt = this.cuerpoTxt
                    + imprimirFibonacci(calcularFibonacci(i));
        }
        imprimirSalida();
        return this.resultadoParcial;
    }

    private String imprimirFibonacci(int numeroFibonacciAImprimir) {
        String cadanaAImprimir = "";
        if (this.vertical) {
            cadanaAImprimir = "\n" + numeroFibonacciAImprimir;
        } else {
            cadanaAImprimir = cadanaAImprimir + " " + numeroFibonacciAImprimir;
        }
        return cadanaAImprimir;
    }

    public void imprimeEnVertical(boolean imprimeVertical) {
        this.vertical = imprimeVertical;
    }

    public void ejecutarEnOrdenInverso(boolean unOrden) {
        this.ordenInverso = unOrden;
    }

    public boolean definirSalidaHorizontalOVertical(String parametros) {
        boolean procesoSalidaPorPantalla;
        if ((parametros.equals("-o=vi"))
                || (parametros.equals("-o=vd"))
                || (parametros.equals("-o=hi"))
                || (parametros.equals("-o=hd"))
                || (parametros.equals(""))) {
            imprimeEnVertical(parametros.contains("v"));
            ejecutarEnOrdenInverso(parametros.contains("i"));
            this.continuar = true;
            procesoSalidaPorPantalla = true;
        } else {
            System.out.println("Opciones no validas");
            this.numeroFibonacci = -1;
            this.continuar = false;
            procesoSalidaPorPantalla = false;
        }
        return procesoSalidaPorPantalla;
    }

    public static void main(String[] args) {
        int numeroFib = -1;
        String argumentoTipoImpresion = "";
        if (args.length == 1) {
            numeroFib = Integer.parseInt(args[0]);
        } else if (args.length > 1) {
            argumentoTipoImpresion = args[0];
            numeroFib = Integer.parseInt(args[1]);
        }

        Fibonacci miFibonacci = new Fibonacci(numeroFib);
        miFibonacci.definirSalidaHorizontalOVertical(argumentoTipoImpresion);
        miFibonacci.ejecutarFibonacci();
        miFibonacci.armarCabeceraDeSalida();
    }

}
