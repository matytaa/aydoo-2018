package ar.edu.untref.aydoo.AplicadoresDeImpuestos;

public class Aplicador10Porciento implements Aplicador {

    private static final Double DIEZPORCIENTO = 0.10d;
    private static final Double CINCUENTAMIL = 50000d;
    private static final Double QUINIENTOSMIL = 500000d;
    private static final Double CIENMIL = 100000d;
    private Aplicador siguiente;

    @Override
    public void setNext(Aplicador aplicador15Porciento) {
        this.siguiente = aplicador15Porciento;
    }

    @Override
    public Double aplicar(Double monto, boolean esEmpresa) {
        if ((!esEmpresa && (QUINIENTOSMIL <= monto))
                || (esEmpresa && (CINCUENTAMIL <= monto && monto < CIENMIL))) {
            return (monto * DIEZPORCIENTO);
        }
        return this.siguiente.aplicar(monto, esEmpresa);
    }
}
