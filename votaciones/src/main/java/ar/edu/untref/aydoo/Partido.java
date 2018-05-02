package ar.edu.untref.aydoo;

public class Partido {
    private final String nombre;

    public Partido(String unNombre) {
        this.nombre = unNombre;
    }

    public String nombrePartido() {
        return this.nombre;
    }
}