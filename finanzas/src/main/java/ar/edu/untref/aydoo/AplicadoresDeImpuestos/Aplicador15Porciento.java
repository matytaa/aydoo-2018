package ar.edu.untref.aydoo.AplicadoresDeImpuestos;

public class Aplicador15Porciento implements Aplicador {

    private static final Double QUINCEPORCIENTO = 0.15d;
    private static final Double QUINIENTOSMIL = 500000d;
    private static final Double CIENMIL = 100000d;
    private Aplicador siguiente;

    @Override
    public void setNext(Aplicador aplicador20Porciento) {
        this.siguiente = aplicador20Porciento;
    }

    @Override
    public Double aplicar(Double monto, boolean esEmpresa) {
        if (esEmpresa && (CIENMIL <= monto && monto < QUINIENTOSMIL)) {
            return (monto * QUINCEPORCIENTO);
        }
        return this.siguiente.aplicar(monto, esEmpresa);
    }
}
