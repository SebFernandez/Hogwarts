package unlam.paradigmas.tp.hogwarts;

import org.junit.Assert;
import org.junit.Test;
import unlam.paradigmas.tp.hogwarts.dto.Usuario;
import unlam.paradigmas.tp.hogwarts.servicio.Archivo;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class ArchivosInputTests {
	private static final String RUTA_ARCHIVO_USUARIOS = "Archivos/preferencias_usuarios.csv";
	private static final String RUTA_ARCHIVO_ATRACCIONES = "Archivos/atracciones.csv";
	private static final String RUTA_ARCHIVO_PROMOIONES = "Archivos/promociones.csv";

	@Test
	public void testLecturaUsuarios() throws IOException {
		Queue<Usuario> usuariosEsperados = new LinkedList<>();
		usuariosEsperados.add(new Usuario("Florencia", "Aventura", Float.parseFloat("500.00"), 500));
		usuariosEsperados.add(new Usuario("Victor", "Espectaculos", Float.parseFloat("505.00"), 96));
		usuariosEsperados.add(new Usuario("Alexis", "Aventura", Float.parseFloat("368.00"), 48));
		usuariosEsperados.add(new Usuario("Sebastian", "Experiencia", Float.parseFloat("879.00"), 100));
		usuariosEsperados.add(new Usuario("Juan Manuel", "Espectaculos", Float.parseFloat("1000.00"), 1234));
		usuariosEsperados.add(new Usuario("Isaias", "Gastronomia", Float.parseFloat("5000.00"), 1098));

		Queue<Usuario> usuariosObtenidos = Archivo.lecturaDeUsuarios(RUTA_ARCHIVO_USUARIOS);

		Assert.assertEquals(usuariosEsperados, usuariosObtenidos);
	}

	@Test(expected = IOException.class)
	public void testLecturaUsuariosSinRuta() throws IOException {
		Queue<Usuario> usuarios = Archivo.lecturaDeUsuarios("RUTA INEXISTENTE");
	}
}
