package ar.edu.untref.aydoo;

public class MaquinaExpendedoraDeBebidas {
    private HacedoDeCafe miHacedorDeCafe;
    private Azucarero miAzucarero;

    public MaquinaExpendedoraDeBebidas() {
        miAzucarero = new Azucarero();
        miHacedorDeCafe = new HacedoDeCafe();
    }

    public void hacerCafeConLecheConNDeAzucar(Vaso unVaso, int cantidadAzucar) {
        Vaso miVaso = unVaso;
        this.miHacedorDeCafe.hacerCafe(miVaso);
        this.miAzucarero.ponerCafe(miVaso, cantidadAzucar);
    }

    public void hacerTeConLecheConNDeAzucar(Vaso unVaso, int cantidadAzucar) {
    }
}
