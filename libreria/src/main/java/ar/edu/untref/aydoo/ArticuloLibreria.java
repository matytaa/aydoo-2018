package ar.edu.untref.aydoo;

public class ArticuloLibreria extends Producto {
    private int iva;
    private final Double DENOMINADOR = 100.0;

    public ArticuloLibreria(final Double unPrecio, final int unIva) {
        super(unPrecio);
        this.iva = unIva;
    }

    public int darIva() {
        return this.iva;
    }

    public Double darPrecio() {
        Double unPrecio = super.darPrecio();
        Double unIva = (1.0 + this.iva / this.DENOMINADOR);
        return unPrecio * unIva;
    }
}
