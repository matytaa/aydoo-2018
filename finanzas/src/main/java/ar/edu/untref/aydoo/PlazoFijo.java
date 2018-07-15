package ar.edu.untref.aydoo;

public class PlazoFijo extends Inversion {
    private final int plazoAcordado;
    private final Double interes;

    public PlazoFijo(Double monto, int plazoAcordado, Double interes) {
        super(monto);
        this.plazoAcordado = plazoAcordado;
        this.interes = interes;
    }

    public Double obtenerGanacias(int diaARetirar) throws PlazoFijoTradicionalException {
        if (diaARetirar < this.plazoAcordado){
            throw new PlazoFijoTradicionalException();
        }
        super.setPorcentajeGanancia(interes/100);
        return super.obtenerGanacias();
    }
}
