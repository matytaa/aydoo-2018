package ar.edu.untref.aydoo;

import ar.edu.untref.aydoo.excepciones.InversionException;

import java.util.Iterator;
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

    public Double calcularGanacias() {
        Double resultado = 0d;
        Iterator<Inversion> itInversiones = this.listaDeInversiones.iterator();
        while (itInversiones.hasNext()) {
            try {
                resultado += itInversiones.next().obtenerGanacias();
            } catch (InversionException e) {
                System.out.println(e.getMessage());
            }
        }
        return resultado;
    }

    public boolean esEmpresa() {
        return this.esEmpresa;
    }
}
