package ar.edu.untref.aydoo;

public class Aplicador15Porciento implements Aplicador{
    private static final Double QUINCEPORCIENTO = 0.15d;
    private Aplicador siguiente;

    @Override
    public void setNext(Aplicador aplicador20Porciento) {
        this.siguiente = aplicador20Porciento;
    }

    @Override
    public Aplicador getNext() {
        return this.siguiente;
    }

    public Double aplicar(Double monto, boolean esEmpresa) {
        if (esEmpresa && (100000d <= monto && monto < 500000d)) {
            return (monto * QUINCEPORCIENTO);
        }
        return this.siguiente.aplicar(monto,esEmpresa);
    }
}
