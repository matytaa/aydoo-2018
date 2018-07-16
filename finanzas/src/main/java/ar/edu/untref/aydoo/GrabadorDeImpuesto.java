package ar.edu.untref.aydoo;

public class GrabadorDeImpuesto {
    private static final double MONTO_MINIMO = 20000.0d;
    private AplicadorDeImpuesto aplicadorDeImpuestos;

    public GrabadorDeImpuesto() {
        this.aplicadorDeImpuestos = new AplicadorDeImpuesto();
    }

    public Double grabarImpuestos(Double monto, boolean esEmpresa) {
        if (monto < MONTO_MINIMO) {
            return 0d;
        }
        return this.aplicadorDeImpuestos.aplicar(monto, esEmpresa);
    }

}
