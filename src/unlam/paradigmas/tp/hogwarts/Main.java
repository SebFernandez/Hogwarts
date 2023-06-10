package unlam.paradigmas.tp.hogwarts;

import static unlam.paradigmas.tp.hogwarts.servicio.Archivo.*;

import java.io.IOException;
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
		System.out.println("\n\n----------------------------\t\tHogwarts les desea una feliz bienvenida\t\t----------------------------");


		Map<String, Set<Producto>> resumenCompraDeUsuarios = new HashMap<>();                       //  OK
		Queue<Usuario> colaDeUsuarios = lecturaDeUsuarios(RUTA_ARCHIVO_USUARIOS);
		Map<String, Atraccion> atracciones = lecturaDeAtracciones(RUTA_ARCHIVO_ATRACCIONES);
		List<Promocion> listaDePromociones = lecturaDePromociones(RUTA_ARCHIVO_PROMOCIONES, atracciones);


		/*
		iteración
		el usuario no puede comprar más, agrego las compras de usuario
		 */

		System.out.println("\n\n----------------------------\t\t\t\t\t¡Vuelvan pronto!\t\t\t\t----------------------------\n\n");
	}

	/*
	*  TODO: La resolución debe incluir pruebas unitarias de:
	*  1. las funcionalidades de paquete
	*  2. totalizador de itinerarios
	*  3. el ofertador de atracciones/paquetes.
	 */
}
