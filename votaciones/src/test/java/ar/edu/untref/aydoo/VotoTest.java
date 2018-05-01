package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class VotoTest {
    @Test
    public void deberiaRetornarElCandidatoDelVoto(){
        Candidato unCandidato = new Candidato("Goku","Estilo tortuga");
        String unaProvincia = "Mendoza";
        Voto unVoto = new Voto(unCandidato,unaProvincia);
        Assert.assertEquals(unCandidato, unVoto.darCandidato());
    }

    @Test
    public void deberiaRetornarLaProvincia(){
        Candidato unCandidato = new Candidato("Goku","Estilo tortuga");
        String unaProvincia = "Mendoza";
        Voto unVoto = new Voto(unCandidato,unaProvincia);
        Assert.assertEquals(unCandidato, unVoto.darProvincia());
    }
}
