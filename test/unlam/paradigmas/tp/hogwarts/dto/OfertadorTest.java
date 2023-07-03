/*
package unlam.paradigmas.tp.hogwarts.dto;

import org.junit.Assert;
import org.junit.Test;
import unlam.paradigmas.tp.hogwarts.servicio.ProductoComparator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class OfertadorTest {

    @Test
    public void ofertarAtraccionesPorGusto() {

        Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 10.0, 100, 60.0); // se oferta
        Atraccion atraccion2 = new Atraccion("Atracción 2", "Tipo 1", 15.0, 50, 90.0); // no se oferta por tiempo
        Atraccion atraccion3 = new Atraccion("Atracción 3", "Tipo 1", 20.0, 5, 120.0); // no se oferta dinero
        Atraccion atraccion4 = new Atraccion("Atracción 4", "Tipo 3", 12.0, 0, 75.0); // no se oferta por cupo
        Atraccion atraccion5 = new Atraccion("Atracción 5", "Tipo 2", 15.0, 60, 79.0); // se oferta

        Queue<Producto> atraccionesOfertadasEsperados = new LinkedList<>();
        atraccionesOfertadasEsperados.add(atraccion1);
        atraccionesOfertadasEsperados.add(atraccion2);
        atraccionesOfertadasEsperados.add(atraccion3);

        List<Producto> productos = new ArrayList<>();
        productos.add(atraccion1);
        productos.add(atraccion2);
        productos.add(atraccion3);
        productos.add(atraccion4);
        productos.add(atraccion5);

        Usuario usuario = new Usuario("Juan", "Tipo 1", 1600, 800);

        ProductoIterator productosIt = new ProductoIterator(productos, usuario);

        while (productosIt.hasNext()) {
            Producto producto = productosIt.next();
            if (producto.esOfertable(usuario) && producto.esGustoPreferido(usuario)) {
                assertEquals(producto, atraccionesOfertadasEsperados.poll());
            }
        }

    }

    @Test
    public void ofertarAtraccionesQueNoSeanDeSuGusto() {

        Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 10.0, 100, 60.0); // se oferta
        Atraccion atraccion2 = new Atraccion("Atracción 2", "Tipo 1", 15.0, 50, 90.0); // no se oferta por tiempo
        Atraccion atraccion3 = new Atraccion("Atracción 3", "Tipo 1", 20.0, 5, 120.0); // no se oferta dinero
        Atraccion atraccion4 = new Atraccion("Atracción 4", "Tipo 3", 12.0, 3, 75.0); // no se oferta por cupo
        Atraccion atraccion5 = new Atraccion("Atracción 5", "Tipo 2", 15.0, 60, 79.0); // se oferta

        Queue<Producto> atraccionesOfertadasEsperado = new LinkedList<>();
        atraccionesOfertadasEsperado.add(atraccion4);
        atraccionesOfertadasEsperado.add(atraccion5);

        List<Producto> productos = new ArrayList<>();
        productos.add(atraccion1);
        productos.add(atraccion2);
        productos.add(atraccion3);
        productos.add(atraccion4);
        productos.add(atraccion5);

        Usuario usuario = new Usuario("Juan", "Tipo 1", 16, 80);

        ProductoIterator productosIt = new ProductoIterator(productos, usuario);

        while (productosIt.hasNext()) {
            Producto producto = productosIt.next();
            if (producto.esOfertable(usuario) && !producto.esGustoPreferido(usuario)) {
                assertEquals(producto, atraccionesOfertadasEsperado.poll());
            }
        }

    }

    @Test
    public void ofertarPrimeroPromoQueNoSeanDeSuPrefYluegoAtracQueNoSeanDeSuPrefe() {
        Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 10.0, 100, 60.0); // se oferta ultimo
        Atraccion atraccion2 = new Atraccion("Atracción 2", "Tipo 1", 15.0, 50, 90.0); // se oferta tercero
        Atraccion atraccion3 = new Atraccion("Atracción 3", "Tipo 1", 20.0, 5, 120.0); // se oferta primero

        //son todos del mismo tipo

        List<Atraccion> atraccionesPromocion = new ArrayList<>();
        atraccionesPromocion.add(atraccion1);
        atraccionesPromocion.add(atraccion2);
        Promocion promocion1 = new Promocion(atraccionesPromocion, "Tipo 1");

        List<Producto> productos = new ArrayList<>();
        productos.add(atraccion1);
        productos.add(atraccion2);
        productos.add(atraccion3);
        productos.add(promocion1);

        ProductoComparator comparator = new ProductoComparator();
        productos.sort(comparator);///con esto ordenamos primero por promocion y despues con atraccion

        Queue<Producto> colaEsperados = new LinkedList<>();
        colaEsperados.offer(promocion1);///se oferta primero la promocion
        colaEsperados.offer(atraccion3);///segundo atraccion mas cara
        colaEsperados.offer(atraccion2);///tercero atraccion
        colaEsperados.offer(atraccion1);///cuarto

        Usuario usuario = new Usuario("Juan", "Tipo 2", 100, 200);

        Iterator<Producto> productosIt = new ProductoIterator(productos, usuario);

        while (productosIt.hasNext()) {
            Producto producto = productosIt.next();
            if (!producto.esGustoPreferido(usuario)) {///juan gusto tipo 2 y atracciones
                assertEquals(producto, colaEsperados.poll());
            }
        }
        Assert.assertTrue(colaEsperados.isEmpty());
    }

    @Test
    public void ofertarPrimeroPromoDeSuGustoYDespuesAtracDeSuGusto() {
        Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 10.0, 100, 60.0); // se oferta ultimo
        Atraccion atraccion2 = new Atraccion("Atracción 2", "Tipo 1", 15.0, 50, 90.0); // se oferta tercero
        Atraccion atraccion3 = new Atraccion("Atracción 3", "Tipo 1", 20.0, 5, 120.0); // se oferta primero
        Atraccion atraccion4 = new Atraccion("Atracción 4", "Tipo 1", 12.0, 4, 75.0); // se oferta cuarto
        Atraccion atraccion5 = new Atraccion("Atracción 5", "Tipo 1", 15.0, 60, 79.0); // se oferta segundo
        //son todos del mismo tipo

        List<Atraccion> atraccionesPromocion = new ArrayList<>();
        atraccionesPromocion.add(atraccion1);
        atraccionesPromocion.add(atraccion2);
        Promocion promocion1 = new Promocion(atraccionesPromocion, "Tipo 1");

        List<Producto> productos = new ArrayList<>();
        productos.add(atraccion1);
        productos.add(atraccion2);
        productos.add(atraccion3);
        productos.add(atraccion4);
        productos.add(atraccion5);
        productos.add(promocion1);

        ProductoComparator comparator = new ProductoComparator();
        productos.sort(comparator);///con esto ordenamos primero por promocion y despues con atraccion

        Queue<Producto> colaEsperados = new LinkedList<>();
        colaEsperados.offer(promocion1);///se oferta primero la promocion
        colaEsperados.offer(atraccion3);///segundo atraccion mas cara
        colaEsperados.offer(atraccion2);///tercero atraccion
        colaEsperados.offer(atraccion5);///cuarto
        colaEsperados.offer(atraccion4);///quinto
        colaEsperados.offer(atraccion1);///sexto

        Usuario usuario = new Usuario("Juan", "Tipo 1", 100, 200);
        ///son todos de tipo 1 y el usuario tiene prefernecia de tipo 2
        Iterator<Producto> productosIt = new ProductoIterator(productos, usuario);
        while (productosIt.hasNext()) {
            Producto producto = productosIt.next();
            if (producto.esGustoPreferido(usuario)) {
                assertEquals(producto, colaEsperados.poll());
            }

        }
        Assert.assertTrue(colaEsperados.isEmpty());
    }
}
*/
