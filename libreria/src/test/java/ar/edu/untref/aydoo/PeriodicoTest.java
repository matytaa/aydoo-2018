package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class PeriodicoTest {
    @Test
    public void crearPeriodicoYSolicitarPrecio (){
        Periodico unPeriodico = new Periodico(10,3);
        Assert.assertEquals(10, unPeriodico.darPrecio());
    }

    @Test
    public void crearPeriodicoYSolicitarPeriodicidad (){
        Periodico unPeriodico = new Periodico(10,3);
        Assert.assertEquals(3, unPeriodico.darPeriodicidad());
    }
}
