package unlam.paradigmas.tp.hogwarts.producto;

import unlam.paradigmas.tp.hogwarts.dto.Usuario;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductoIterator implements Iterator<Producto> {  // TODO validad correcto funcionamiento
	private final List<Producto> productos;
	private final Usuario usuario;
	private int indice = 0;
	
	public ProductoIterator(List<Producto> productos,Usuario usuario) {
		this.usuario = usuario;
		this.productos = productos;
		
		while (indice < productos.size() && !productos.get(indice).esOfertable(usuario)) // TODO revisar
			indice++;
	}

//	public void ordenar() {
//		productos.sort(new ProductoComparator());
//	}

	@Override
	public boolean hasNext() {
		while (indice < productos.size() && !productos.get(indice).esOfertable(usuario))
			indice++;

		return indice < productos.size() && productos.get(indice).esOfertable(usuario);
	}

	@Override
	public Producto next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}

		Producto producto = productos.get(indice);
		indice++;

		return producto;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
