package ar.edu.untref.aydoo;

public class GabadorDeFinanzas {

    public Double grabarImpuestos(Double monto) {
        if (monto < 20000.0d){
            return monto*1.d;
        }
        return monto*0.05;
    }
}
