package ar.edu.untref.aydoo;

public class Aplicador8Porciento  implements Aplicador{
    private static final Double OCHOPORCIENTO = 0.08d;
    private Aplicador siguiente;

    @Override
    public void setNext(Aplicador aplicador10Porciento) {
        this.siguiente = aplicador10Porciento;
    }

    @Override
    public Aplicador getNext() {
        return this.siguiente;
    }

    public Double aplicar(Double monto, boolean esEmpresa) {
        if (!esEmpresa && (100000d <= monto && monto < 500000d)) {
            return (monto *  OCHOPORCIENTO);
        }
        return this.siguiente.aplicar(monto,esEmpresa);
    }
}
