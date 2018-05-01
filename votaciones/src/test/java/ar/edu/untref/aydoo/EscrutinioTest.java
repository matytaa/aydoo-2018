package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class EscrutinioTest {
    @Test
    public void asd() {
        Escrutinio miEscrutinio = new Escrutinio();
        Candidato unCandidato = new Candidato("Goku","Estilo tortuga");
        String unaProvincia = "Mendoza";
        int resultado = miEscrutinio.cantidadDeVotosEnProvinciaPorCantidato(unCandidato, unaProvincia);
        Assert.assertEquals(0,resultado);
    }
}
