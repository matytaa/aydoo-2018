package ar.edu.untref.aydoo;

public class MaquinaExpendedoraDeBebidas {
    private HacedorDeCafe miHacedorDeCafe;
    private Azucarero miAzucarero;
    private HacedorDeTeConLeche miHacedorDeTeConLeche;

    public MaquinaExpendedoraDeBebidas() {
        miAzucarero = new Azucarero();
        miHacedorDeCafe = new HacedorDeCafe();
        miHacedorDeTeConLeche = new HacedorDeTeConLeche();
    }

    public void hacerCafeConLecheConNDeAzucar(Vaso unVaso, int cantidadAzucar) {
        Vaso miVaso = unVaso;
        this.miHacedorDeCafe.hacerCafe(miVaso);
        this.miAzucarero.ponerAzucar(miVaso, cantidadAzucar);
    }

    public void hacerTeConLecheConNDeAzucar(Vaso unVaso, int cantidadAzucar) {
        this.miHacedorDeTeConLeche.hacerTeConLeche(unVaso);
        this.miAzucarero.ponerAzucar(unVaso,cantidadAzucar);
    }
}
