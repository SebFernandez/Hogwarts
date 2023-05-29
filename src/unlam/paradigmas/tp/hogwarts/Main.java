package unlam.paradigmas.tp.hogwarts;

import unlam.paradigmas.tp.hogwarts.dto.Usuario;
import unlam.paradigmas.tp.hogwarts.producto.Atraccion;

import java.io.IOException;
import java.util.List;

import static unlam.paradigmas.tp.hogwarts.servicio.Archivo.lecturaDeAtracciones;
import static unlam.paradigmas.tp.hogwarts.servicio.Archivo.lecturaDeUsuarios;

public class Main {
	private static final String RUTA_ARCHIVO_USUARIOS = "Archivos/preferencias_usuarios.csv";
	private static final String RUTA_ARCHIVO_ATRACCIONES = "Archivos/Atracciones.csv";
	private static final String RUTA_ARCHIVO_PROMOIONES = "Archivos/paquetes_a_ofrecer.csv";

	public static void main(String[] args) {
		System.out.println("\n\n----------------------------\t\tHogwarts les desea una feliz bienvenida\t\t----------------------------");

		try {
			List<Usuario> listaDeUsuarios = lecturaDeUsuarios(RUTA_ARCHIVO_USUARIOS);
			List<Atraccion> listaDeAtracciones = lecturaDeAtracciones(RUTA_ARCHIVO_ATRACCIONES);

			System.out.println("Prueba");

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n\n----------------------------\t¡Vuelvan pronto!\t----------------------------\n\n");
	}
}
