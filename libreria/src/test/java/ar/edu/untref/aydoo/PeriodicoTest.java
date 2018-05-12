package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class PeriodicoTest {
    @Test
    public void crearPeriodicoYSolicitarPrecio (){
        Periodico unPeriodico = new Periodico(10.0,3);
        Double unPrecio = 10.0;
        Assert.assertEquals(unPrecio, unPeriodico.darPrecio());
    }

    @Test
    public void crearPeriodicoYSolicitarPeriodicidad (){
        Periodico unPeriodico = new Periodico(10.0,3);
        Assert.assertEquals(3, unPeriodico.darPeriodicidad());
    }
}
