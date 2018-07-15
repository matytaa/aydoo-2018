package ar.edu.untref.aydoo;

import java.util.List;

public class Inversor {
    private final boolean esEmpresa;
    private final List<Inversion> listaDeInversiones;

    public Inversor(boolean esEmpresa, List<Inversion> listaDeInversiones) {
        this.esEmpresa = esEmpresa;
        this.listaDeInversiones = listaDeInversiones;
    }


    public int cantidadDeInvesiones() {
        return this.listaDeInversiones.size();
    }
}
