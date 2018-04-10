package ar.edu.untref.aydoo;

public class Casillero {

    private Barco barco = null;
    private int horizontal;
    private int vertical;

    public Casillero(final int unaPosicionHorizontal, final int unaPosicionVertical) {
        this.horizontal = unaPosicionHorizontal;
        this.vertical = unaPosicionVertical;
    }

    public boolean estaVacio() {

        return this.barco == null;
    }

    public void ponerBarco(final Barco unBarco) {
        this.barco = unBarco;
    }

    public int dameTuPosicioHorizontal() {
        return this.horizontal;
    }

    public int dameTuPosicioVertical() {
        return this.vertical;
    }
}
