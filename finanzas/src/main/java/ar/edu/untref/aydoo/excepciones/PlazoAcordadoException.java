package ar.edu.untref.aydoo.excepciones;

public class PlazoAcordadoException extends InversionException {
    private final static String mensaje = "El plazo mínimo para un plazo fijo es de 30 días.";

    public PlazoAcordadoException() {
        super(mensaje);
    }
}
