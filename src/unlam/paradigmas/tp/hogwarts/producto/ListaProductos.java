package unlam.paradigmas.tp.hogwarts.producto;

import java.util.ArrayList;

public class ListaProductos {
	private ArrayList<Producto> productos;
	
	public ListaProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	
	public void ordenar(String preferenciaUsuario) {
		productos.sort(new ProductoComparator(preferenciaUsuario));
	}
	
	//TODO completar el iterator
}
