package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class VotoTest {
    @Test
    public void deberiaRetornarElCandidatoDelVoto(){
        String nombre = "Goku";
        Partido estiloTortuga = new Partido("Estilo tortuga");
        Candidato unCandidato = new Candidato(nombre,estiloTortuga);
        Provincia unaProvincia = new Provincia("Mendoza");
        Voto unVoto = new Voto(unCandidato,unaProvincia);
        Assert.assertEquals(unCandidato, unVoto.darCandidato());
    }

    @Test
    public void deberiaRetornarLaProvincia(){
        String nombre = "Goku";
        Partido estiloTortuga = new Partido("Estilo tortuga");
        Candidato unCandidato = new Candidato(nombre,estiloTortuga);
        Provincia unaProvincia = new Provincia("Mendoza");
        Voto unVoto = new Voto(unCandidato,unaProvincia);
        Assert.assertEquals(unaProvincia, unVoto.darProvincia());
    }
}
