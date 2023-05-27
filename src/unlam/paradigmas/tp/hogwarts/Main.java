package unlam.paradigmas.tp.hogwarts;

import static unlam.paradigmas.tp.hogwarts.servicio.Archivo.lecturaDeAtracciones;
import static unlam.paradigmas.tp.hogwarts.servicio.Archivo.lecturaDePaquetes;
import static unlam.paradigmas.tp.hogwarts.servicio.Archivo.lecturaDeUsuarios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import unlam.paradigmas.tp.hogwarts.dto.Atraccion;
import unlam.paradigmas.tp.hogwarts.dto.Promocion;
import unlam.paradigmas.tp.hogwarts.dto.Usuario;

public class Main {
	private static final String RUTA_ARCHIVO_USUARIOS = "Archivos/preferencias_usuarios.csv";
	private static final String RUTA_ARCHIVO_ATRACCIONES = "Archivos/Atracciones.csv";
	private static final String RUTA_ARCHIVO_PROMOCIONES = "Archivos/paquetes_a_ofrecer.csv";

	public static void main(String[] args) {
		System.out
				.println("\n\n----------------------------\t\tBienvenido a Hoghwarts\t\t----------------------------");

		try {
			List<Usuario> listaDeUsuarios = lecturaDeUsuarios(RUTA_ARCHIVO_USUARIOS);
			List<Atraccion> listaDeAtracciones = lecturaDeAtracciones(RUTA_ARCHIVO_ATRACCIONES);
			List<Promocion> listaDePaquetes = lecturaDePaquetes(RUTA_ARCHIVO_PROMOCIONES);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String opc = null;

			do {
				Usuario actualUser = listaDeUsuarios.get(0);
				do {
					// Ofertador ofrece promos
					// Ofertador ofrece atracciones
					// Ofertador ofrece gustos distintos

					do {
						System.out.println("Acepta Sugerencia? Ingrese S o N");
						opc = br.readLine();
					} while (opc.charAt(0) != 'S' && opc.charAt(0) != 'N');

					if (opc.charAt(0) == 'S') {
						// Guardar en archivo promo/atraccion que el usuario haya escogido
						// Quitar de la lista de atracciones las que se ofertaron
					}

				} while (actualUser.recursosDisponibles());
				// Se guarda en el archivo de resumen
				// Se remueve el usuario
			} while (!listaDeUsuarios.isEmpty());

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		System.out.println(
				"\n\n----------------------------\tHoghwarts le desea un lindo paseo!\t----------------------------\n\n");
	}
}
