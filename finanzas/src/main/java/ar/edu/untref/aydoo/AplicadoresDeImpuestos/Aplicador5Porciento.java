package ar.edu.untref.aydoo.AplicadoresDeImpuestos;

public class Aplicador5Porciento implements Aplicador {
    private static final Double CINCOPORCIENTO = 0.05d;
    private static final Double CINCUENTAMIL = 50000d;
    private static final Double VEINTEMIL = 20000d;
    private static final Double CIENMIL = 100000d;
    private Aplicador siguiente;

    @Override
    public void setNext(Aplicador aplicador8Porciento) {
        this.siguiente = aplicador8Porciento;
    }

    @Override
    public Aplicador getNext() {
        return this.siguiente;
    }

    public Double aplicar(Double monto, boolean esEmpresa) {
        if ((!esEmpresa && (CINCUENTAMIL <= monto && monto < CIENMIL))
                || (esEmpresa && (VEINTEMIL <= monto && monto < CINCUENTAMIL))) {
            return (monto * CINCOPORCIENTO);
        }

        return this.siguiente.aplicar(monto, esEmpresa);
    }
}
