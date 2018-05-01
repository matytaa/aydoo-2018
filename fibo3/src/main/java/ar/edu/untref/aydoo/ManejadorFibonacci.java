package ar.edu.untref.aydoo;

public class ManejadorFibonacci {
    private final ProcesadorDeParametros miProcesador;
    private Fibonacci miFibonacci;

    public ManejadorFibonacci(ProcesadorDeParametros unProcesador, Fibonacci unFibonacci) {
        this.miProcesador = unProcesador;
        this.miFibonacci = unFibonacci;
    }

    public void procesarArgumentos(String unArgumento) {
        this.miProcesador.definirSalidaListaOSumatoria(unArgumento);
    }

    public ProcesadorDeParametros darProcesadorDeParemetros(){
        return this.miProcesador;
    }

    public int ejecutarFibonnaci(int unNumeroFibonacci) {
        inicializarFibonacci(unNumeroFibonacci);
        return miFibonacci.ejecutarFibonacci();
    }

    private void inicializarFibonacci(int unNumeroFibonacci) {
        this.miFibonacci = new Fibonacci(unNumeroFibonacci);
    }
}
