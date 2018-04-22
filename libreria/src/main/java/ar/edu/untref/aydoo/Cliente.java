package ar.edu.untref.aydoo;

public class Cliente {
    private String direccion;
    private String nombre;

    public Cliente(final String unNombre, final String unaDireccion) {
        this.nombre = unNombre;
        this.direccion = unaDireccion;
    }

    public String darNombre() {
        return this.nombre;
    }

    public String darDireccion() {
        return this.direccion;
    }
}
