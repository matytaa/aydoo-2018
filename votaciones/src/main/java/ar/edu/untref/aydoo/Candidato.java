package ar.edu.untref.aydoo;

public class Candidato {
    private final String nombre;
    private final String partido;

    public Candidato(String unNombre, String unPartido) {
        this.nombre = unNombre;
        this.partido = unPartido;
    }

    public String darNombreDelCandidato() {
        return this.nombre;
    }

    public String darPartidoDelCandidato() {
        return this.partido;
    }
}
