package ar.edu.untref.aydoo.AplicadoresDeImpuestos;

public class Aplicador20Porciento implements Aplicador {

    private static final Double VEINTEPORCIENTO = 0.20d;
    private static final Double QUINIENTOSMIL = 500000d;
    private Aplicador siguiente;

    @Override
    public void setNext(Aplicador unAplicador) {
        this.siguiente = unAplicador;
    }

    @Override
    public Double aplicar(Double monto, boolean esEmpresa) {
        Double resultado = 0d;
        if (esEmpresa && monto >= QUINIENTOSMIL) {
            resultado = monto * VEINTEPORCIENTO;
        }
        return resultado;
    }
}
