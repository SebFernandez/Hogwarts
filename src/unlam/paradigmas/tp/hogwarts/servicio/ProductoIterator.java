package unlam.paradigmas.tp.hogwarts.servicio;

import unlam.paradigmas.tp.hogwarts.dto.Producto;
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
    }

    public void reset() {
        this.indice = 0;
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
        Producto producto;

        producto = productos.get(indice);
        indice++;

        return producto;

    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
