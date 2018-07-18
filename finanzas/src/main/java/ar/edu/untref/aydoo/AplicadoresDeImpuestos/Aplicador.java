package ar.edu.untref.aydoo.AplicadoresDeImpuestos;

public interface Aplicador {
    public void setNext (Aplicador unAplicador);
    public Double aplicar(Double monto, boolean esEmpresa);
}
