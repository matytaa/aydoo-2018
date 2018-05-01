package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CandidatoTest {
    @Test
    public void deberiaRetornarElNombreDelCandidato() {
        String nombre = "Goku";
        String partido = "Estilo Tortuga";
        Candidato unCandidato = new Candidato(nombre,partido);
        Assert.assertEquals(nombre, unCandidato.darNombreDelCandidato());
    }

    @Test
    public void deberiaRetornarElPartidoDelCandidato() {
        String nombre = "Goku";
        String partido = "Estilo Tortuga";
        Candidato unCandidato = new Candidato(nombre,partido);
        Assert.assertEquals(partido, unCandidato.darPartidoDelCandidato());
    }
}
