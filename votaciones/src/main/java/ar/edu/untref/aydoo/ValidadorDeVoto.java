package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.List;

public class ValidadorDeVoto {
    public void validarVotosPorProvincia(List<Voto> listaDeVotos, List<Provincia> listaDeProvincias) {
        Iterator<Voto> itVotos = listaDeVotos.iterator();
        while (itVotos.hasNext()) {
            if (!existeProvincia(itVotos.
                    next().
                    darProvincia(), listaDeProvincias)) {
                itVotos.remove();
            }
        }
    }

    private boolean existeProvincia(Provincia unaProvincia, List<Provincia> listaDeProvincias) {
        return listaDeProvincias.contains(unaProvincia);
    }

    public void validarVotosPorCandidato(List<Voto> listaDeVotos, List<Candidato> listaDeCandidatos) {
        Iterator<Voto> itVotos = listaDeVotos.iterator();
        while (itVotos.hasNext()) {
            if (!existeCandidato(itVotos.
                    next().
                    darCandidato(), listaDeCandidatos)) {
                itVotos.remove();
            }
        }
    }

    private boolean existeCandidato(Candidato unCandidato, List<Candidato> listaDeCandidatos) {
        return listaDeCandidatos.contains(unCandidato);
    }
}
