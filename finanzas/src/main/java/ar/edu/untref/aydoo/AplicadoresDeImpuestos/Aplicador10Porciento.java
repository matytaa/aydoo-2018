package ar.edu.untref.aydoo.AplicadoresDeImpuestos;

public class Aplicador10Porciento implements Aplicador{
    private static final Double DIEZPORCIENTO = 0.10d;
    private Aplicador siguiente;

    @Override
    public void setNext(Aplicador aplicador15Porciento) {
        this.siguiente = aplicador15Porciento;
    }

    @Override
    public Aplicador getNext() {
        return this.siguiente;
    }

    public Double aplicar(Double monto, boolean esEmpresa) {
        if ((!esEmpresa && (500000d <= monto))
                || (esEmpresa && (50000d <= monto && monto < 100000d))) {
            return (monto * DIEZPORCIENTO);
        }
        return this.siguiente.aplicar(monto,esEmpresa);
    }
}
