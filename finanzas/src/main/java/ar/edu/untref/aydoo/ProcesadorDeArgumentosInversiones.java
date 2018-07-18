package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.excepciones.InversionException;
import ar.edu.untref.aydoo.excepciones.InversionInvalidaException;

import java.util.List;


public class ProcesadorDeArgumentosInversiones {
    private final String argumentos;
    private CreadorDeInversiones creadorDeInversiones;

    public ProcesadorDeArgumentosInversiones(String argumentos) {
        this.argumentos = argumentos;
        this.creadorDeInversiones = new CreadorDeInversiones();
    }

    public List procesar() throws InversionException {
        List unaLista = null;
        String[] argumentos = this.argumentos.split("(?=\\s)");
        for (String argumento : argumentos) {
            argumento = argumento.replaceAll("\\s", "");
            if (puedeCrearInversion(argumento)
                    || puedeCrearInversionPlazoFijoPrecancelable(argumento)) {
                unaLista = this.creadorDeInversiones.crearInversion(argumento);

            } else {
                throw new InversionInvalidaException(argumento);
            }
        }
        return unaLista;

    }

    public boolean puedeCrearInversion(String argumento) {
        return argumento.matches("((pft|dol)+[,]+.[0-9]+[,]+.[0-9]+[,]+.[0-9]+)");
    }

    public boolean puedeCrearInversionPlazoFijoPrecancelable(String argumento) {
        return argumento.matches("((pfp)+([,]+.[0-9]+[,]+.[0-9]+[,]+.[0-9]+[,]+.[0-9]+))");
    }
}
