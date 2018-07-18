package ar.edu.untref.aydoo.excepciones;

public class CotizacionDolarException extends InversionException {
    private final static String mensaje = "La cotización del dolar debe ser mayor a cero.";

    public CotizacionDolarException() {
        super(mensaje);
    }
}
