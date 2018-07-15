package ar.edu.untref.aydoo;

public class GrabadorDeImpuesto {

    public Double grabarImpuestos(Double monto, boolean esEmpresa) {
        Double resultado = 0d;
        if (monto < 20000.0d){
            return resultado;
        }

        if (esEmpresa) {
            resultado = grabarImpuestosEmpresa(monto);
        }else {
            resultado = grabarImpuestosParticular(monto);
        }
        return resultado;
    }

    private Double grabarImpuestosParticular(Double monto) {
        Double resultado = 0d;
        if (monto > 50000d && 100000d > monto)
            resultado = monto*0.05;

        return resultado;
    }

    private Double grabarImpuestosEmpresa(Double monto) {
        Double resultado = 0d;
        if (monto > 20000d && 50000 > monto)
            resultado = monto*0.05;

        return resultado;
    }
}
