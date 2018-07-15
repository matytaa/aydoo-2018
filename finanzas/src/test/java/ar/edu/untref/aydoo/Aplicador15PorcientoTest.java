package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.AplicadoresDeImpuestos.Aplicador15Porciento;
import ar.edu.untref.aydoo.AplicadoresDeImpuestos.Aplicador20Porciento;
import org.junit.Assert;
import org.junit.Test;

public class Aplicador15PorcientoTest {

    @Test
    public void noDeberiaAplicar5PorcientoDeImpuestoParticular(){
        Aplicador15Porciento aplicador = new Aplicador15Porciento();
        aplicador.setNext(new Aplicador20Porciento());
        Assert.assertEquals(0d, aplicador.aplicar(250000d,false),0.001);
    }

    @Test
    public void deberiaAplicar5PorcientoDeImpuestoEmpresa(){
        Aplicador15Porciento aplicador = new Aplicador15Porciento();
        aplicador.setNext(new Aplicador20Porciento());
        Assert.assertEquals(37500d, aplicador.aplicar(250000d,true),0.001);
    }

    @Test
    public void noDeberiaAplicar5PorcientoDeImpuestoEmpresa(){
        Aplicador15Porciento aplicador = new Aplicador15Porciento();
        aplicador.setNext(new Aplicador20Porciento());
        Assert.assertEquals(0d, aplicador.aplicar(90000d,true),0.001);
    }
}
