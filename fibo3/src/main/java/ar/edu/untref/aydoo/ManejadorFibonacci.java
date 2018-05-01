package ar.edu.untref.aydoo;

public class ManejadorFibonacci {
    private final ProcesadorDeParametros miProcesador;

    public ManejadorFibonacci(ProcesadorDeParametros unProcesador) {
        this.miProcesador = unProcesador;
    }

    public void procesarArgumentos(String unArgumento) {
        this.miProcesador.definirSalidaListaOSumatoria(unArgumento);
    }

    public ProcesadorDeParametros darProcesadorDeParemetros(){
        return this.miProcesador;
    }
}
