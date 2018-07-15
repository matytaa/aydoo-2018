package ar.edu.untref.aydoo;

public class Inversion {
    private Double monto;
    private Double porcentajeGanancia;

    public Inversion(Double monto) {
        this.monto = monto;
    }

    public void setPorcentajeGanancia(Double unPorcentaje){
        this.porcentajeGanancia = unPorcentaje;
    }

    public Double obtenerGanacias() {
        return this.monto*this.porcentajeGanancia;
    }

}
