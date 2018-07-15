package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class Aplicador5PorcientoTest {
    @Test
    public void deberiaAplicar5PorcientoDeImpuestoParticular(){
        Aplicador5Porciento aplicador = new Aplicador5Porciento();
        aplicador.setNext(new Aplicador20Porciento());
        Assert.assertEquals(2500d, aplicador.aplicar(50000d,false),0.001);
    }

    @Test
    public void noDeberiaAplicar5PorcientoDeImpuestoParticular(){
        Aplicador5Porciento aplicador = new Aplicador5Porciento();
        aplicador.setNext(new Aplicador20Porciento());
        Assert.assertEquals(0d, aplicador.aplicar(25000d,false),0.001);
    }

    @Test
    public void deberiaAplicar5PorcientoDeImpuestoEmpresa(){
        Aplicador5Porciento aplicador = new Aplicador5Porciento();
        aplicador.setNext(new Aplicador20Porciento());
        Assert.assertEquals(1250d, aplicador.aplicar(25000d,true),0.001);
    }

    @Test
    public void noDeberiaAplicar5PorcientoDeImpuestoEmpresa(){
        Aplicador5Porciento aplicador = new Aplicador5Porciento();
        aplicador.setNext(new Aplicador20Porciento());
        Assert.assertEquals(0d, aplicador.aplicar(19000d,true),0.001);
    }
}
