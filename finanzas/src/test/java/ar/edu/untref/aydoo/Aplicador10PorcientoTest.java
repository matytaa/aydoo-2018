package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class Aplicador10PorcientoTest {
    @Test
    public void deberiaAplicar10PorcientoDeImpuestoParticular(){
        Aplicador10Porciento aplicador = new Aplicador10Porciento();
        aplicador.setNext(new Aplicador20Porciento());
        Assert.assertEquals(50000d, aplicador.aplicar(500000d,false),0.001);
    }

    @Test
    public void noDeberiaAplicar10PorcientoDeImpuestoParticular(){
        Aplicador10Porciento aplicador = new Aplicador10Porciento();
        aplicador.setNext(new Aplicador20Porciento());
        Assert.assertEquals(0d, aplicador.aplicar(400000d,false),0.001);
    }

    @Test
    public void deberiaAplicar10PorcientoDeImpuestoEmpresa(){
        Aplicador10Porciento aplicador = new Aplicador10Porciento();
        aplicador.setNext(new Aplicador20Porciento());
        Assert.assertEquals(8000d, aplicador.aplicar(80000d,true),0.001);
    }

    @Test
    public void noDeberiaAplicar10PorcientoDeImpuestoEmpresa(){
        Aplicador10Porciento aplicador = new Aplicador10Porciento();
        aplicador.setNext(new Aplicador20Porciento());
        Assert.assertEquals(0d, aplicador.aplicar(49000d,true),0.001);
    }
}
