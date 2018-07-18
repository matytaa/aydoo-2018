package ar.edu.untref.aydoo.AplicadoresDeImpuestos;

public class Aplicador8Porciento implements Aplicador {

    private static final Double OCHOPORCIENTO = 0.08d;
    private static final Double QUINIENTOSMIL = 500000d;
    private static final Double CIENMIL = 100000d;
    private Aplicador siguiente;

    @Override
    public void setNext(Aplicador aplicador10Porciento) {
        this.siguiente = aplicador10Porciento;
    }

    @Override
    public Double aplicar(Double monto, boolean esEmpresa) {
        if (!esEmpresa && (CIENMIL <= monto && monto < QUINIENTOSMIL)) {
            return (monto * OCHOPORCIENTO);
        }
        return this.siguiente.aplicar(monto, esEmpresa);
    }
}
