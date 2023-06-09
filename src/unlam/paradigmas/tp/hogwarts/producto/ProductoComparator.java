package unlam.paradigmas.tp.hogwarts.producto;

import java.util.Comparator;

public class ProductoComparator implements Comparator<Producto> {
	
	@Override
	public int compare(Producto prod1, Producto prod2) { // nueva version, reseñas?
	    boolean esPromocion1 = prod1 instanceof Promocion;
	    boolean esPromocion2 = prod2 instanceof Promocion;
	    
	    if (esPromocion1 && !esPromocion2)
	        return 1; 
	    else if (!esPromocion1 && esPromocion2) 
	        return -1;

	    int cmp = Double.compare(prod1.getPrecio(), prod2.getPrecio());
	    if (cmp != 0) 
	        return cmp;
	   
	    return Double.compare(prod1.getDuracion(), prod2.getDuracion());
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
