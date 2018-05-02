package ar.edu.untref.aydoo;

public class Casillero {

    private Barco barco = null;
    private int fila;
    private int columna;
    private boolean casilleroDisponible;

    public Casillero(final int unaPosicionHorizontal,
                     final int unaPosicionVertical) {
        this.fila = unaPosicionHorizontal;
        this.columna = unaPosicionVertical;
        this.casilleroDisponible = true;
    }

    public boolean estaVacio() {
        recibirDisparo();
        return this.barco == null;
    }

    public void ponerBarco(final Barco unBarco) {
        this.barco = unBarco;
    }

    public int dameTuPosicioHorizontal() {
        return this.fila;
    }

    public int dameTuPosicioVertical() {
        return this.columna;
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
