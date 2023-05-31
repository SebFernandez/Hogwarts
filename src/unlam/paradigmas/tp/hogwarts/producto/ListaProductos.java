package unlam.paradigmas.tp.hogwarts.producto;

import java.util.Iterator;
import java.util.List;

import unlam.paradigmas.tp.hogwarts.dto.Usuario;

public class ListaProductos implements Iterable<Producto>{
	private final List<Producto> productos;
	private Usuario usuario;
	
	public ListaProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public void ordenar(String preferenciaUsuario) {
		productos.sort(new ProductoComparator(preferenciaUsuario));
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public Iterator<Producto> iterator() {
		return new iteratorParaUsuario(usuario);
	}

	private class iteratorParaUsuario implements Iterator<Producto>{
		private int indice;
		private Usuario usuario;
		
		public iteratorParaUsuario(Usuario usuario) {
			this.usuario = usuario;
			this.indice = 0;
		}
		
		@Override
		public boolean hasNext() {
			return indice < productos.size() && esOfertable(productos.get(indice));
		}

		@Override
		public Producto next() {
			Producto producto = productos.get(indice);
			while(indice < productos.size() && !esOfertable(productos.get(indice))) {
				this.indice++;
			}
			return producto;
		}
		
		private boolean esOfertable(Producto producto) {
			return (usuario.getPresupuesto() >= producto.getPrecio() &&
					usuario.getHoras() >= producto.getDuracion()  &&
					!usuario.estaComprado(producto) && 
					producto.hayCupo());
		}
		
	}
	
	
	//TODO completar el iterator
}
