package ar.edu.untref.aydoo.excepciones;

public class TipoDeInversorException extends Exception {
    private final static String mensaje = "Tipo de inversor inválido.";

    public TipoDeInversorException() {
        super(mensaje);
    }
}
