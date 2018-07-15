package ar.edu.untref.aydoo;

public interface Aplicador {
    public void setNext (Aplicador unAplicador);
    public Aplicador getNext();
    public Double aplicar(Double monto, boolean esEmpresa);
}
