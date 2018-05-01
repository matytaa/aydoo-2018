package ar.edu.untref.aydoo;

public class ProcesadorDeParametros {


    private boolean continuar;

    public void definirSalidaHorizontalOVertical(String parametros) {
        if ((parametros.equals("-o=vi"))
                || (parametros.equals("-o=vd"))
                || (parametros.equals("-o=hi"))
                || (parametros.equals("-o=hd"))
                || (parametros.equals(""))) {
            //imprimeEnVertical(parametros.contains("v"));
            //ejecutarEnOrdenInverso(parametros.contains("i"));
            continuarEjecucion(true);
        } else {
            cancelarEjecucion();
        }
    }

    private void cancelarEjecucion() {
        System.out.println("Opciones no validas");
        //this.numeroFibonacci = -1;
        continuarEjecucion(false);
    }

    private void continuarEjecucion(boolean unEstado) {
        this.continuar = unEstado;
    }

    public boolean puedoContinuar() {
        return this.continuar;
    }
}
