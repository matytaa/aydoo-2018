package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class EscrutinioTest {

    Escrutinio miEscrutinio;
    Candidato candidato1;
    Candidato candidato2;
    Candidato candidato3;
    Candidato candidato4;
    Candidato candidato5;
    Candidato candidato6;


    Voto votoCandidato1;
    Voto votoCandidato2;
    Voto votoCandidato3;
    Voto votoCandidato4;
    Voto votoCandidato5;
    Voto votoCandidato6;
    Voto votoCandidato7;
    Voto votoCandidato8;

    @Before
    public void setUp() {
        miEscrutinio = new Escrutinio(null);

        candidato1 = new Candidato("Goku", "Estilo tortuga");
        candidato2 = new Candidato("Milk", "Estilo tortuga");
        candidato3 = new Candidato("Goten", "Estilo tortuga");
        candidato4 = new Candidato("Trunks", "Pikoro Academi");
        candidato5 = new Candidato("Gohan", "Pikoro Academi");
        candidato6 = new Candidato("Krilin", "Estilo tortuga");

        votoCandidato1 = new Voto(candidato1, "Mendoza");
        votoCandidato2 = new Voto(candidato2, "Chubut");
        votoCandidato3 = new Voto(candidato3, "Cordoba");
        votoCandidato4 = new Voto(candidato4, "Corrientes");
        votoCandidato5 = new Voto(candidato5, "Misiones");
        votoCandidato6 = new Voto(candidato6, "Santa Cruz");
        votoCandidato7 = new Voto(candidato1, "Santa Cruz");
        votoCandidato8 = new Voto(candidato1, "Santa Cruz");
    }

    @Test
    public void deberiaDarCeroLaCantidadDeVotos() {
        Candidato unCandidato = new Candidato("Goku", "Estilo tortuga");
        String unaProvincia = "Mendoza";
        int resultado = miEscrutinio.cantidadDeVotosEnProvinciaPorCantidato(unCandidato, unaProvincia);
        Assert.assertEquals(0, resultado);
    }

    @Test
    public void deberiaDarUnaCantidadDe3Votos() {
        LinkedList<Voto> listaDeVotos = new LinkedList<Voto>();
        miEscrutinio = new Escrutinio(listaDeVotos);
        miEscrutinio.agregarVoto(votoCandidato1);
        miEscrutinio.agregarVoto(votoCandidato2);
        miEscrutinio.agregarVoto(votoCandidato3);
        Assert.assertEquals(3, miEscrutinio.darCantidadDeVotos());
    }

    @Test
    public void deberiaComputar6VotosParaEstiloTortuga() {
        LinkedList<Voto> listaDeVotos = new LinkedList<Voto>();
        miEscrutinio = new Escrutinio(listaDeVotos);
        miEscrutinio.agregarVoto(votoCandidato1);
        miEscrutinio.agregarVoto(votoCandidato2);
        miEscrutinio.agregarVoto(votoCandidato3);
        miEscrutinio.agregarVoto(votoCandidato4);
        miEscrutinio.agregarVoto(votoCandidato5);
        miEscrutinio.agregarVoto(votoCandidato6);
        miEscrutinio.agregarVoto(votoCandidato7);
        miEscrutinio.agregarVoto(votoCandidato8);

        Assert.assertEquals(6, miEscrutinio.cantidadDeVotosPorPartido("Estilo tortuga"));
    }
}
