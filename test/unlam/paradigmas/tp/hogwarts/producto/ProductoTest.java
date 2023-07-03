package unlam.paradigmas.tp.hogwarts.producto;

import org.junit.Assert;
import org.junit.Test;
import unlam.paradigmas.tp.hogwarts.dto.Atraccion;
import unlam.paradigmas.tp.hogwarts.dto.Producto;
import unlam.paradigmas.tp.hogwarts.dto.Promocion;
import unlam.paradigmas.tp.hogwarts.dto.Usuario;
import unlam.paradigmas.tp.hogwarts.servicio.ProductoComparator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProductoTest {

    @Test
    public void CompareListaOrdenada() {

        Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 70.0, 10, 60.0);
        Atraccion atraccion2 = new Atraccion("Atracción 2", "Tipo 2", 15.0, 15, 60.0);
        Atraccion atraccion3 = new Atraccion("Atracción 3", "Tipo 3", 15.0, 5, 20.0);

        Atraccion atraccionMasCara = new Atraccion("atraccion 4", "Tipo 7", 1000.0, 5, 30.0);
        Atraccion atraccionSegundaMayorTiempo = new Atraccion("atraccion 6", "Tipo 8", 500.0, 5, 15.0);
        Atraccion atraccionTerceraMenorTiempo = new Atraccion("atraccion 7", "Tipo 7", 500.0, 5, 10.0);

        List<Atraccion> atraccion = new ArrayList<>();
        atraccion.add(atraccion1);
        Promocion promocionMasCara = new Promocion(atraccion, "aventura");

        List<Atraccion> atraccionSegunda = new ArrayList<>();
        atraccion.add(atraccion2);
        Promocion promocionSegundoConMayorTiempo = new Promocion(atraccionSegunda, "aventura");

        List<Atraccion> atraccionTercera = new ArrayList<>();
        atraccion.add(atraccion3);
        Promocion promocionTerceroConMenorTiempo = new Promocion(atraccionTercera, "aventura");

        List<Promocion> listaDePromociones = new ArrayList<>();
        listaDePromociones.add(promocionMasCara);
        listaDePromociones.add(promocionSegundoConMayorTiempo);
        listaDePromociones.add(promocionTerceroConMenorTiempo);

        List<Producto> atraccionesOrdenados = new LinkedList<>();
        atraccionesOrdenados.add(atraccionMasCara);
        atraccionesOrdenados.add(atraccionSegundaMayorTiempo);
        atraccionesOrdenados.add(atraccionTerceraMenorTiempo);

        List<Producto> listaEsperado = new LinkedList<>();
        listaEsperado.addAll(listaDePromociones);
        listaEsperado.addAll(atraccionesOrdenados);

        List<Producto> listaNoOrdenada = new LinkedList<>();
        listaEsperado.add(promocionTerceroConMenorTiempo);
        listaEsperado.add(promocionMasCara);
        listaEsperado.add(atraccionMasCara);
        listaEsperado.add(atraccionSegundaMayorTiempo);
        listaEsperado.add(promocionSegundoConMayorTiempo);
        listaEsperado.add(atraccionTerceraMenorTiempo);

        listaNoOrdenada.sort(new ProductoComparator());

        int i = 0;
        for (Producto productos : listaNoOrdenada) {
            Assert.assertEquals(productos, listaEsperado.get(i));
            i++;
        }
    }

    @Test
    public void atraccionContieneAtraccionTest() {

        Atraccion atraccion1 = new Atraccion("Atracción ", "Tipo 1", 15.0, 10, 60.0);
        Atraccion atraccion2 = new Atraccion("Atracción ", "Tipo 1", 15.0, 15, 60.0);
        Atraccion atraccion3 = new Atraccion("Atracción 3", "Tipo 2", 5.0, 5, 20.0);

        Assert.assertTrue(atraccion1.contiene(atraccion2));
        Assert.assertFalse(atraccion1.contiene(atraccion3));

    }

    @Test
    public void PromocionContienePromocionTest() {

        Atraccion atraccion1 = new Atraccion("Atracción ", "Tipo 1", 15.0, 10, 60.0);
        Atraccion atraccion3 = new Atraccion("Atracción 3", "Tipo 2", 5.0, 5, 20.0);

        List<Atraccion> atracciones = new ArrayList<>();
        atracciones.add(atraccion1);
        atracciones.add(atraccion3);

        Promocion promocion = new Promocion(atracciones, "Aventura");

        Assert.assertTrue(promocion.contiene(promocion));

    }

    @Test
    public void PromocionContieneAtraccionTest() {
        Atraccion atraccion1 = new Atraccion("Atracción ", "Tipo 1", 15.0, 10, 60.0);
        Atraccion atraccion3 = new Atraccion("Atracción 3", "Tipo 2", 5.0, 5, 20.0);
        Atraccion atraccion4 = new Atraccion("Atracción 4", "Tipo 4", 6.0, 10, 25.0);

        List<Atraccion> atracciones = new ArrayList<>();
        atracciones.add(atraccion1);
        atracciones.add(atraccion3);

        Promocion promocion = new Promocion(atracciones, "Aventura");

        Assert.assertTrue(promocion.contiene(atraccion1));
        Assert.assertTrue(promocion.contiene(atraccion3));
        Assert.assertFalse(promocion.contiene(atraccion4));
    }

    @Test
    public void esOfertableTest() {

        Usuario usuario = new Usuario("carlos", "aventura", 30, 40);
        Atraccion atraccion1 = new Atraccion("Atracción 1", "aventura", 15.0, 10, 40.0);// es ofertable
        Atraccion atraccion2 = new Atraccion("Atracción 2", "aventura", 15.0, 15, 60.0);// no es ofertable por tiempo
        Atraccion atraccion3 = new Atraccion("Atracción 3", "accion", 30.1, 30, 20.0);// no es ofertable por precio
        Atraccion atraccion4 = new Atraccion("Atracción 4", "accion", 5.0, 0, 20.0);// no es ofertable por cupo


        Assert.assertTrue(atraccion1.esOfertable(usuario));
        Assert.assertFalse(atraccion2.esOfertable(usuario));
        Assert.assertFalse(atraccion3.esOfertable(usuario));
        Assert.assertFalse(atraccion4.esOfertable(usuario));
    }

    @Test
    public void verificarCuposDespuesComprarAtraccion() {

        Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 15.0, 10, 40.0);
        int cuposEsperado = 9;


        atraccion1.comprar();

        Assert.assertEquals(cuposEsperado, atraccion1.getCupo());
    }

    @Test
    public void comprarAtraccionSinCupo() {

        Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 15.0, 0, 40.0);
        int cuposEsperado = 0;

        boolean noCompra = atraccion1.comprar();

        Assert.assertFalse(noCompra);
        Assert.assertEquals(cuposEsperado, atraccion1.getCupo());
    }

    @Test
    public void compraPromocionYActualizaAtracciones() {

        Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 15.0, 10, 60.0);
        Atraccion atraccion2 = new Atraccion("Atracción 3", "Tipo 2", 5.0, 5, 20.0);

        List<Atraccion> atracciones = new ArrayList<>();
        atracciones.add(atraccion1);
        atracciones.add(atraccion2);

        Promocion promocion = new Promocion(atracciones, "Aventura");
        atracciones = promocion.getAtracciones();
        Queue<Integer> cuposEsperados = new LinkedList<>();
        cuposEsperados.offer(9);
        cuposEsperados.offer(4);

        promocion.comprar();

        for (Atraccion atraccion : atracciones) {
            Assert.assertEquals((int) cuposEsperados.poll(), atraccion.getCupo());
        }
    }

    @Test
    public void comprarPromocionQueUnAtraccionNoTieneCupo() {

        Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 15.0, 10, 60.0);
        Atraccion atraccion2 = new Atraccion("Atracción 2", "Tipo 1", 15.0, 0, 60.0);

        List<Atraccion> atracciones = new ArrayList<>();
        atracciones.add(atraccion1);
        atracciones.add(atraccion2);
        Promocion promocion = new Promocion(atracciones, "Aventura");
        boolean accionEsperado;

        accionEsperado = promocion.comprar();

        Assert.assertFalse(accionEsperado);
    }
}
