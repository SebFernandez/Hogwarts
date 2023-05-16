package unlam.paradigmas.tp.tierramedia;

import org.junit.Test;
import org.junit.Assert;
import unlam.paradigmas.tp.tierramedia.dto.Atraccion;
import unlam.paradigmas.tp.tierramedia.dto.Usuario;
import unlam.paradigmas.tp.tierramedia.servicio.Archivo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArchivosInputTests {
    private static final String RUTA_ARCHIVO_USUARIOS = "archivos/usuarios.csv";
    private static final String RUTA_ARCHIVO_ATRACCIONES = "archivos/atracciones.csv";
    private static final String RUTA_ARCHIVO_PROMOIONES = "archivos/promociones.csv";

    @Test
    public void testLecturaUsuarios() throws IOException {
        List<Usuario> usuariosEsperados = new ArrayList<>();
        usuariosEsperados.add(new Usuario("seba", "natural", Float.parseFloat("1000.04"), 5));

        List<Usuario> usuariosObtenidos = Archivo.lecturaDeUsuarios(RUTA_ARCHIVO_USUARIOS);

        Assert.assertEquals(usuariosEsperados, usuariosObtenidos);
    }

    @Test
    public void testLecturaAtracciones () throws IOException    {
        List<Atraccion> atraccionesEsperadas = new ArrayList<>();
        atraccionesEsperadas.add(new Atraccion("Palomar", 5));

        List<Atraccion> atraccionesObtenidas = Archivo.lecturaDeAtracciones(RUTA_ARCHIVO_ATRACCIONES);

        Assert.assertEquals(atraccionesEsperadas, atraccionesObtenidas);
    }

}
