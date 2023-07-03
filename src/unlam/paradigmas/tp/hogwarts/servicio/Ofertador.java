package unlam.paradigmas.tp.hogwarts.servicio;

import unlam.paradigmas.tp.hogwarts.dto.Producto;
import unlam.paradigmas.tp.hogwarts.dto.Usuario;
import java.util.LinkedList;
import java.util.Scanner;

public class Ofertador {
    private final Scanner scanner = new Scanner(System.in);
    private final LinkedList<Producto> productos;
    private final Usuario usuario;

    public Ofertador(Usuario usuario, LinkedList<Producto> productos) {
        this.productos = productos;
        this.usuario = usuario;
    }

    private char ofrecerSugerencia() {
        char opc;
        do {
            System.out.println("¿Acepta Sugerencia? Ingrese S o N");
            opc = scanner.next().toUpperCase().charAt(0);
        } while (opc != 'S' && opc != 'N');
        return opc;
    }

    public void ofertaGustoUsuario() {
        for (Producto producto : productos ) {
            if (producto.esOfertable(usuario) && producto.esGustoPreferido(usuario)) {
                System.out.println(producto);
                if (ofrecerSugerencia() == 'S')
                    usuario.comprar(producto);
            }
        }
    }

    public void ofertaNoGustoUsuario() {
        for (Producto producto : productos) {
            if (producto.esOfertable(usuario) && !producto.esGustoPreferido(usuario)) {
                System.out.println(producto);
                if (ofrecerSugerencia() == 'S')
                    usuario.comprar(producto);
            }
        }
    }
}
