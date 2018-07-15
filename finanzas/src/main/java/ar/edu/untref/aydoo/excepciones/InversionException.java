package ar.edu.untref.aydoo.excepciones;

public class InversionException extends Exception{
    private final static String mensaje = "La inversión inválida.";

    public InversionException(String mensaje) {
        super(mensaje);
    }
}
