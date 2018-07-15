package ar.edu.untref.aydoo;

public class PlazoFijoTradicionalException extends Exception {
    private final static String mensaje = "Aún no se ha cumplido el plazo para que se cumpla el plazo fijo.";

    public PlazoFijoTradicionalException() {
        super(mensaje);
    }
}
