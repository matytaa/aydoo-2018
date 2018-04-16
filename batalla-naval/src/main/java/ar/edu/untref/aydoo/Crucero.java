package ar.edu.untref.aydoo;

public class Crucero extends Barco {
    private Sentido sentido;

    public Crucero(final int tamanioBarco, final Sentido unSentido) {
        super(tamanioBarco);
        this.sentido = unSentido;
    }

    public void indicarSentido(final Sentido unSentido) {
        this.sentido = unSentido;
    }

    public Sentido obtenerSentido() {
        return this.sentido;
    }
}
