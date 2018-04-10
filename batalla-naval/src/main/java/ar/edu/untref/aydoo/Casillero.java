package ar.edu.untref.aydoo;

public class Casillero {

    private Barco barco = null;

    public boolean estaVacio() {

        return this.barco == null;
    }

    public void ponerBarco(final Barco unBarco) {
        this.barco = unBarco;
    }

}
