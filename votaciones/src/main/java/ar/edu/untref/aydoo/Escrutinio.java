package ar.edu.untref.aydoo;

import java.util.Iterator;
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

    public void agregarVoto(Voto unVoto) {
        this.listaDeVotos.add(unVoto);
    }

    public int cantidadDeVotosPorPartido(String unPartido) {
        Iterator<Voto> itVotos = this.listaDeVotos.iterator();
        int contador = 0;
        while (itVotos.hasNext()) {
            if (unPartido.equals(
                    itVotos.next().
                            darCandidato().
                            darPartidoDelCandidato())) {
                contador++;
            }
        }
        return contador;
    }
}
