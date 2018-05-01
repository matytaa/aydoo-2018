package ar.edu.untref.aydoo;

public class Voto {
    private final String unaProvincia;
    private final Candidato unCandidato;

    public Voto(Candidato unCandidato, String unaProvincia) {
        this.unCandidato = unCandidato;
        this.unaProvincia = unaProvincia;
    }

    public Candidato darCandidato() {
        return this.unCandidato;
    }

    public String darProvincia() {
        return this.unaProvincia;
    }
}
