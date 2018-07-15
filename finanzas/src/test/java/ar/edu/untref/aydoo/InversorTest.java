package ar.edu.untref.aydoo;

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
}
