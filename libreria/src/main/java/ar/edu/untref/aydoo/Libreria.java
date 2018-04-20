package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Libreria {
    private List<Libro> misLibros = new LinkedList<Libro>();

    public int cantidadDeProductos() {
        return 0;
    }

    public void AgregarProducto(Libro unLibro) {
        this.misLibros.add(unLibro);
    }

    public int cantidadDeLibros() {
        return misLibros.size();
    }
}
