package unlam.paradigmas.tp.tierramedia;

import unlam.paradigmas.tp.tierramedia.dto.Atraccion;
import unlam.paradigmas.tp.tierramedia.dto.Usuario;
import unlam.paradigmas.tp.tierramedia.servicio.Archivo;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final String RUTA_ARCHIVO_USUARIOS = "archivos/usuarios.csv";
    private static final String RUTA_ARCHIVO_ATRACCIONES = "archivos/atracciones.csv";
    private static final String RUTA_ARCHIVO_PROMOIONES = "archivos/promociones.csv";

    public static void main(String[] args) {
        System.out.println("\n\n----------------------------\t\tBienvenido a la Tierra Media\t\t----------------------------");

        try {
            List<Usuario> listaDeUsuarios = Archivo.lecturaDeUsuarios(RUTA_ARCHIVO_USUARIOS);
            List<Atraccion> listaDeAtracciones = Archivo.lecturaDeAtracciones(RUTA_ARCHIVO_ATRACCIONES);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n\n----------------------------\tTierra Media le desea un lindo paseo!\t----------------------------\n\n");
    }
}
