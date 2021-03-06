package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicopaez on 25/04/2018.
 */
public class Compra {
    private final List<Promocion> promociones;
    private List<Producto> items;

    public Compra(List<Promocion> promocionesActivas) {
        this.items = new ArrayList<Producto>();
        this.promociones = promocionesActivas;

    }

    public void agregar(Producto unProducto) {
        this.items.add(unProducto);
    }

    public Double calcularTotal() {
        Double total = 0d;
        total = calcularTotalDeProductosConPromociones();
        if (total == 0) {
            total = calcularTotalDeProductosSinPromociones();
        }
        return total;
    }

    private Double calcularTotalDeProductosConPromociones() {
        Double totalConPromociones = 0d;
        List<Producto> itemsAProcesar = new ArrayList<Producto>();
        itemsAProcesar.addAll(this.items);
        for (Promocion promocion : this.promociones) {
            totalConPromociones += promocion.aplicar(itemsAProcesar);
        }
        return totalConPromociones;
    }

    private Double calcularTotalDeProductosSinPromociones() {
        Double totalSinPromociones = 0d;
        for (Producto prod : items) {
            totalSinPromociones += prod.getPrecioConIva();
        }
        return totalSinPromociones;
    }
}
