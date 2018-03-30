package ar.edu.untref.aydoo;

public class HacedoDeCafe {
    private Cafetero miCafetero;
    private Lechero miLechero;

    public HacedoDeCafe() {
        this.miCafetero = new Cafetero();
        this.miLechero = new Lechero();
    }

    public void hacerCafe(Vaso unVaso) {
        this.miCafetero.ponerCafe(unVaso);
        this.miLechero.ponerLeche(unVaso);
    }
}
