package ar.edu.untref.aydoo;

import java.util.List;

public class Promocion2X1 extends Promocion{

    public Promocion2X1(Producto unProducto) {
        super(unProducto);
    }

    public Double aplicar(List<Producto> items) {
        Double montoAPagar = 10.89d;
        return montoAPagar;
    }
}
