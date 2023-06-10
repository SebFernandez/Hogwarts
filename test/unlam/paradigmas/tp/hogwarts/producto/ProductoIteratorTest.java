package unlam.paradigmas.tp.hogwarts.producto;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;

import unlam.paradigmas.tp.hogwarts.dto.*;

public class ProductoIteratorTest {

	@Test
	public void iteratorTestUsuarioSinComprar() {
		Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 10.0, 100, 60.0); // se oferta
        Atraccion atraccion2 = new Atraccion("Atracción 2", "Tipo 2", 15.0, 50, 90.0); // no se oferta por tiempo
        Atraccion atraccion3 = new Atraccion("Atracción 3", "Tipo 1", 20.0, 5, 120.0); // no se oferta dinero
        Atraccion atraccion4 = new Atraccion("Atracción 4", "Tipo 3", 12.0, 0, 75.0); // no se oferta por cupo
        Atraccion atraccion5 = new Atraccion("Atracción 5", "Tipo 2", 15.0, 60, 79.0); // se oferta

        List<Atraccion> atraccionesPromocion = new ArrayList<>();
        atraccionesPromocion.add(atraccion1);
        Promocion promocion1 = new Promocion(atraccionesPromocion);

        List<Producto> productos = new ArrayList<>();
        productos.add(atraccion1);
        productos.add(atraccion2);
        productos.add(atraccion3);
        productos.add(atraccion4);
        productos.add(atraccion5);
        productos.add(promocion1);

        Queue<Producto> colaEsperados = new LinkedList<>();
        colaEsperados.offer(atraccion1);
        colaEsperados.offer(atraccion5);
        colaEsperados.offer(promocion1);

        Usuario usuario = new Usuario("Juan", "Tipo 1",16,80);

        Iterator<Producto> productosIt= new ProductoIterator(productos, usuario);
        while (productosIt.hasNext()) {
			Producto producto = (Producto) productosIt.next();
			Assert.assertTrue(producto.equals(colaEsperados.poll()));
		}
        Assert.assertTrue(colaEsperados.isEmpty());
	}

	@Test
	public void iteratorTestUsuarioConCompra() {
		Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 10.0, 10, 60.0); // se oferta y se compra
		Atraccion atraccion2 = new Atraccion("Atracción 2", "Tipo 1", 15.0, 15, 120.0); // no se oferta  por dinero restante
        Atraccion atraccion3 = new Atraccion("Atracción 3", "Tipo 2", 5.0, 5, 20.0); // se oferta

        List<Atraccion> atraccionesPromocion = new ArrayList<>();
        atraccionesPromocion.add(atraccion1); // no se oferta
        Promocion promocion1 = new Promocion(atraccionesPromocion);

        List<Producto> productos = new ArrayList<>();
        productos.add(atraccion1);
        productos.add(atraccion2);
        productos.add(atraccion3);
        productos.add(promocion1);

        Queue<Producto> colaEsperados = new LinkedList<>();
        colaEsperados.offer(atraccion1);
        colaEsperados.offer(atraccion3);

        Usuario usuario = new Usuario("Juan", "Tipo 1",16,800);

        Iterator<Producto> productosIt = new ProductoIterator(productos, usuario);
		Producto producto;

        while (productosIt.hasNext()) {
        	producto = productosIt.next();
			usuario.comprar(producto);
            Assert.assertEquals(producto, colaEsperados.poll());
		}

        Assert.assertTrue (colaEsperados.isEmpty());
	}
}
