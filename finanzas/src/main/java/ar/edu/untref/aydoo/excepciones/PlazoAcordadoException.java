package ar.edu.untref.aydoo.excepciones;

public class PlazoAcordadoException extends InversionException {

    public PlazoAcordadoException(int cantidadDeDiasMinimos) {
        super("El plazo mínimo para un plazo fijo es de " + cantidadDeDiasMinimos + " días.");
    }
}
