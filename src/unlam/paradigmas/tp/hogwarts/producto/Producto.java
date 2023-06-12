package unlam.paradigmas.tp.hogwarts.producto;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import unlam.paradigmas.tp.hogwarts.dto.Usuario;

public abstract class Producto {
	
	protected boolean esPromocion;

	public abstract boolean hayCupo();

	public abstract void descontarCupo();

	public abstract boolean esProductoPreferidoPorElUsuario(String preferencia);

	public abstract double getPrecio();

	public abstract double getDuracion();
	
	public abstract boolean contiene(Producto otro);

	public boolean comprar() {
		if(hayCupo()){
			descontarCupo();
			return true;
		}
		return false;
	}
	public boolean esPromocion ()   {
		return this.esPromocion;
	}
	
	public boolean esOfertable(Usuario usuario) {
		return (usuario.getPresupuesto() >= this.getPrecio() &&
				usuario.getHoras() >= this.getDuracion() &&
				!usuario.estaComprado(this) &&
				this.hayCupo());
	}
	
	
	public static List<Producto> listarOfertas(List<Promocion> promos, Map<String, Atraccion> atrac)
	{
		List<Producto> ofertas = new ArrayList<>();
		ofertas.addAll(promos);
        ofertas.addAll(atrac.values());

        ProductoComparator comparator = new ProductoComparator();
        ofertas.sort(comparator);
        
        return ofertas;
		
	}
	
	
}
