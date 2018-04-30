package ar.edu.untref.aydoo;

public class Fibonacci {
    private boolean vertical;
    private boolean ordenInverso;
    private int resultadoParcial = 0;
    private int numeroFibonacci = 0;
    private String cuerpoTxt = "";
    private String cabeceraTxt;
    private boolean continuar;
    private GenerardorDeArchivos miGenerador;
    private String archivoDeSalida;
    private boolean sumarValores;
    private boolean salidaPorPantalla;

    public Fibonacci(int unNumeroFibonacci) {
        this.numeroFibonacci = unNumeroFibonacci;
        armarCabeceraDeSalida();
        this.sumarValores = false;
        this.archivoDeSalida = "";
        this.salidaPorPantalla = true;
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

    public int ejecutarFibonacci() {
        if (esEjecucionInversa()) {
            return ejecutarFibonacciInverso();
        }
        if (puedoSumarVaroles()) {
            return ejecutarSumatoriaFibonacci();
        }
        return ejecutarFibonacciDirecto();
    }

    private int ejecutarSumatoriaFibonacci() {
        int resultadoFinal = 0;
        for (int i = 0; i < this.numeroFibonacci + 1; i++) {
            resultadoFinal += calcularFibonacci(i);
        }
        this.cuerpoTxt = "" + resultadoFinal;
        imprimirSalida();
        return resultadoFinal;
    }

    private boolean esEjecucionInversa() {
        return this.ordenInverso;
    }

    public int ejecutarFibonacciDirecto() {
        for (int i = 0; i < this.numeroFibonacci + 1; i++) {
            this.cuerpoTxt = this.cuerpoTxt
                    + imprimirFibonacci(calcularFibonacci(i));
        }
        imprimirSalida();
        return this.resultadoParcial;
    }

    public void imprimirSalida() {
        if (this.continuar) {
            String resultado = armarSalida();
            if (this.salidaPorPantalla) {
                System.out.println(resultado);
            } else {
                generarArchivo(this.archivoDeSalida);
                escribirResultado(resultado);
            }
        }
    }

    private String armarSalida() {
        String resultado = this.cabeceraTxt;
        if (this.puedoSumarVaroles()) {
            resultado = resultado + "s";
        }
        resultado = resultado + ":" + this.cuerpoTxt;
        return resultado;
    }

    public int ejecutarFibonacciInverso() {
        for (int i = this.numeroFibonacci; i >= 0; i--) {
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

    public void definirSalidaHorizontalOVertical(String parametros) {
        if ((parametros.equals("-o=vi"))
                || (parametros.equals("-o=vd"))
                || (parametros.equals("-o=hi"))
                || (parametros.equals("-o=hd"))
                || (parametros.equals(""))) {
            imprimeEnVertical(parametros.contains("v"));
            ejecutarEnOrdenInverso(parametros.contains("i"));
            continuarEjecucion(true);
        } else {
            cancelarEjecucion();
        }
    }

    private void cancelarEjecucion() {
        System.out.println("Opciones no validas");
        this.numeroFibonacci = -1;
        continuarEjecucion(false);
    }

    public boolean puedoContinuar() {
        return this.continuar;
    }

    private void continuarEjecucion(boolean unEstado) {
        this.continuar = unEstado;
    }

    public boolean generarArchivo(String rutaArchivo) {
        this.miGenerador = new GenerardorDeArchivos(rutaArchivo);
        return this.miGenerador.generarArchivo();
    }

    public void escribirResultado(String resultadoEjecucion) {
        this.miGenerador.escribirArchivo(resultadoEjecucion);
    }

    public boolean puedoSumarVaroles() {
        return this.sumarValores;
    }

    public void aplicarSumaDeValores(boolean unEstado) {
        this.sumarValores = unEstado;
    }

    public void definirSalidaListaOSumatoria(String parametro) {
        if ((parametro.equals("-m=s"))
                || (parametro.equals("-m=l"))
                || (parametro.equals(""))) {
            aplicarSumaDeValores(parametro.contains("s"));
            continuarEjecucion(true);
        } else {
            cancelarEjecucion();
        }
    }

    public void definirArchivoDeSalida(String paramatroSalidaArchivo) {
        boolean aplicaSalidaPorArchivo = paramatroSalidaArchivo.contains("-f=");
        if (aplicaSalidaPorArchivo) {
            this.archivoDeSalida = paramatroSalidaArchivo.substring(3, paramatroSalidaArchivo.length());
            continuarEjecucion(true);
            this.salidaPorPantalla = false;
        } else {
            cancelarEjecucion();
        }
    }

    public static void main(String[] args) {
        int numeroFib = -1;
        String argumentoTipoImpresion = "";
        int cantidadDeArgumentos = args.length;

        switch (cantidadDeArgumentos) {
            case 1:
                numeroFib = Integer.parseInt(args[0]);
                break;
            case 2:
                argumentoTipoImpresion = args[0];
                numeroFib = Integer.parseInt(args[1]);
                break;
            default:
                break;
        }
        /*
        if (args.length == 1) {
            numeroFib = Integer.parseInt(args[0]);
        } else if (args.length > 1) {
            argumentoTipoImpresion = args[0];
            numeroFib = Integer.parseInt(args[1]);
        }*/

        Fibonacci miFibonacci = new Fibonacci(numeroFib);
        miFibonacci.definirSalidaHorizontalOVertical(argumentoTipoImpresion);
        miFibonacci.ejecutarFibonacci();
        miFibonacci.armarCabeceraDeSalida();
    }
}
