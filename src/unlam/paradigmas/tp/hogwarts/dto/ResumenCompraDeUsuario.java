package unlam.paradigmas.tp.hogwarts.dto;

import java.util.Set;

import unlam.paradigmas.tp.hogwarts.producto.Producto;

public class ResumenCompraDeUsuario {
	private Set<Producto> compras; ///TODO deberia ser otra collecion?
	
	public boolean estaComprado(Producto otro) {
		for (Producto producto : compras) {
			if(producto.contiene(otro))
				return true;
		}
		return false;
	}
	
	public boolean comprar(Producto producto) {
		if(estaComprado(producto)) {
			return false;
		}
		return compras.add(producto);
	}
	
	//TODO hacer el metodo generarResumen
}
