package ar.edu.untref.aydoo.excepciones;

public class InversionInvalidaException extends InversionException {

    public InversionInvalidaException(String mensaje) {
        super("El argumento " + mensaje + " no es una inversión válida");
    }
}
