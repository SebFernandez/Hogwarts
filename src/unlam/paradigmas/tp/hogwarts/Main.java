package unlam.paradigmas.tp.hogwarts;

import unlam.paradigmas.tp.hogwarts.dto.Atraccion;
import unlam.paradigmas.tp.hogwarts.dto.Producto;
import unlam.paradigmas.tp.hogwarts.dto.Promocion;
import unlam.paradigmas.tp.hogwarts.dto.Usuario;
import unlam.paradigmas.tp.hogwarts.servicio.ProductoIterator;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import static unlam.paradigmas.tp.hogwarts.servicio.Archivo.lecturaDeAtracciones;
import static unlam.paradigmas.tp.hogwarts.servicio.Archivo.lecturaDePromociones;
import static unlam.paradigmas.tp.hogwarts.servicio.Archivo.lecturaDeUsuarios;

public class Main {
    private static final String RUTA_ARCHIVO_USUARIOS = "Archivos/preferencias_usuarios.csv";
    private static final String RUTA_ARCHIVO_ATRACCIONES = "Archivos/Atracciones.csv";
    private static final String RUTA_ARCHIVO_PROMOCIONES = "Archivos/paquetes_a_ofrecer.csv";

    public static void main(String[] args) throws IOException {

        Map<String, Set<Producto>> resumenCompraDeUsuarios = new HashMap<>();
        Queue<Usuario> colaDeUsuarios = lecturaDeUsuarios(RUTA_ARCHIVO_USUARIOS);
        Map<String, Atraccion> atracciones = lecturaDeAtracciones(RUTA_ARCHIVO_ATRACCIONES);
        List<Promocion> listaDePromociones = lecturaDePromociones(RUTA_ARCHIVO_PROMOCIONES, atracciones);

        System.out.println("\t\tBienvenido/a a Hogwarts");

        System.out.println("--------------------------------------------------------------------------------");
        // boolean aceptada = false;
        // Scanner scanner = new Scanner(System.in);

        // LISTA DE PRODUCTOS

        List<Producto> listaDeOfertas = Producto.prepararOfertas(listaDePromociones, atracciones);

        while (!colaDeUsuarios.isEmpty()) {
            Usuario usuario = colaDeUsuarios.poll();
            ProductoIterator productoIterator = new ProductoIterator(listaDeOfertas, usuario);

            do {
                Producto producto = productoIterator.next();
                if (producto.esOfertable(usuario) && producto.esGustoPreferido(usuario)) {
                    System.out.println(producto);
                    //	Scanner
                    usuario.comprar(producto);
                }

                System.out.println(
                        "--------------------------------------------------------------------------------------------------------");
            } while (productoIterator.hasNext());

            productoIterator.reset();

            do {
                Producto producto = productoIterator.next();
                if (producto.esOfertable(usuario) && !producto.esGustoPreferido(usuario)) {
                    System.out.println(producto);
                    //	Scanner
                    usuario.comprar(producto);
                }

                System.out.println(
                        "--------------------------------------------------------------------------------------------------------");
            } while (productoIterator.hasNext());

            resumenCompraDeUsuarios.put(usuario.getNombre(), usuario.getCompras());
        }

        System.out.println(
                "\n\n----------------------------\t\t\t\t\t¡Vuelvan pronto!\t\t\t\t----------------------------\n\n");
    }

	/*	TODO
		--------------------------------------------------------------------------------------------
		1.	Agregar interacción compra o no compra con el Scanner comentado.
		2.	Arreglar y/o revisar unit tests. xD
		3.	Revisar set de Datos.
		4.	Llevar lógica del main a ofertador.
		5.	Pruebas unitarias de ofertador, resumenCompras y constructores de paquete y atracciones.
		6.	Actualizar diagramas de clase
		7.	Grabar video
	 */
}
