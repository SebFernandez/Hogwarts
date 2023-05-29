package unlam.paradigmas.tp.hogwarts;

import unlam.paradigmas.tp.hogwarts.dto.Usuario;
import unlam.paradigmas.tp.hogwarts.producto.Atraccion;
import unlam.paradigmas.tp.hogwarts.producto.Promocion;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n\n----------------------------\t¡Vuelvan pronto!\t----------------------------\n\n");
	}
}
