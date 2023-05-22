package unlam.paradigmas.tp.hogwarts;

import unlam.paradigmas.tp.hogwarts.dto.Atraccion;
import unlam.paradigmas.tp.hogwarts.dto.Usuario;

import java.io.IOException;
import java.util.List;

import static unlam.paradigmas.tp.hogwarts.servicio.Archivo.lecturaDeAtracciones;
import static unlam.paradigmas.tp.hogwarts.servicio.Archivo.lecturaDeUsuarios;

public class Main {
    private static final String RUTA_ARCHIVO_USUARIOS = "archivos/usuarios.csv";
    private static final String RUTA_ARCHIVO_ATRACCIONES = "archivos/atracciones.csv";
    private static final String RUTA_ARCHIVO_PROMOIONES = "archivos/promociones.csv";

    public static void main(String[] args) {
        System.out.println("\n\n----------------------------\t\tBienvenido a la Tierra Media\t\t----------------------------");

        try {
            List<Usuario> listaDeUsuarios = lecturaDeUsuarios(RUTA_ARCHIVO_USUARIOS);
            List<Atraccion> listaDeAtracciones = lecturaDeAtracciones(RUTA_ARCHIVO_ATRACCIONES);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n\n----------------------------\tTierra Media le desea un lindo paseo!\t----------------------------\n\n");
    }
}
