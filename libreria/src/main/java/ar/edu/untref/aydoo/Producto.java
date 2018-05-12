package ar.edu.untref.aydoo;

public class Producto {
    private Double precio;

    public Producto(final Double unPrecio) {
        this.precio = unPrecio;
    }

    public Double darPrecio() {
        return this.precio;
    }
}
