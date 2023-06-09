package unlam.paradigmas.tp.hogwarts;

import org.junit.Assert;
import org.junit.Test;
import unlam.paradigmas.tp.hogwarts.dto.Usuario;
import unlam.paradigmas.tp.hogwarts.servicio.Archivo;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class ArchivosInputTests {
	private static final String RUTA_ARCHIVO_USUARIOS = "archivos/preferencias_usuarios.csv";
	private static final String RUTA_ARCHIVO_ATRACCIONES = "archivos/atracciones.csv";
	private static final String RUTA_ARCHIVO_PROMOIONES = "archivos/promociones.csv";

	@Test
	public void testLecturaUsuarios() throws IOException {
		Queue<Usuario> usuariosEsperados = new LinkedList<>();
		usuariosEsperados.add(new Usuario("Florencia", "Aventura", Float.parseFloat("10.00"), 5));
		usuariosEsperados.add(new Usuario("Victor", "Espectaculos", Float.parseFloat("15.00"), 9));
		usuariosEsperados.add(new Usuario("Alexis", "Aventura", Float.parseFloat("20.00"), 4));
		usuariosEsperados.add(new Usuario("Sebastian", "Experiencia", Float.parseFloat("19.00"), 10));
		usuariosEsperados.add(new Usuario("Juan Manuel", "Espectaculos", Float.parseFloat("100.00"), 12));
		usuariosEsperados.add(new Usuario("Isaias", "Gastronomia", Float.parseFloat("1.00"), 10));

		Queue<Usuario> usuariosObtenidos = Archivo.lecturaDeUsuarios(RUTA_ARCHIVO_USUARIOS);

		Assert.assertEquals(usuariosEsperados, usuariosObtenidos);
	}

	@Test(expected = IOException.class)
	public void testLecturaUsuariosSinRuta() throws IOException {
		Queue<Usuario> usuarios = Archivo.lecturaDeUsuarios("RUTA INEXISTENTE");
	}
}
