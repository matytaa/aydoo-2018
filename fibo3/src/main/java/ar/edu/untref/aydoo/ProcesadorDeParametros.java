package ar.edu.untref.aydoo;

public class ProcesadorDeParametros {


    private boolean continuar;
    private boolean vertical;
    private boolean ordenInverso;
    private boolean sumarValores;

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
}
