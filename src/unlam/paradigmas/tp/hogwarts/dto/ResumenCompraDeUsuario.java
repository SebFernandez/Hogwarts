package unlam.paradigmas.tp.hogwarts.dto;

import java.util.HashSet;
import java.util.Set;

import unlam.paradigmas.tp.hogwarts.producto.Producto;

public class ResumenCompraDeUsuario {
	private Set<Producto> compras;
	
	public ResumenCompraDeUsuario() {
		compras = new HashSet<>();
	}
	
	public boolean estaComprado(Producto otro) { // TODO testear metodo
		for (Producto producto : compras) {
			if(producto.contiene(otro))
				return true;
		}
		return false;
	}
	
	public boolean comprar(Producto producto) { // TODO testear
		return ( !estaComprado(producto) )? compras.add(producto) : false;
	}
	
	
	//TODO hacer el metodo generarResumen
}
