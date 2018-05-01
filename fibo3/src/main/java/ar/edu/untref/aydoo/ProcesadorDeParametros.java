package ar.edu.untref.aydoo;

public class ProcesadorDeParametros {


    private boolean continuar;
    private boolean vertical;
    private boolean ordenInverso;

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

    public void imprimeEnVertical(boolean imprimeVertical) {
        this.vertical = imprimeVertical;
    }

    public void ejecutarEnOrdenInverso(boolean unOrden) {
        this.ordenInverso = unOrden;
    }

    private void cancelarEjecucion() {
        System.out.println("Opciones no validas");
        //this.numeroFibonacci = -1;
        continuarEjecucion(false);
    }

    private void continuarEjecucion(boolean unEstado) {
        this.continuar = unEstado;
    }

    public boolean esEjecucionInversa() {
        return this.ordenInverso;
    }

    public boolean puedoContinuar() {
        return this.continuar;
    }

    public boolean imprimirEnVertical() {
        return this.vertical;
    }
}
