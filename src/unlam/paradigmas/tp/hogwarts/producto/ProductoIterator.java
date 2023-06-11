package unlam.paradigmas.tp.hogwarts.producto;

import unlam.paradigmas.tp.hogwarts.dto.Usuario;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductoIterator implements Iterator<Producto> {
    private final List<Producto> productos;
    private int indice;

    public ProductoIterator(List<Producto> productos, Usuario usuario) {
        this.productos = productos;
        this.indice = 0;

        while (indice < productos.size() && !productos.get(indice).esOfertable(usuario))
            indice++;
    }

    @Override
    public boolean hasNext() {
        return indice < productos.size();
    }

    @Override
    public Producto next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        Producto producto = productos.get(indice);
        indice++;

        return producto;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
