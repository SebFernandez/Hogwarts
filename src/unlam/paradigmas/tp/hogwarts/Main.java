package unlam.paradigmas.tp.hogwarts;


import unlam.paradigmas.tp.hogwarts.dto.Producto;
import unlam.paradigmas.tp.hogwarts.dto.Usuario;
import unlam.paradigmas.tp.hogwarts.servicio.Ofertador;

import java.io.IOException;

import java.util.List;


import java.util.LinkedList;

import static unlam.paradigmas.tp.hogwarts.servicio.Archivo.*;

public class Main {
    // TODO: mandar para Archivo
    private static final String RUTA_ARCHIVO_USUARIOS = "Archivos/preferencias_usuarios.csv";
    private static final String RUTA_ARCHIVO_ATRACCIONES = "Archivos/Atracciones.csv";
    private static final String RUTA_ARCHIVO_PROMOCIONES = "Archivos/paquetes_a_ofrecer.csv";
    private static final String RUTA_ARCHIVO_SALIDA = "Archivos/resumen_compra_usuarios.out";

    public static void main(String[] args) {
        try {
            LinkedList<Producto> productos = armarProductos(RUTA_ARCHIVO_ATRACCIONES, RUTA_ARCHIVO_PROMOCIONES);
            List<Usuario> usuarios = lecturaDeUsuarios(RUTA_ARCHIVO_USUARIOS);

            Ofertador ofertador = new Ofertador(productos);
            ofertador.ofertarParaUsuarios(usuarios);

            generarArchivoSalida(RUTA_ARCHIVO_SALIDA,usuarios);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
