package unlam.paradigmas.tp.hogwarts.servicio;

import unlam.paradigmas.tp.hogwarts.dto.Producto;
import unlam.paradigmas.tp.hogwarts.dto.Usuario;

import java.util.Scanner;

public class Ofertador {
    private final Scanner scanner = new Scanner(System.in);
    private final ProductoIterator productoIterator;
    private final Usuario usuario;
    private char opc;

    public Ofertador(Usuario usuario, ProductoIterator productoIterator) {
        this.productoIterator = productoIterator;
        this.usuario = usuario;
    }

    public void reiniciarIterador() {
        this.productoIterator.reset();
    }

    private char ofrecerSugerencia() {
        do {
            System.out.println("¿Acepta Sugerencia? Ingrese S o N");
            opc = scanner.next().toUpperCase().charAt(0);
        } while (opc != 'S' && opc != 'N');
        return this.opc;
    }

    public void ofertaGustoUsuario() {
        while (productoIterator.hasNext()) {
            Producto producto = productoIterator.next();
            if (producto.esOfertable(usuario) && producto.esGustoPreferido(usuario)) {
                System.out.println(producto);
                opc = ofrecerSugerencia();
                if (opc == 'S')
                    usuario.comprar(producto);
            }
        }
    }

    public void ofertaNoGustoUsuario() {
        while (productoIterator.hasNext()) {
            Producto producto = productoIterator.next();
            if (producto.esOfertable(usuario) && !producto.esGustoPreferido(usuario)) {
                System.out.println(producto);
                opc = ofrecerSugerencia();
                if (opc == 'S')
                    usuario.comprar(producto);
            }
        }
    }
}
