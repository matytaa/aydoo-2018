package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;


public class GabadorDeFinanzasTest
{
    @Test
    public void deberiaDevolverElMismoMontoEnviadoYaQueNoAplicaImpuesto()
    {
        GabadorDeFinanzas gabadorDeFinanzas = new GabadorDeFinanzas();
        Double result = gabadorDeFinanzas.grabarImpuestos(10d);
        Assert.assertEquals(10d, result,0.001);
    }
}
