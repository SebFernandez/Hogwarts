package unlam.paradigmas.tp.hogwarts.producto;

import unlam.paradigmas.tp.hogwarts.dto.Usuario;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ListaProductos implements Iterable<Producto> {
	private final List<Producto> productos;
	private Usuario usuario;

	public ListaProductos(List<Producto> productos) {
		this.productos = productos;
	}

	//	TODO: Tiene que ordenar promociones y atracciones por separado (?)
	//	TODO: Ver si podemos tener productos y atracciones por separado
	public void ordenar(String preferenciaUsuario) {
		productos.sort(new ProductoComparator(preferenciaUsuario));
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public Iterator<Producto> iterator() {
		return new IteratorParaUsuario(usuario);
	}

	private class IteratorParaUsuario implements Iterator<Producto> {
		private int indice;
		private Usuario usuario;

		public IteratorParaUsuario(Usuario usuario) {
			this.usuario = usuario;
			this.indice = 0;
		}

		@Override
		public boolean hasNext() {
			return indice < productos.size() && esOfertable(productos.get(indice));
		}

		@Override
		public Producto next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			Producto producto = productos.get(indice);

			while(indice < productos.size() && !esOfertable(productos.get(indice)))
				indice++;

			return producto;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		private boolean esOfertable(Producto producto) {
			return (usuario.getPresupuesto() >= producto.getPrecio() &&
					usuario.getHoras() >= producto.getDuracion() &&
					!usuario.estaComprado(producto) &&
					producto.hayCupo());
		}

	}
}
