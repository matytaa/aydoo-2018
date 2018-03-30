package ar.edu.untref.aydoo;

public class HacedorDeCafe {
    private Cafetero miCafetero;
    private Lechero miLechero;

    public HacedorDeCafe() {
        this.miCafetero = new Cafetero();
        this.miLechero = new Lechero();
    }

    public void hacerCafe(Vaso unVaso) {
        this.miCafetero.ponerCafe(unVaso);
        this.miLechero.ponerLeche(unVaso);
    }
}
