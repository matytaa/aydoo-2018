package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Escrutador {

    private List<Voto> listaDeVotos;
    private List<Partido> listaDePartidos;
    private List<Provincia> listaDeProvincias;
    private ValidadorDeVoto miValidadorDeVotos;
    private List<Candidato> listaDeCandidatos;

    public Escrutador(List<Voto> unaListaDeVotos) {
        this.listaDeVotos = unaListaDeVotos;
        this.listaDePartidos = new LinkedList<Partido>();
        this.listaDeProvincias = new LinkedList<Provincia>();
        this.listaDeCandidatos = new LinkedList<Candidato>();
        this.miValidadorDeVotos = new ValidadorDeVoto();
    }

    public int darCantidadDeVotos() {
        return listaDeVotos.size();
    }

    public int cantidadDeVotosEnProvinciaPorCantidato
            (Candidato unCandidato, Provincia unaProvincia) {
        int votosTotales = 0;
        Iterator<Voto> itVotos = this.listaDeVotos.iterator();
        while (itVotos.hasNext()) {
            Voto unVoto = itVotos.next();
            if (unaProvincia.
                    equals(unVoto.darProvincia())
                    && unCandidato.
                    equals(unVoto.darCandidato())) {
                votosTotales++;
            }
        }
        return votosTotales;
    }

    public Candidato candidatoConMasVotosEnUnaProvincia(Provincia unaProvincia) {
        validarVotos();
        Candidato unCandidato = null;
        List<Voto> votosDeLaProvincia;
        votosDeLaProvincia = obtenerVotosDeLaProvincia(unaProvincia);
        int cantidadDeVotos = 0;

        Iterator<Voto> itVotos = votosDeLaProvincia.iterator();
        while (itVotos.hasNext()) {
            Voto unVoto = itVotos.next();
            int resultado = cantidadDeVotosEnProvinciaPorCantidato
                    (unVoto.darCandidato(), unaProvincia);
            if (resultado > cantidadDeVotos) {
                unCandidato = unVoto.darCandidato();
            }
        }


        return unCandidato;
    }

    public int cantidadDeVotosPorPartido(String unPartido) {
        Iterator<Voto> itVotos = this.listaDeVotos.iterator();
        int contador = 0;
        while (itVotos.hasNext()) {
            if (unPartido.equals(
                    itVotos.next().
                            darCandidato().
                            darPartidoDelCandidato().
                            nombrePartido())) {
                contador++;
            }
        }
        return contador;
    }

    public Partido partidoConMasVotos() {
        int cantidadDeVotos = 0;
        Partido mejorPartido = null;
        validarVotos();
        Iterator<Partido> itPartidos = this.listaDePartidos.iterator();
        while (itPartidos.hasNext()) {
            Partido unPartido = itPartidos.next();
            int resultadoParcial =
                    cantidadDeVotosPorPartido
                            (unPartido.nombrePartido());
            if (resultadoParcial > cantidadDeVotos) {
                cantidadDeVotos = resultadoParcial;
                mejorPartido = unPartido;
            }
        }
        return mejorPartido;

    }

    private void validarVotos() {
        this.miValidadorDeVotos.validarVotosPorProvincia(this.listaDeVotos, this.listaDeProvincias);
        this.miValidadorDeVotos.validarVotosPorCandidato(this.listaDeVotos, this.listaDeCandidatos);
    }

    public void agregarListaDePartidos(List<Partido> unaListaDePartidos) {
        this.listaDePartidos = unaListaDePartidos;
    }

    public void agregarListaDeProvincias(List<Provincia> unaListaDeProvincias) {
        this.listaDeProvincias = unaListaDeProvincias;
    }

    private List<Voto> obtenerVotosDeLaProvincia(Provincia unaProvincia) {
        List<Voto> listaDeVotosARetornar = new LinkedList<Voto>();
        Iterator<Voto> itVotos = this.listaDeVotos.iterator();
        while (itVotos.hasNext()) {
            Voto unVoto = itVotos.next();
            if (unaProvincia.equals(unVoto.darProvincia())) {
                listaDeVotosARetornar.add(unVoto);
            }
        }
        return listaDeVotosARetornar;
    }

    public void agregarListaDeCandidatos(List<Candidato> unaListaDeCandidatos) {
        this.listaDeCandidatos = unaListaDeCandidatos;
    }
}
