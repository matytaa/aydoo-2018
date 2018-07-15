package ar.edu.untref.aydoo;

public class Aplicador5Porciento  implements Aplicador{
    private static final Double CINCOPORCIENTO = 0.05d;
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
        if ((!esEmpresa && (50000d <= monto && monto < 100000d))
                || (esEmpresa && (20000d <= monto && monto < 50000d))) {
            return (monto * CINCOPORCIENTO);
        }

        return this.siguiente.aplicar(monto,esEmpresa);
    }
}
