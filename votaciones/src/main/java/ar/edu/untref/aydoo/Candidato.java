package ar.edu.untref.aydoo;

public class Candidato {
    private final String nombre;
    private final Partido partido;

    public Candidato(String unNombre, Partido unPartido) {
        this.nombre = unNombre;
        this.partido = unPartido;
    }

    public String darNombreDelCandidato() {
        return this.nombre;
    }

    public Partido darPartidoDelCandidato() {
        return this.partido;
    }
}
