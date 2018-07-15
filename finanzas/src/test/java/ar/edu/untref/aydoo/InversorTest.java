package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.excepciones.InversionException;
import ar.edu.untref.aydoo.excepciones.MontoInicialException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class InversorTest {

    List<Inversion> listaDeInversiones;
    Double monto = 20000d;
    Double cotizacionInicial = 20d;
    Double cotizacionFinal = 25d;
    int plazoAcordado = 180;
    int plazoReal = 90;
    Double interes = 10d;
    CompraDolares compraDolares;
    PlazoFijoPrecancelable plazoFijoPrecancelable;
    PlazoFijo plazoFijoTradicional;


    @Before
    public void llenarLista() throws MontoInicialException {

        this.compraDolares = new CompraDolares(monto, cotizacionInicial, cotizacionFinal);
        this.plazoFijoPrecancelable = new PlazoFijoPrecancelable(monto, plazoAcordado, plazoReal, interes);
        this.plazoFijoTradicional = new PlazoFijo(monto, plazoAcordado, interes);

        this.listaDeInversiones = new LinkedList<>();
        this.listaDeInversiones.add(compraDolares);
        this.listaDeInversiones.add(plazoFijoPrecancelable);
        this.listaDeInversiones.add(plazoFijoTradicional);
    }

    @Test
    public void deberiaPoderCrearUnInversorCon3Inversiones() {
        boolean esEmpresa = true;
        Inversor inversor = new Inversor(esEmpresa, this.listaDeInversiones);
        Assert.assertEquals(3, inversor.cantidadDeInvesiones());
    }

    @Test
    public void deberiaPoderCalcularLasGananciasDeLa3Inversiones() throws InversionException {
        boolean esEmpresa = true;
        Inversor inversor = new Inversor(esEmpresa, this.listaDeInversiones);
        Assert.assertEquals(8000d, inversor.calcularGanacias(), 0.001);
    }

    @Test
    public void deberiaSerUnaEmpresaElInversor() {
        boolean esEmpresa = true;
        Inversor inversor = new Inversor(esEmpresa, this.listaDeInversiones);
        Assert.assertTrue(inversor.esEmpresa());
    }

    @Test
    public void deberiaPoderCalcularLasGananciasDeLa9Inversiones() throws InversionException {
        this.listaDeInversiones.add(compraDolares);
        this.listaDeInversiones.add(plazoFijoPrecancelable);
        this.listaDeInversiones.add(plazoFijoTradicional);
        this.listaDeInversiones.add(compraDolares);
        this.listaDeInversiones.add(plazoFijoPrecancelable);
        this.listaDeInversiones.add(plazoFijoTradicional);
        boolean esEmpresa = false;
        Inversor inversor = new Inversor(esEmpresa, this.listaDeInversiones);
        Assert.assertEquals(24000d, inversor.calcularGanacias(), 0.001);
    }

    @Test
    public void noDeberiaSumarGananciaDeUnPlazoFijoTradicionalConUnPlazoIncorrecto() throws InversionException {
        PlazoFijo unPlazoFijo = new PlazoFijo(1500d, 29, 10d);
        this.listaDeInversiones.add(unPlazoFijo);
        boolean esEmpresa = false;
        Inversor inversor = new Inversor(esEmpresa, this.listaDeInversiones);
        Assert.assertEquals(8000d, inversor.calcularGanacias(), 0.001);
    }

    @Test
    public void noDeberiaSumarGananciaDeUnPlazoFijoPrecancelableConUnPlazoIncorrecto() throws InversionException {
        PlazoFijoPrecancelable prestamo = new PlazoFijoPrecancelable(1500d,50, 50,20d);
        this.listaDeInversiones.add(prestamo);
        boolean esEmpresa = false;
        Inversor inversor = new Inversor(esEmpresa, this.listaDeInversiones);
        Assert.assertEquals(8000d, inversor.calcularGanacias(), 0.001);
    }
}
