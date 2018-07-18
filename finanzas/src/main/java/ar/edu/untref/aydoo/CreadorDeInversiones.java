package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.excepciones.MontoInicialException;

import java.util.LinkedList;
import java.util.List;

public class CreadorDeInversiones {
    private final List<Inversion> listaDeInversiones;
    private final ManejadorDeInversiones manejador;

    public CreadorDeInversiones() {
        this.listaDeInversiones = new LinkedList<>();
        this.manejador = new ManejadorDeInversiones();
    }

    public List crearInversion(String argumento) throws MontoInicialException {
        crearInversionDolares(argumento);
        return this.listaDeInversiones;
    }

    private void crearInversionDolares(String unArgumento) throws MontoInicialException {
        if (unArgumento.contains("dol")) {
            String[] argumentos = unArgumento.split("[,]");
            Double monto = Double.valueOf(argumentos[1]);
            Double cotizacionInicial = Double.valueOf(argumentos[2]);
            Double cotizacionFinal = Double.valueOf(argumentos[3]);
            manejador.crearInversion(monto, cotizacionInicial, cotizacionFinal);
            this.listaDeInversiones.add(manejador.getInversion());
        } else {
            crearInversionPlazoFijo(unArgumento);
        }
    }

    private void crearInversionPlazoFijo(String unArgumento) throws MontoInicialException {
        if (unArgumento.contains("pft")) {
            String[] argumentos = unArgumento.split("[,]");
            int plazo = Integer.valueOf(argumentos[1]);
            Double interes = Double.valueOf(argumentos[2]);
            Double monto = Double.valueOf(argumentos[3]);
            this.manejador.crearInversion(monto, plazo, interes);
            this.listaDeInversiones.add(manejador.getInversion());
        } else {
            crearInversionPlazoFijoPrecancelable(unArgumento);
        }
    }

    private void crearInversionPlazoFijoPrecancelable(String unArgumento) throws MontoInicialException {
        String[] argumentos = unArgumento.split("[,]");
        int plazo = Integer.valueOf(argumentos[1]);
        int plazoReal = Integer.valueOf(argumentos[2]);
        Double interes = Double.valueOf(argumentos[3]);
        Double monto = Double.valueOf(argumentos[4]);
        this.manejador.crearInversion(monto, plazo, plazoReal, interes);
        this.listaDeInversiones.add(manejador.getInversion());
    }
}
