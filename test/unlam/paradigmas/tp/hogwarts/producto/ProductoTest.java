package unlam.paradigmas.tp.hogwarts.producto;

import org.junit.Assert;
import org.junit.Test;
import unlam.paradigmas.tp.hogwarts.dto.Atraccion;
import unlam.paradigmas.tp.hogwarts.dto.Promocion;
import unlam.paradigmas.tp.hogwarts.dto.Usuario;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProductoTest {
	@Test
	public void contieneTest(){
		Atraccion atraccion1 = new Atraccion("Atracción ", "Tipo 1", 15.0, 10, 60.0);
		Atraccion atraccion2 = new Atraccion("Atracción ", "Tipo 1", 15.0, 15, 60.0);
		Atraccion atraccion3 = new Atraccion("Atracción 3", "Tipo 2", 5.0, 5, 20.0);
		Atraccion atraccion4 = new Atraccion("Atracción 4", "Tipo 4", 6.0, 10, 25.0);

		List<Atraccion> atracciones = new ArrayList<>();
		atracciones.add(atraccion1);
		atracciones.add(atraccion3);
		
		Promocion promocion = new Promocion(atracciones, "Aventura");

		Assert.assertTrue(atraccion1.contiene(atraccion2));
		Assert.assertTrue(promocion.contiene(atraccion1));
		Assert.assertTrue(promocion.contiene(atraccion3));
		Assert.assertFalse(atraccion1.contiene(atraccion3));
		Assert.assertFalse(promocion.contiene(atraccion4));
	}

	@Test
	public void esOfertableTest(){
		Usuario usuario = new Usuario("carlos","aventura",30,40);
		Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 15.0, 10, 40.0);// es ofertable
		Atraccion atraccion2 = new Atraccion("Atracción 2", "Tipo 1", 15.0, 15, 60.0);// no es ofertable por tiempo
		Atraccion atraccion3 = new Atraccion("Atracción 3", "Tipo 2", 30.1, 30, 20.0);// no es ofertable por precio
		Atraccion atraccion4 = new Atraccion("Atracción 4", "Tipo 2", 5.0, 0, 20.0);// no es ofertable por cupo

		Assert.assertTrue(atraccion1.esOfertable(usuario));
		Assert.assertFalse(atraccion2.esOfertable(usuario));
		Assert.assertFalse(atraccion3.esOfertable(usuario));
		Assert.assertFalse(atraccion4.esOfertable(usuario));
	}

	@Test
	public void comprarTest(){
		Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 15.0, 10, 40.0);
		atraccion1.comprar();
		Assert.assertEquals(9,atraccion1.getCupo());
	}
	@Test
	public void comprarTest2(){
		Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 15.0, 0, 40.0);
		Assert.assertFalse(atraccion1.comprar());
		Assert.assertEquals(0,atraccion1.getCupo());
	}
	@Test
	public void comprarTest3(){
		Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 15.0, 10, 60.0);
		Atraccion atraccion2 = new Atraccion("Atracción 3", "Tipo 2", 5.0, 5, 20.0);

		List<Atraccion> atracciones = new ArrayList<>();
		atracciones.add(atraccion1);
		atracciones.add(atraccion2);

		Promocion promocion = new Promocion(atracciones, "Aventura");

		promocion.comprar();

		atracciones = promocion.getAtracciones();
		Queue<Integer> cuposEsperados = new LinkedList<>();
		cuposEsperados.offer(9);
		cuposEsperados.offer(4);

		for (Atraccion atraccion : atracciones) {
			Assert.assertEquals((int)cuposEsperados.poll(),atraccion.getCupo());
		}
	}
	@Test
	public void comprarTest4(){
		Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 15.0, 10, 60.0);
		Atraccion atraccion2 = new Atraccion("Atracción 2", "Tipo 1", 15.0, 0, 60.0);

		List<Atraccion> atracciones = new ArrayList<>();
		atracciones.add(atraccion1);
		atracciones.add(atraccion2);

		Promocion promocion = new Promocion(atracciones, "Aventura");

		Assert.assertFalse(promocion.comprar()); // por que atraccion 2 no tiene cupo
	}
}
