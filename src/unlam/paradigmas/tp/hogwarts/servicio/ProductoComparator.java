package unlam.paradigmas.tp.hogwarts.servicio;

import unlam.paradigmas.tp.hogwarts.dto.Atraccion;
import unlam.paradigmas.tp.hogwarts.dto.Producto;
import unlam.paradigmas.tp.hogwarts.dto.Promocion;

import java.util.Comparator;

public class ProductoComparator implements Comparator<Producto> {

	@Override
	public int compare(Producto prod1, Producto prod2) { // nueva version, reseñas?
		boolean esPromocion1 = prod1.esPromocion();
		boolean esPromocion2 = prod2.esPromocion();

		if (esPromocion1 && !esPromocion2)
			return -1;
		else if (!esPromocion1 && esPromocion2)
			return 1;

		// Ambos son promociones o ambos son atracciones
		if (esPromocion1 && esPromocion2) {
			Promocion promocion1 = (Promocion) prod1;
			Promocion promocion2 = (Promocion) prod2;

			int cmpPrecio = Double.compare(promocion2.getPrecio(), promocion1.getPrecio());
			if (cmpPrecio != 0)
				return cmpPrecio;

			int cmpDuracion = Double.compare(promocion2.getDuracion(), promocion1.getDuracion());
			if (cmpDuracion != 0)
				return cmpDuracion;

		} else {
			Atraccion atraccion1 = (Atraccion) prod1;
			Atraccion atraccion2 = (Atraccion) prod2;

			int cmpPrecio = Double.compare(atraccion2.getPrecio(), atraccion1.getPrecio());
			if (cmpPrecio != 0)
				return cmpPrecio;

			int cmpDuracion = Double.compare(atraccion2.getDuracion(), atraccion1.getDuracion());
			if (cmpDuracion != 0)
				return cmpDuracion;

		}

		return 0;

	}

}
