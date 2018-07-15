package ar.edu.untref.aydoo.AplicadoresDeImpuestos;

public class Aplicador20Porciento implements Aplicador {
    private static final Double VEINTEPORCIENTO = 0.20d;
    private Aplicador siguiente;

    @Override
    public void setNext(Aplicador unAplicador) {
        this.siguiente = unAplicador;
    }

    @Override
    public Aplicador getNext() {
        return this.siguiente;
    }

    public Double aplicar(Double monto, boolean esEmpresa) {
        Double resultado = 0d;
        if (esEmpresa && monto >= 500000d) {
            resultado = monto * VEINTEPORCIENTO;
        }
        return resultado;
    }
}
