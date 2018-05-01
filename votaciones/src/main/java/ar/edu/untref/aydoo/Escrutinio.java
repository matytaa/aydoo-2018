package ar.edu.untref.aydoo;

import java.util.LinkedList;

public class Escrutinio {

    private LinkedList<Voto> listaDeVotos;

    public Escrutinio(LinkedList<Voto> unaListaDeVotos) {
        this.listaDeVotos = unaListaDeVotos;
    }

    public int cantidadDeVotosEnProvinciaPorCantidato(Candidato unCandidato, String unaProvincia) {
        int votosTotales = 0;
        return votosTotales;
    }

    public int darCantidadDeVotos() {
        return listaDeVotos.size();
    }
}
