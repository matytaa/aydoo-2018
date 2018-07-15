package ar.edu.untref.aydoo.excepciones;

public class PorcentajeInversionException extends InversionException {
    private final static String mensaje = "El porcentaje de la inversión debe ser mayor a cero.";

    public PorcentajeInversionException() {
        super(mensaje);
    }
}
