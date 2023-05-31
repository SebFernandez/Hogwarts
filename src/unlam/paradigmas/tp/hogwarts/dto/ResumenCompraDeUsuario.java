package unlam.paradigmas.tp.hogwarts.dto;

import java.util.Set;

import unlam.paradigmas.tp.hogwarts.producto.Producto;

public class ResumenCompraDeUsuario {
	private Set<Producto> compras;
	
	//TODO Completar esto
	public boolean estaComprado(Producto producto) {
		return compras.contains(producto);
	}
}
