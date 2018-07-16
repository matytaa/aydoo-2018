package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.excepciones.InversionException;
import ar.edu.untref.aydoo.excepciones.TipoDeInversorException;

import java.util.Locale;

public class SimuladorDeImpuestos {

    private ProcesadorDeArgumentosInversiones procesador;
    private Inversor inversor;
    private GrabadorDeImpuesto grabadorDeImpuesto;

    protected SimuladorDeImpuestos(Boolean tipoInversor, String argumentos) throws InversionException {
        this.procesador = new ProcesadorDeArgumentosInversiones(argumentos);
        this.grabadorDeImpuesto = new GrabadorDeImpuesto();
        this.inversor = new Inversor(tipoInversor, this.procesador.procesar());
    }

    public Double obtenerGanancias() {
        return this.inversor.calcularGanacias();
    }

    public Double aplicarImpuesto() {
        return this.grabadorDeImpuesto.grabarImpuestos(obtenerGanancias(), this.inversor.esEmpresa());
    }

    public String armarSalida() {
        String resultado = String.format(Locale.US, "ganancia: %.2f, impuesto: %.2f", obtenerGanancias(), aplicarImpuesto());
        return resultado;
    }

    public static final void main(final String[] arg) {
        String tipoInversor = arg[0];
        if (!tipoInversor.matches("ind|emp") || tipoInversor.length() > 3) {
            try {
                throw new TipoDeInversorException();
            } catch (TipoDeInversorException e) {
                System.out.println(e.getMessage());
            }
        }
        boolean esEmpresa = (tipoInversor.contains("emp"));
        String argumentosInversiones = armarArgumentos(arg);
        SimuladorDeImpuestos simulador = null;
        try {
            simulador = new SimuladorDeImpuestos(esEmpresa, argumentosInversiones);
            System.out.println(simulador.armarSalida());
        } catch (InversionException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String armarArgumentos(String[] arg) {
        String argumentos = "";
        for (int i = 1; i < arg.length; i++) {
            argumentos += " " + arg[i];
        }
        return argumentos;
    }

}
