package ar.edu.untref.aydoo;

import java.util.List;
import java.util.LinkedList;

public class Cliente {
    private List<Suscripcion> listaDeSuscripciones;
    private String direccion;
    private String nombre;

    public Cliente(final String unNombre, final String unaDireccion) {
        this.nombre = unNombre;
        this.direccion = unaDireccion;
        this.listaDeSuscripciones = new LinkedList<>();
    }

    public String darNombre() {
        return this.nombre;
    }

    public String darDireccion() {
        return this.direccion;
    }

    public void comprarSuscripcion(final Suscripcion unaSuscripcion) {
        this.listaDeSuscripciones.add(unaSuscripcion);
    }

    public boolean tieneSuscripciones() {
        return this.listaDeSuscripciones.size() > 0;
    }

    public List<Suscripcion> darSuscripciones() {
        return this.listaDeSuscripciones;
    }
}
