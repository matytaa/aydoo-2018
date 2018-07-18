package ar.edu.untref.aydoo.excepciones;

public class PlazoAcordadoException extends InversionException {

    public PlazoAcordadoException(String tipoPlazoFijo, int cantidadDeDiasMinimos) {
        super("El plazo mínimo para un plazo fijo " + tipoPlazoFijo + " es de " + cantidadDeDiasMinimos + " días.");
    }
}
