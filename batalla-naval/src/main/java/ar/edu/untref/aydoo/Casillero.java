package ar.edu.untref.aydoo;

public class Casillero {

    private Barco barco = null;
<<<<<<< HEAD

    public boolean estaVacio() {

        return this.barco == null;
    }

    public void ponerBarco(final Barco unBarco) {
        this.barco = unBarco;
    }
=======
    private int horizontal;
    private int vertical;
    private boolean casilleroDisponible;

    public Casillero(final int unaPosicionHorizontal,
                     final int unaPosicionVertical) {
        this.horizontal = unaPosicionHorizontal;
        this.vertical = unaPosicionVertical;
        this.casilleroDisponible = true;
    }

    public boolean estaVacio() {
        recibirDisparo();
        return this.barco == null;
    }
>>>>>>> batalla-naval

    public void ponerBarco(final Barco unBarco) {
        this.barco = unBarco;
    }

    public int dameTuPosicioHorizontal() {
        return this.horizontal;
    }

    public int dameTuPosicioVertical() {
        return this.vertical;
    }

    public Barco dameElBarco() {
        return this.barco;
    }

    public boolean recibirDisparo() {
        this.casilleroDisponible = false;
        return estadoCasillero();
    }

    public boolean estadoCasillero() {
        return this.casilleroDisponible;
    }
}
