package unlam.paradigmas.tp.hogwarts.servicio;

import unlam.paradigmas.tp.hogwarts.dto.Producto;

import java.util.Comparator;

public class ProductoComparator implements Comparator<Producto> {

    @Override
    public int compare(Producto producto1, Producto producto2) {
        boolean producto1esPromocion = producto1.esPromocion();
        boolean producto2esPromocion = producto2.esPromocion();

        if (producto1esPromocion && !producto2esPromocion)
            return -1;

        if (!producto1esPromocion && producto2esPromocion)
            return 1;

        int cmpPrecio = Double.compare(producto2.getPrecio(), producto1.getPrecio());
        if (cmpPrecio != 0)
            return cmpPrecio;

        return Double.compare(producto2.getDuracion(), producto1.getDuracion());
    }
}
