package unlam.paradigmas.tp.hogwarts;

import static unlam.paradigmas.tp.hogwarts.servicio.Archivo.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.*;

import unlam.paradigmas.tp.hogwarts.dto.Usuario;
import unlam.paradigmas.tp.hogwarts.producto.Atraccion;
import unlam.paradigmas.tp.hogwarts.producto.Producto;
import unlam.paradigmas.tp.hogwarts.producto.Promocion;

public class Main {
	private static final String RUTA_ARCHIVO_USUARIOS = "Archivos/preferencias_usuarios.csv";
	private static final String RUTA_ARCHIVO_ATRACCIONES = "Archivos/Atracciones.csv";
	private static final String RUTA_ARCHIVO_PROMOCIONES = "Archivos/paquetes_a_ofrecer.csv";

	public static void main(String[] args) throws IOException {

		Map<String, Set<Producto>> resumenCompraDeUsuarios = new HashMap<>();
		Queue<Usuario> colaDeUsuarios = lecturaDeUsuarios(RUTA_ARCHIVO_USUARIOS);
		Map<String, Atraccion> atracciones = lecturaDeAtracciones(RUTA_ARCHIVO_ATRACCIONES);
		List<Promocion> listaDePromociones = lecturaDePromociones(RUTA_ARCHIVO_PROMOCIONES, atracciones);

		int indice = 0;
		Promocion prod = new Promocion();

		System.out.println("\t\tBienvenido/a a Hogwarts");

		System.out.println("--------------------------------------------------------------------------------");
		// boolean aceptada = false;
		// Scanner scanner = new Scanner(System.in);

		// LISTA DE PRODUCTOS

		List<Producto> listaDeOfertas = Producto.listarOfertas(listaDePromociones, atracciones);

		// System.out.println(ofertas);

		Usuario usuActual = new Usuario();

		usuActual = colaDeUsuarios.poll();

		System.out.println("Nombre de visitante: " + usuActual.getNombre());

		/// Mostrando un mapa
//		atracciones.forEach((String, Atraccion) -> {
//			System.out.println(Atraccion);
//		});

		/// Mostrando promociones

		do {

			prod = listaDePromociones.get(indice);
			// List<Atraccion> atrac1 = prod.getAtracciones();

			System.out.println(prod);

			indice++;

			System.out.println(
					"--------------------------------------------------------------------------------------------------------");
		} while (indice < listaDePromociones.size());

		System.out.println(
				"\n\n----------------------------\t\t\t\t\t¡Vuelvan pronto!\t\t\t\t----------------------------\n\n");
	}

	/*
	*  TODO: La resolución debe incluir pruebas unitarias de:
	*  1. las funcionalidades de paquete
	*  2. totalizador de itinerarios
	*  3. el ofertador de atracciones/paquetes.
	 */
}
