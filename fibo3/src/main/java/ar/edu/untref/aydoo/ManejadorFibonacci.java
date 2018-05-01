package ar.edu.untref.aydoo;

public class ManejadorFibonacci {
    private final ProcesadorDeParametros miProcesador;
    private Fibonacci miFibonacci;
    private String cuerpoTxt;
    private String cabeceraTxt;
    private GenerardorDeArchivos miGenerador;

    public ManejadorFibonacci(ProcesadorDeParametros unProcesador, Fibonacci unFibonacci) {
        this.miProcesador = unProcesador;
        this.miFibonacci = unFibonacci;
        this.cuerpoTxt = "";
        this.cabeceraTxt = "";
    }

    public void procesarArgumentos(String unArgumento) {
        this.miProcesador.recibirParametros(unArgumento);
    }

    public ProcesadorDeParametros darProcesadorDeParemetros() {
        return this.miProcesador;
    }

    public int ejecutarFibonnaci(int unNumeroFibonacci) {
        inicializarFibonacci(unNumeroFibonacci);
        if (this.miProcesador.esEjecucionInversa()) {
            return this.miFibonacci.ejecutarFibonacciInverso();
        }
        if (this.miProcesador.puedoSumarVaroles()) {
            return this.miFibonacci.ejecutarSumatoriaFibonacci();
        }
        return this.miFibonacci.ejecutarFibonacciDirecto();
    }

    private void inicializarFibonacci(int unNumeroFibonacci) {
        if (miProcesador.puedoContinuar()){
            this.miFibonacci = new Fibonacci(unNumeroFibonacci);
            armarCabeceraDeSalida(unNumeroFibonacci);
        }
    }

    public void imprimirFibonacci(int numeroFibonacciAImprimir) {
        if (miProcesador.imprimirEnVertical()) {
            this.cuerpoTxt = this.cuerpoTxt + "\n" + numeroFibonacciAImprimir;
        } else {
            this.cuerpoTxt = this.cuerpoTxt + " " + numeroFibonacciAImprimir;
        }
    }

    private void armarCabeceraDeSalida(int unNumeroFibonacci) {
        this.cabeceraTxt = "fibo<" + unNumeroFibonacci + ">";
    }

    public String darCuerpoDelFibonacci() {
        return this.cuerpoTxt;
    }

    public void imprimirSalida() {
        if (this.miProcesador.puedoContinuar()) {
            String resultado = armarSalida();
            if (this.miProcesador.imprimeEnPantalla()) {
                System.out.println(resultado);
            } else {
                generarArchivo(this.miProcesador.darArchivoDeSalida());
                escribirResultado(resultado);
            }
        }
    }

    private String armarSalida() {
        String resultado = this.cabeceraTxt;
        if (this.miProcesador.puedoSumarVaroles()) {
            resultado = resultado + "s";
        }
        resultado = resultado + ":";
        armarCuerpo();
        resultado = resultado + darCuerpoDelFibonacci();
        return resultado;
    }

    private void armarCuerpo() {
        for (int i = 0; i < this.miFibonacci.darListaDeValores().size(); i++) {
            imprimirFibonacci(this.miFibonacci.darListaDeValores().get(i));
        }
    }

    public boolean generarArchivo(String rutaArchivo) {
        this.miGenerador = new GenerardorDeArchivos(rutaArchivo);
        return this.miGenerador.generarArchivo();
    }

    public void escribirResultado(String resultadoEjecucion) {
        this.miGenerador.escribirArchivo(resultadoEjecucion);
    }
}
