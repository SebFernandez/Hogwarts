package unlam.paradigmas.tp.hogwarts.producto;

import java.util.Comparator;

public class ProductoComparator implements Comparator<Producto> {

	@Override
	public int compare(Producto prod1, Producto prod2) { // nueva version, reseñas?
		boolean esPromocion1 = prod1.esPromocion();
		boolean esPromocion2 = prod2.esPromocion();

//	    if (esPromocion1 && !esPromocion2)
//	        return 1;
//	    else if (!esPromocion1 && esPromocion2) 
//	        return -1;
//
//	    int cmp = Double.compare(prod1.getPrecio(), prod2.getPrecio());
//	    if (cmp != 0) 
//	        return cmp;
//	   
//	    return Double.compare(prod1.getDuracion(), prod2.getDuracion());

	    if (esPromocion1 && !esPromocion2)
	        return -1; 
	    else if (!esPromocion1 && esPromocion2)
	        return 1; 

	    // Ambos son promociones o ambos son atracciones
	    if (prod1 instanceof Promocion && prod2 instanceof Promocion) {
	        Promocion promocion1 = (Promocion) prod1;
	        Promocion promocion2 = (Promocion) prod2;

	        int cmpDuracion = Double.compare(promocion2.getDuracion(), promocion1.getDuracion());
	        if (cmpDuracion != 0)
	            return cmpDuracion; 

	        int cmpPrecio = Double.compare(promocion2.getPrecio(), promocion1.getPrecio());
	        if (cmpPrecio != 0)
	            return cmpPrecio; 
	    } else {
	        Atraccion atraccion1 = (Atraccion) prod1;
	        Atraccion atraccion2 = (Atraccion) prod2;

	        int cmpDuracion = Double.compare(atraccion2.getDuracion(), atraccion1.getDuracion());
	        if (cmpDuracion != 0)
	            return cmpDuracion; 

	        int cmpPrecio = Double.compare(atraccion2.getPrecio(), atraccion1.getPrecio());
	        if (cmpPrecio != 0)
	            return cmpPrecio; 
	    }

	    return 0;

	}

//	@Override
//	public int compare(Producto prod1, Producto prod2) {
//		int cmp;
//		if ((cmp = cmpBol(prod1.esProductoPreferidoPorElUsuario(preferencia), prod2.esProductoPreferidoPorElUsuario(preferencia))) == 0)
//			if ((cmp = cmpClase(prod1, prod2)) == 0)
//				if ((cmp = Double.compare(prod1.getPrecio(), prod2.getPrecio())) == 0)
//					cmp = Double.compare(prod1.getDuracion(), prod2.getDuracion()); 
//
//		return cmp;
//	}
}
