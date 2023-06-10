package unlam.paradigmas.tp.hogwarts.dto;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import unlam.paradigmas.tp.hogwarts.producto.Atraccion;
import unlam.paradigmas.tp.hogwarts.producto.Promocion;

import java.util.ArrayList;
import java.util.List;

public class UsuarioTest {

	@Test
	public void comprarTest(){
		Usuario usuario = new Usuario("carlos","aventura", 35F,65);
		Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 15.0, 10, 40.0);
		Atraccion atraccion2 = new Atraccion("Atracción 2", "Tipo 1", 5.0, 15, 20.0);
		Atraccion atraccion3 = new Atraccion("Atracción 3", "Tipo 2", 30.1, 30, 4.0);
		Atraccion atraccion4 = new Atraccion("Atracción 4", "Tipo 2", 5.0, 0, 4.0);

		Assert.assertTrue(usuario.comprar(atraccion1));
		Assert.assertFalse(usuario.comprar(atraccion1));
		Assert.assertTrue(usuario.comprar(atraccion2));
		Assert.assertFalse(usuario.comprar(atraccion3));
		Assert.assertTrue(usuario.comprar(atraccion4));
	}

	@Test
	public void compraAtraccionTest(){
		Usuario usuario = new Usuario("carlos","aventura", 35F,65);
		Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 15.0, 10, 40.0);
		Atraccion atraccion2 = new Atraccion("Atracción 2", "Tipo 1", 5.0, 15, 20.0);
		usuario.comprar(atraccion1);
		Assert.assertTrue(usuario.estaComprado(atraccion1));
		Assert.assertFalse(usuario.estaComprado(atraccion2));
	}

	@Test
	public void compraPromocionTest(){
		Usuario usuario = new Usuario("carlos","aventura", 3500F,650);
		Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 15.0, 10, 40.0);
		Atraccion atraccion2 = new Atraccion("Atracción 2", "Tipo 1", 5.0, 15, 20.0);
		Atraccion atraccion3 = new Atraccion("Atracción 3", "Tipo 2", 30.1, 30, 4.0);
		Atraccion atraccion4 = new Atraccion("Atracción 4", "Tipo 2", 5.0, 1, 4.0);

		List<Atraccion> atracciones = new ArrayList<>();
		atracciones.add(atraccion1);
		atracciones.add(atraccion3);
		atracciones.add(atraccion4);
		Promocion promocion1 = new Promocion(atracciones);

		usuario.comprar(promocion1);

		Assert.assertTrue(usuario.estaComprado(atraccion1));
		Assert.assertTrue(usuario.estaComprado(atraccion3));
		Assert.assertTrue(usuario.estaComprado(atraccion4));
		Assert.assertFalse(usuario.estaComprado(atraccion2));
	}

	@Test
	public void compraPromocionTest2(){
		Usuario usuario = new Usuario("carlos","aventura", 3500F,650);
		Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 15.0, 10, 40.0);
		Atraccion atraccion2 = new Atraccion("Atracción 2", "Tipo 1", 5.0, 15, 20.0);
		Atraccion atraccion3 = new Atraccion("Atracción 3", "Tipo 2", 30.1, 30, 4.0);
		Atraccion atraccion4 = new Atraccion("Atracción 4", "Tipo 2", 5.0, 1, 4.0);

		List<Atraccion> atracciones = new ArrayList<>();
		atracciones.add(atraccion1);
		atracciones.add(atraccion3);
		atracciones.add(atraccion4);
		Promocion promocion1 = new Promocion(atracciones);

		atracciones.clear();

		atracciones.add(atraccion2);
		atracciones.add(atraccion1);
		Promocion promocion2 = new Promocion(atracciones);

		usuario.comprar(promocion1);

		Assert.assertTrue(usuario.estaComprado(promocion2)); // la promocion 2 tiene atraccion 1 que se compro con la promocion 1
	}

	@Test
	public void equalsTest(){
		Usuario usuario1 = new Usuario("carlos","aventura", 35F,65);
		Usuario usuario2 = new Usuario("carlos","aventura", 35F,65);

		Assert.assertEquals(usuario1,usuario2);
	}

}
