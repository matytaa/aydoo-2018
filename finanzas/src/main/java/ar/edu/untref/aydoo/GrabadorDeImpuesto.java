package ar.edu.untref.aydoo;

public class GrabadorDeImpuesto {

    private AplicadorDeImpuesto aplicadorDeImpuestos;

    public GrabadorDeImpuesto(){
        this.aplicadorDeImpuestos = new AplicadorDeImpuesto();
    }

    public Double grabarImpuestos(Double monto, boolean esEmpresa) {
        Double resultado = 0d;
        if (monto < 20000.0d){
            return resultado;
        }

        return this.aplicadorDeImpuestos.aplicar(monto, esEmpresa);
    }

}
