package unlam.paradigmas.tp.hogwarts;

import unlam.paradigmas.tp.hogwarts.dto.Usuario;
import unlam.paradigmas.tp.hogwarts.producto.Atraccion;
import unlam.paradigmas.tp.hogwarts.producto.Promocion;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

import static unlam.paradigmas.tp.hogwarts.servicio.Archivo.*;

public class Main {
	private static final String RUTA_ARCHIVO_USUARIOS = "Archivos/preferencias_usuarios.csv";
	private static final String RUTA_ARCHIVO_ATRACCIONES = "Archivos/Atracciones.csv";
	private static final String RUTA_ARCHIVO_PROMOCIONES = "Archivos/paquetes_a_ofrecer.csv";

	public static void main(String[] args) {
		System.out.println("\n\n----------------------------\t\tHogwarts les desea una feliz bienvenida\t\t----------------------------");

		try {
			Queue<Usuario> colaDeUsuarios = lecturaDeUsuarios(RUTA_ARCHIVO_USUARIOS);
			Map<String, Atraccion> atracciones = lecturaDeAtracciones(RUTA_ARCHIVO_ATRACCIONES);
			List<Promocion> listaDePromociones = lecturaDePromociones(RUTA_ARCHIVO_PROMOCIONES, atracciones);

			Promocion prod = new Promocion();
			prod = listaDePromociones.get(0);

			List<Atraccion> atrac1 = prod.getAtracciones();

			System.out.println(
					"--------------------------------------------------------------------------------------------------------");
			System.out.println("Nombre de visitante:\n");

			boolean aceptada = false;
			Scanner scanner = new Scanner(System.in); 

			do {
				System.out.println("Promocion");
				System.out.print("-Atracciones incluidas: ");
				prod.mostrarListaAtracciones();
				System.out.println("-Duracion:" + prod.getDuracion());
				System.out.println("-Precio original:" + prod.getPrecioOriginal());
				System.out.print("-Precio con descuento:");
				System.out.println(String.format("%.0f", prod.getPrecio()));
				System.out.println();
				System.out.println("¿Acepta sugerencia? Ingrese S o N");
				String respuesta = scanner.nextLine();
				if (respuesta.equalsIgnoreCase("S")) {
					System.out.println("¡Aceptada!");
					aceptada = true;
				}

				System.out.println("--------------------------------------------------------------------------------------------------------");
			} while (!aceptada);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n\n----------------------------\t\t\t\t\t¡Vuelvan pronto!\t\t\t\t----------------------------\n\n");
	}

}
