package ar.edu.untref.aydoo;

public class Voto {
    private final Provincia unaProvincia;
    private final Candidato unCandidato;

    public Voto(Candidato unCandidato, Provincia unaProvincia) {
        this.unCandidato = unCandidato;
        this.unaProvincia = unaProvincia;
    }

    public Candidato darCandidato() {
        return this.unCandidato;
    }

    public Provincia darProvincia() {
        return this.unaProvincia;
    }
}
