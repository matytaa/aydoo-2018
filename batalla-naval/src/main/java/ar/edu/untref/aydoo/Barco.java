package ar.edu.untref.aydoo;

public class Barco {

<<<<<<< HEAD
=======
    private Sentido sentido;
>>>>>>> batalla-naval
    private int tamanio;
    private int parteDaniada;

    public Barco(final int tamanioBarco) {
        this.tamanio = tamanioBarco;
        this.parteDaniada = 0;
    }

    public int obtenerTamanio() {
        return this.tamanio;
    }

    public void tocado() {
        if (this.tamanio > this.parteDaniada) {
            this.parteDaniada++;
        }
    }

    public boolean estaHundido() {
        return this.parteDaniada == this.tamanio;
    }

<<<<<<< HEAD
=======
    public void indicarSentido(final Sentido unSentido) {
        this.sentido = unSentido;
    }

    public Sentido obtenerSentido() {
        return this.sentido;
    }
>>>>>>> batalla-naval
}
