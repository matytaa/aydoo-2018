package ar.edu.untref.aydoo;


import ar.edu.untref.aydoo.AplicadoresDeImpuestos.*;

public class AplicadorDeImpuesto {

    private Aplicador5Porciento cinco;
    private Aplicador8Porciento ocho;
    private Aplicador10Porciento diez;
    private Aplicador15Porciento quince;
    private Aplicador20Porciento veinte;

    public AplicadorDeImpuesto(){
        cinco = new Aplicador5Porciento();
        ocho = new Aplicador8Porciento();
        diez = new Aplicador10Porciento();
        quince = new Aplicador15Porciento();
        veinte = new Aplicador20Porciento();
        setearAplicadoresDeImpuestos();
    }

    private void setearAplicadoresDeImpuestos() {
        cinco.setNext(ocho);
        ocho.setNext(diez);
        diez.setNext(quince);
        quince.setNext(veinte);
        veinte.setNext(null);

    }

    public Double aplicar(Double monto, boolean esEmpresa) {
        return cinco.aplicar(monto,esEmpresa);
    }
}
