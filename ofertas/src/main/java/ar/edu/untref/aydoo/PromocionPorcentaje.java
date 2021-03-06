package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.List;

/**
 * Created by nicopaez on 25/04/2018.
 */
public class PromocionPorcentaje extends Promocion {
    private final Double divisor = 100d;
    private final Double porcentajeDescuento;

    public PromocionPorcentaje(Producto producto, Double porcentajeDescuento) {
        super(producto);
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public Double aplicar(List<Producto> items) {
        Double montoAPagar = 0d;
        Iterator<Producto> it = items.iterator();
        Producto productoEnPromocion = super.darProducto();
        while (it.hasNext()) {
            if (productoEnPromocion.equals(it.next())) {
                Double precioTotal = productoEnPromocion.getPrecioConIva();
                Double montoADescontar =
                        (precioTotal * porcentajeDescuento) / this.divisor;
                montoAPagar += precioTotal - montoADescontar;
                it.remove();
            }
        }
        return montoAPagar;
    }
}
