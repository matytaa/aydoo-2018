package ar.edu.untref.aydoo;

public class PlazoFijoPrecancelable extends Inversion {
    private final int plazoAcordado;
    private final Double interes;

    public PlazoFijoPrecancelable(Double monto, int plazoAcordado, Double interes) {
        super(monto);
        this.plazoAcordado = plazoAcordado;
        this.interes = interes;
    }

    public Double obtenerGanacias(int diaARetirar) {
        if (diaARetirar >= this.plazoAcordado){
            super.setPorcentajeGanancia(interes/100);
            return super.obtenerGanacias();
        }else{
            super.setPorcentajeGanancia((interes/100)/2);
        }
        return super.obtenerGanacias();
    }
}
