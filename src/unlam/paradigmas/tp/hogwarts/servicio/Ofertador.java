package unlam.paradigmas.tp.hogwarts.servicio;

import unlam.paradigmas.tp.hogwarts.dto.Producto;
import unlam.paradigmas.tp.hogwarts.dto.Usuario;

import java.util.Scanner;

public class Ofertador {
	private char opc;
	private Scanner scanner = new Scanner(System.in);
	private ProductoIterator productoIterator;
	private Usuario usuario;

	public Ofertador(Usuario usuario, ProductoIterator productoIterator) {
		this.productoIterator = productoIterator;
		this.usuario = usuario;
	}

	public void reiniciarIterador() {
		this.productoIterator.reset();
	}

	private char ofrecerSugerencia() {
		do {
			System.out.println("¿Acepta Sugerencia? Ingrese S o N");
			opc = scanner.next().toUpperCase().charAt(0);
		} while (opc != 'S' && opc != 'N');
		return this.opc;
	}

	public Usuario ofertaGustoUsuario() {
		//int ite = 0;
		do {
			Producto producto = productoIterator.next();
			if (producto.esOfertable(usuario) && producto.esGustoPreferido(usuario)) {
				System.out.println(producto);
				opc = ofrecerSugerencia();
				if (opc == 'S')
					usuario.comprar(producto);
			}
		//	ite++;
		} while (productoIterator.hasNext());
		return this.usuario;
	}

	public Usuario ofertaNoGustoUsuario() {
		//int ite = 0;
		do {
			Producto producto = productoIterator.next();
			if (producto.esOfertable(usuario) && !producto.esGustoPreferido(usuario)) {
				System.out.println(producto);
				opc = ofrecerSugerencia();
				if (opc == 'S')
					usuario.comprar(producto);
			}
			//ite++;
		} while (productoIterator.hasNext());
		return this.usuario;
	}
}
