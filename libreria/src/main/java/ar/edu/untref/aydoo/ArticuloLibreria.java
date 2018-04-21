package ar.edu.untref.aydoo;

public class ArticuloLibreria extends Producto {
    private int iva;

    public ArticuloLibreria(final int unPrecio, final int unIva) {
        super(unPrecio);
        this.iva = unIva;
    }

    public int darIva() {
        return this.iva;
    }
}
