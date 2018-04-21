package ar.edu.untref.aydoo;

public class Producto {
    private int precio;

    public Producto(final int unPrecio) {
        this.precio = unPrecio;
    }

    public int darPrecio() {
        return this.precio;
    }
}
