package unlam.paradigmas.tp.hogwarts;

import static unlam.paradigmas.tp.hogwarts.servicio.Archivo.lecturaDeAtracciones;
import static unlam.paradigmas.tp.hogwarts.servicio.Archivo.lecturaDePromociones;
import static unlam.paradigmas.tp.hogwarts.servicio.Archivo.lecturaDeUsuarios;
import static unlam.paradigmas.tp.hogwarts.servicio.Archivo.generarArchivoSalida;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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

		Map<String, List<Producto>> resumenCompraDeUsuarios = new HashMap<>();
		Queue<Usuario> colaDeUsuarios = lecturaDeUsuarios(RUTA_ARCHIVO_USUARIOS);
		Map<String, Atraccion> atracciones = lecturaDeAtracciones(RUTA_ARCHIVO_ATRACCIONES);
		List<Promocion> listaDePromociones = lecturaDePromociones(RUTA_ARCHIVO_PROMOCIONES, atracciones);

		System.out.println("\t\tBienvenido/a a Hogwarts");

		System.out.println("--------------------------------------------------------------------------------");

		// LISTA DE PRODUCTOS

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

			resumenCompraDeUsuarios.put(usuario.getNombre(), usuario.getCompras());
		}
		generarArchivoSalida(RUTA_ARCHIVO_SALIDA, resumenCompraDeUsuarios);
		System.out.println(
				"\n\n----------------------------\t\t\t\t\t¡Vuelvan pronto!\t\t\t\t----------------------------\n\n");
	}

	/*
	 * TODO 
	 * 1. Agregar interacción compra o no compra con el Scanner comentado. DONE (revisar)
	 * 2. Arreglar y/o revisar unit tests. xD
	 * 3. Revisar set de Datos (achicar algunos nombres). 
	 * 4. Llevar lógica del main a ofertador. DONE (revisar)
	 * 5. Pruebas unitarias de ofertador,resumenCompras y constructores de paquete y atracciones.
	 * 6. Actualizar diagramas de clase
	 * 7. Grabar video
	 * 8. Mejora formato archivo salida?
	 */
}
