package unlam.paradigmas.tp.hogwarts;

import static unlam.paradigmas.tp.hogwarts.servicio.Archivo.lecturaDeAtracciones;
import static unlam.paradigmas.tp.hogwarts.servicio.Archivo.lecturaDePromociones;
import static unlam.paradigmas.tp.hogwarts.servicio.Archivo.lecturaDeUsuarios;
import static unlam.paradigmas.tp.hogwarts.servicio.Archivo.generarArchivoSalida;

import java.io.IOException;
import java.util.*;

import unlam.paradigmas.tp.hogwarts.dto.Atraccion;
import unlam.paradigmas.tp.hogwarts.dto.Producto;
import unlam.paradigmas.tp.hogwarts.dto.Promocion;
import unlam.paradigmas.tp.hogwarts.dto.Usuario;
import unlam.paradigmas.tp.hogwarts.servicio.Ofertador;
import unlam.paradigmas.tp.hogwarts.servicio.ProductoIterator;

public class Main {
	private static final String RUTA_ARCHIVO_USUARIOS = "Archivos/preferencias_usuarios.csv";
	private static final String RUTA_ARCHIVO_ATRACCIONES = "Archivos/Atracciones.csv";
	private static final String RUTA_ARCHIVO_PROMOCIONES = "Archivos/paquetes_a_ofrecer.csv";
	private static final String RUTA_ARCHIVO_SALIDA = "Archivos/resumen_compra_usuarios.out";
	
	public static void main(String[] args) throws IOException {

		List<Usuario> resumenCompraDeUsuarios = new ArrayList<>();
		Queue<Usuario> colaDeUsuarios = lecturaDeUsuarios(RUTA_ARCHIVO_USUARIOS);
		Map<String, Atraccion> atracciones = lecturaDeAtracciones(RUTA_ARCHIVO_ATRACCIONES);
		List<Promocion> listaDePromociones = lecturaDePromociones(RUTA_ARCHIVO_PROMOCIONES, atracciones);

		System.out.println("\t\tBienvenido/a a Hogwarts");
		System.out.println("--------------------------------------------------------------------------------");

		List<Producto> listaDeOfertas = Producto.prepararOfertas(listaDePromociones, atracciones);

		while (!colaDeUsuarios.isEmpty()) {
			Usuario usuario = colaDeUsuarios.poll();
			ProductoIterator productoIterator = new ProductoIterator(listaDeOfertas, usuario);
			Ofertador ofertador = new Ofertador(usuario, productoIterator);

			System.out.println("Nombre de Usuario: " + usuario.getNombre());
			System.out.println("gusto:"+usuario.getGusto());
			
			ofertador.ofertaGustoUsuario();

			ofertador.reiniciarIterador();

			ofertador.ofertaNoGustoUsuario();

			resumenCompraDeUsuarios.add(usuario);
		}

		generarArchivoSalida(RUTA_ARCHIVO_SALIDA, resumenCompraDeUsuarios);
		System.out.println(
				"\n\n----------------------------\t\t\t\t\t¡Vuelvan pronto!\t\t\t\t----------------------------\n\n");
	}

	/*
	 * TODO
	 * 6. Actualizar diagramas de clase
	 * 7. Grabar video
	 * 8. Mejora formato archivo salida?
	 */
}
