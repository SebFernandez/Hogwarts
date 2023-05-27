package unlam.paradigmas.tp.hogwarts.producto;

import java.util.List;

public class ListaProductos {
	private final List<Producto> productos;

	public ListaProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public void ordenar(String preferenciaUsuario) {
		productos.sort(new ProductoComparator(preferenciaUsuario));
	}

	//TODO completar el iterator
}
