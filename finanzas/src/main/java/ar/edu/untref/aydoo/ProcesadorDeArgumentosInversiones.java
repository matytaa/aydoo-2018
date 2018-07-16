package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.excepciones.InversionInvalidaException;

public class ProcesadorDeArgumentosInversiones {
    private final String argumentos;

    public ProcesadorDeArgumentosInversiones(String argumentos) {
        this.argumentos = argumentos;
    }

    public boolean procesar() throws InversionInvalidaException {
        boolean resultado = false;
        String[] argumentos = this.argumentos.split("(?=\\s)");
        for (String argumento : argumentos) {
            argumento = argumento.replaceAll("\\s", "");
            if (puedeCrearInversion(argumento)
                    || puedeCrearInversionPlazoFijoPrecancelable(argumento)) {
                resultado = true;
            } else {
                throw new InversionInvalidaException(argumento);
            }
        }
        return resultado;

    }

    public boolean puedeCrearInversion(String argumento) {
        return argumento.matches("((pft|dol)+[,]+[0-9]+[,]+[0-9]+[,]+[0-9]+)");
    }

    public boolean puedeCrearInversionPlazoFijoPrecancelable(String argumento) {
        return argumento.matches("((pfp)+([,]+[0-9]+[,]+[0-9]+[,]+[0-9]+[,]+[0-9]+))");
    }
}
