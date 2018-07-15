package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.AplicadoresDeImpuestos.Aplicador20Porciento;
import ar.edu.untref.aydoo.AplicadoresDeImpuestos.Aplicador8Porciento;
import org.junit.Assert;
import org.junit.Test;

public class Aplicador8PorcientoTest {
    @Test
    public void deberiaAplicar8PorcientoDeImpuestoParticular(){
        Aplicador8Porciento aplicador = new Aplicador8Porciento();
        aplicador.setNext(new Aplicador20Porciento());
        Assert.assertEquals(8000d, aplicador.aplicar(100000d,false),0.001);
    }

    @Test
    public void noDeberiaAplicar8PorcientoDeImpuestoParticular(){
        Aplicador8Porciento aplicador = new Aplicador8Porciento();
        aplicador.setNext(new Aplicador20Porciento());
        Assert.assertEquals(0d, aplicador.aplicar(25000d,false),0.001);
    }

    @Test
    public void noDeberiaAplicar8PorcientoDeImpuestoEmpresa(){
        Aplicador8Porciento aplicador = new Aplicador8Porciento();
        aplicador.setNext(new Aplicador20Porciento());
        Assert.assertEquals(0d, aplicador.aplicar(100000d,true),0.001);
    }
}
