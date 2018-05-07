package ar.edu.untref.aydoo;

public class ProcesadorDeParametros {

    private boolean continuar;
    private boolean vertical;
    private boolean ordenInverso;
    private boolean sumarValores;
    private String archivoDeSalida;
    private boolean salidaPorPantalla;
    private boolean eureka;

    public ProcesadorDeParametros(){
        this.continuar = true;
        this.salidaPorPantalla = true;
    }

    public void recibirParametros(String unArgumento){
        this.eureka = false;
        if(puedoContinuar()) {
            definirSalidaListaOSumatoria(unArgumento);
            if (!this.eureka) {
                definirSalidaHorizontalOVertical(unArgumento);
            }
            if (!this.eureka) {
                definirArchivoDeSalida(unArgumento);
            }

            if (!this.eureka) {
                cancelarEjecucion();
            }
        }
    }

   private void definirSalidaHorizontalOVertical(String parametros) {
        if ((parametros.equals("-o=vi"))
                || (parametros.equals("-o=vd"))
                || (parametros.equals("-o=hi"))
                || (parametros.equals("-o=hd"))
                || (parametros.equals(""))) {
            imprimeEnVertical(parametros.contains("v"));
            ejecutarEnOrdenInverso(parametros.contains("i"));
            encontroParametros(true);
        }
    }

    private void imprimeEnVertical(boolean imprimeVertical) {
        this.vertical = imprimeVertical;
    }

    private void ejecutarEnOrdenInverso(boolean unOrden) {
        this.ordenInverso = unOrden;
    }

    private void cancelarEjecucion() {
        System.out.println("Opciones no validas");
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

    private void aplicarSumaDeValores(boolean unEstado) {
        this.sumarValores = unEstado;
    }

    private void definirSalidaListaOSumatoria(String parametro) {
        if ((parametro.equals("-m=s"))
                || (parametro.equals("-m=l"))
                || (parametro.equals(""))) {
            aplicarSumaDeValores(parametro.contains("s"));
            encontroParametros(true);
        }
    }

    private void encontroParametros(boolean eureka) {
        this.eureka = eureka;
    }

    private void definirArchivoDeSalida(String paramatroSalidaArchivo) {
        boolean aplicaSalidaPorArchivo = paramatroSalidaArchivo.contains("-f=");
        if (aplicaSalidaPorArchivo) {
            this.archivoDeSalida = paramatroSalidaArchivo.substring(3, paramatroSalidaArchivo.length());
            encontroParametros(true);
            this.salidaPorPantalla = false;
        }
    }

    public boolean imprimeEnPantalla(){
        return this.salidaPorPantalla;
    }

    public String darArchivoDeSalida(){
        return this.archivoDeSalida;
    }
}
