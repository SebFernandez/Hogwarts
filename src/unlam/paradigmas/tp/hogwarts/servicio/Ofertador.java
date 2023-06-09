package unlam.paradigmas.tp.hogwarts.servicio;

import unlam.paradigmas.tp.hogwarts.dto.Producto;
import unlam.paradigmas.tp.hogwarts.dto.Usuario;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Ofertador {
    private final LinkedList<Producto> productos;
    private Usuario usuario;

    public Ofertador(LinkedList<Producto> productos) {
        this.productos = productos;
    }

    private char ofrecerSugerencia() {
        Scanner scanner = new Scanner(System.in);
        char opc;
        do {
            System.out.println("¿Acepta Sugerencia? Ingrese S o N");
            opc = scanner.next().toUpperCase().charAt(0);
        } while (opc != 'S' && opc != 'N');
        return opc;
    }

    private void ofertaGustoUsuario() {
        for (Producto producto : productos) {
            if (producto.esOfertable(usuario) && producto.esGustoPreferido(usuario)) {
                System.out.println(producto);
                if (ofrecerSugerencia() == 'S')
                    usuario.comprar(producto);
            }
        }
    }

    private void ofertaNoGustoUsuario() {
        for (Producto producto : productos) {
            if (producto.esOfertable(usuario) && !producto.esGustoPreferido(usuario)) {
                System.out.println(producto);
                if (ofrecerSugerencia() == 'S')
                    usuario.comprar(producto);
            }
        }
    }

    private void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void ofertarParaUsuarios(List<Usuario> usuarios) {
        printBienvenida();
        for (Usuario usuario : usuarios) {
            setUsuario(usuario);
            System.out.println("Nombre de Usuario: " + usuario.getNombre());
            System.out.println("gusto:" + usuario.getGusto());
            ofertaGustoUsuario();
            ofertaNoGustoUsuario();
        }
        printDespedida();
    }

    private void printBienvenida() {
        System.out.println("\t\tBienvenido/a a Hogwarts");
        System.out.println("--------------------------------------------------------------------------------");
    }

    private void printDespedida() {
        System.out.println(
                "\n\n----------------------------\t\t\t\t\t¡Vuelvan pronto!\t\t\t\t----------------------------\n\n");
    }
}
