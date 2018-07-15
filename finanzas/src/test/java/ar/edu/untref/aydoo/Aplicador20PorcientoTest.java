package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.AplicadoresDeImpuestos.Aplicador20Porciento;
import org.junit.Assert;
import org.junit.Test;

public class Aplicador20PorcientoTest {

    @Test
    public void noDeberiaAplicar5PorcientoDeImpuestoParticular(){
        Aplicador20Porciento aplicador = new Aplicador20Porciento();
        Assert.assertEquals(0d, aplicador.aplicar(600000d,false),0.001);
    }

    @Test
    public void deberiaAplicar5PorcientoDeImpuestoEmpresa(){
        Aplicador20Porciento aplicador = new Aplicador20Porciento();
        Assert.assertEquals(120000d, aplicador.aplicar(600000d,true),0.001);
    }

    @Test
    public void noDeberiaAplicar5PorcientoDeImpuestoEmpresa(){
        Aplicador20Porciento aplicador = new Aplicador20Porciento();
        Assert.assertEquals(0d, aplicador.aplicar(400000d,true),0.001);
    }
}
