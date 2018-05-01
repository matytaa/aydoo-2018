package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class EscrutinioTest {

    Escrutinio miEscrutinio;
    @Before
    public void setUp(){
        miEscrutinio = new Escrutinio(null);
    }

    @Test
    public void deberiaDarCeroLaCantidadDeVotos() {
        Candidato unCandidato = new Candidato("Goku","Estilo tortuga");
        String unaProvincia = "Mendoza";
        int resultado = miEscrutinio.cantidadDeVotosEnProvinciaPorCantidato(unCandidato, unaProvincia);
        Assert.assertEquals(0,resultado);
    }

    @Test
    public void asdasd(){
        LinkedList<Voto> listaDeVotos = new LinkedList<Voto>();
        miEscrutinio = new Escrutinio(listaDeVotos);
        Assert.assertEquals(0, miEscrutinio.darCantidadDeVotos());
    }
}
