package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CandidatoTest {
    @Test
    public void deberiaRetornarElNombreDelCandidato() {
        String nombre = "Goku";
        Partido estiloTortuga = new Partido("Estilo tortuga");
        Candidato unCandidato = new Candidato(nombre,estiloTortuga);
        Assert.assertEquals(nombre, unCandidato.darNombreDelCandidato());
    }

    @Test
    public void deberiaRetornarElPartidoDelCandidato() {
        String nombre = "Goku";
        Partido estiloTortuga = new Partido("Estilo tortuga");
        Candidato unCandidato = new Candidato(nombre,estiloTortuga);
        Assert.assertEquals(estiloTortuga, unCandidato.darPartidoDelCandidato());
    }
}
