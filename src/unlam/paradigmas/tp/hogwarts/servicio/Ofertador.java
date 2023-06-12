package unlam.paradigmas.tp.hogwarts.servicio;

import unlam.paradigmas.tp.hogwarts.dto.Producto;
import unlam.paradigmas.tp.hogwarts.dto.Usuario;

import java.util.List;

public class Ofertador {
    public ProductoIterator productos;
    private Usuario usuario;

    public Ofertador(Usuario usuario, List<Producto> producto) {
        this.productos = new ProductoIterator(producto, usuario);
        this.usuario = usuario;
    }

    public Producto ofertaParaUsuario(Usuario user) {
        Producto producto = null;


        return producto;
    }
}
