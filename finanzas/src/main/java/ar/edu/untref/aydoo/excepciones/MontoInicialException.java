package ar.edu.untref.aydoo.excepciones;

public class MontoInicialException extends InversionException {
    private final static String mensaje = "El monto a invertir debe ser mayor a 1000.";

    public MontoInicialException() {
        super(mensaje);
    }
}
