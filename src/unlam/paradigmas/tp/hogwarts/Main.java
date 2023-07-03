package unlam.paradigmas.tp.hogwarts;


import unlam.paradigmas.tp.hogwarts.dto.Producto;
import unlam.paradigmas.tp.hogwarts.dto.Usuario;
import unlam.paradigmas.tp.hogwarts.servicio.Ofertador;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static unlam.paradigmas.tp.hogwarts.servicio.Archivo.*;

public class Main {

    public static void main(String[] args) {
        try {
            LinkedList<Producto> productos = armarProductos();
            List<Usuario> usuarios = lecturaDeUsuarios();

            Ofertador ofertador = new Ofertador(productos);
            ofertador.ofertarParaUsuarios(usuarios);

            generarArchivoSalida(usuarios);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
