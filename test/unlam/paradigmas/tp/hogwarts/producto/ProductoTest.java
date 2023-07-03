package unlam.paradigmas.tp.hogwarts.producto;

import org.junit.Assert;
import org.junit.Test;
import unlam.paradigmas.tp.hogwarts.dto.Atraccion;
import unlam.paradigmas.tp.hogwarts.dto.Producto;
import unlam.paradigmas.tp.hogwarts.dto.Promocion;
import unlam.paradigmas.tp.hogwarts.dto.Usuario;
import unlam.paradigmas.tp.hogwarts.servicio.ProductoComparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ProductoTest {

	@Test
	public void CompareListaOrdenada(){

		//arrange
		Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 70.0, 10, 60.0);
		Atraccion atraccion2 = new Atraccion("Atracción 2", "Tipo 2", 15.0, 15, 60.0);
		Atraccion atraccion3 = new Atraccion("Atracción 3", "Tipo 3", 15.0, 5, 20.0);

		Atraccion atraccionMasCara = new Atraccion("atraccion 4","Tipo 7",1000.0,5,30.0);//atraccion mas cara
		Atraccion atraccionSegundaMayorTiempo = new Atraccion("atraccion 6","Tipo 8",500.0,5,15.0);//atraccion mayor tiempor
		Atraccion atraccionTerceraMenorTiempo = new Atraccion("atraccion 7","Tipo 7",500.0,5,10.0);

		///creo las promociones
		List<Atraccion> atraccion = new ArrayList<>();
		atraccion.add(atraccion1);
		Promocion promocionMasCara = new Promocion(atraccion,"aventura");

		List<Atraccion> atraccionSegunda = new ArrayList<>();
		atraccion.add(atraccion2);
		Promocion promocionSegundoConMayorTiempo = new Promocion(atraccionSegunda,"aventura");

		List<Atraccion> atraccionTercera = new ArrayList<>();
		atraccion.add(atraccion3);
		Promocion promocionTerceroConMenorTiempo = new Promocion(atraccionTercera,"aventura");

		///creo la lista de promociones
		List<Promocion> listaDePromociones = new ArrayList<>();
		listaDePromociones.add(promocionMasCara);
		listaDePromociones.add(promocionSegundoConMayorTiempo);
		listaDePromociones.add(promocionTerceroConMenorTiempo);

		///creo el map de atracciones ///es alpedo esto
		List<Producto> atraccionesOrdenados = new LinkedList<>();
		atraccionesOrdenados.add(atraccionMasCara);
		atraccionesOrdenados.add(atraccionSegundaMayorTiempo);
		atraccionesOrdenados.add(atraccionTerceraMenorTiempo);

		///lista ordenada
		List<Producto> listaEsperado = new LinkedList<>();
		listaEsperado.addAll(listaDePromociones);
		listaEsperado.addAll(atraccionesOrdenados);

		///lista no ordenada
		List<Producto> listaNoOrdenada = new LinkedList<>();
		listaEsperado.add(promocionTerceroConMenorTiempo);
		listaEsperado.add(promocionMasCara);
		listaEsperado.add(atraccionMasCara);
		listaEsperado.add(atraccionSegundaMayorTiempo);
		listaEsperado.add(promocionSegundoConMayorTiempo);
		listaEsperado.add(atraccionTerceraMenorTiempo);


		//act
		listaNoOrdenada.sort(new ProductoComparator());

		int i = 0;
		for (Producto productos : listaNoOrdenada) {
			Assert.assertEquals(productos,listaEsperado.get(i));
			i++;
		}
	}

	@Test
	public void atraccionContieneAtraccionTest(){

		///arrange
		Atraccion atraccion1 = new Atraccion("Atracción ", "Tipo 1", 15.0, 10, 60.0);
		Atraccion atraccion2 = new Atraccion("Atracción ", "Tipo 1", 15.0, 15, 60.0);
		Atraccion atraccion3 = new Atraccion("Atracción 3", "Tipo 2", 5.0, 5, 20.0);


		///assert
		Assert.assertTrue(atraccion1.contiene(atraccion2));
		Assert.assertFalse(atraccion1.contiene(atraccion3));

	}
	@Test
	public void PromocionContienePromocionTest(){

		//arrange
		Atraccion atraccion1 = new Atraccion("Atracción ", "Tipo 1", 15.0, 10, 60.0);
		Atraccion atraccion3 = new Atraccion("Atracción 3", "Tipo 2", 5.0, 5, 20.0);

		List<Atraccion> atracciones = new ArrayList<>();
		atracciones.add(atraccion1);
		atracciones.add(atraccion3);

		Promocion promocion = new Promocion(atracciones, "Aventura");

		//act
		Assert.assertTrue(promocion.contiene(promocion));

	}
	@Test
	public void PromocionContieneAtraccionTest(){
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
	public void esOfertableTest(){
		///arrange
		Usuario usuario = new Usuario("carlos","aventura",30,40);
		Atraccion atraccion1 = new Atraccion("Atracción 1", "aventura", 15.0, 10, 40.0);// es ofertable
		Atraccion atraccion2 = new Atraccion("Atracción 2", "aventura", 15.0, 15, 60.0);// no es ofertable por tiempo
		Atraccion atraccion3 = new Atraccion("Atracción 3", "accion", 30.1, 30, 20.0);// no es ofertable por precio
		Atraccion atraccion4 = new Atraccion("Atracción 4", "accion", 5.0, 0, 20.0);// no es ofertable por cupo

		///arrange
		Assert.assertTrue(atraccion1.esOfertable(usuario));
		Assert.assertFalse(atraccion2.esOfertable(usuario));
		Assert.assertFalse(atraccion3.esOfertable(usuario));
		Assert.assertFalse(atraccion4.esOfertable(usuario));
	}

	@Test
	public void verificarCuposDespuesComprarAtraccion(){
		///Arrange
		Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 15.0, 10, 40.0);
		int cuposEsperado = 9;

		///act
		atraccion1.comprar();
		//assert
		Assert.assertEquals(cuposEsperado,atraccion1.getCupo());
	}
	@Test
	public void comprarAtraccionSinCupo(){
		///arrange
		Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 15.0, 0, 40.0);
		int cuposEsperado = 0;
		//act
		boolean noCompra = atraccion1.comprar();
		//Assert
		Assert.assertFalse(noCompra);
		Assert.assertEquals(cuposEsperado,atraccion1.getCupo());
	}
	@Test
	public void compraPromocionYActualizaAtracciones(){
		///arrange
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
		///act
		promocion.comprar();

		///assert
		for (Atraccion atraccion : atracciones) {
			Assert.assertEquals((int)cuposEsperados.poll(),atraccion.getCupo());
		}
	}
	@Test
	public void comprarPromocionQueUnAtraccionNoTieneCupo(){
		///arrange
		Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 15.0, 10, 60.0);
		Atraccion atraccion2 = new Atraccion("Atracción 2", "Tipo 1", 15.0, 0, 60.0);

		List<Atraccion> atracciones = new ArrayList<>();
		atracciones.add(atraccion1);
		atracciones.add(atraccion2);
		Promocion promocion = new Promocion(atracciones, "Aventura");
		boolean accionEsperado;
		///act
		accionEsperado = promocion.comprar();
		//assert
		Assert.assertFalse(accionEsperado); // por que atraccion 2 no tiene cupo
	}
}
