package ar.edu.untref.aydoo;

import java.util.List;

public class Promocion {
    private Producto productoDeLaPromocion;

    public Promocion(Producto unProducto) {
        this.productoDeLaPromocion = unProducto;
    }

    public Producto darProducto() {
        return this.productoDeLaPromocion;
    }

    public Double aplicar(List<Producto> items) {
        Double montoAPagar = 0d;
        return montoAPagar;
    }
}
