package unlam.paradigmas.tp.hogwarts.producto;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ProductoComparatorTest {
	private Promocion promocion;
	private ProductoComparator comparator;

	@Before
	public void init() {
		Atraccion atraccion1 = new Atraccion("Montaña Rusa", "Aventura", Double.parseDouble("25.0"), Integer.parseInt("10"), Double.parseDouble("2.5"));
		Atraccion atraccion2 = new Atraccion("Pileta", "acuatico", Double.parseDouble("20.0"), Integer.parseInt("15"), Double.parseDouble("3.2"));
		List<Atraccion> atracciones = List.of(atraccion1, atraccion2);

		promocion = new Promocion(atracciones);
	}

	//  Promocion contiene preferencia
	@Test
	public void comparePromocionContienePreferenciaTest() {
		comparator = new ProductoComparator("Aventura");
		Atraccion atraccion = new Atraccion("museo", "historia", Double.parseDouble("50.5"), Integer.parseInt("25"), Double.parseDouble("4.5"));

		Assert.assertTrue(comparator.compare(promocion, atraccion) > 0);
	}

	//  Promocion es tipo Promocion
	@Test
	public void ComparePromocionEsTipoPromocionTest() {
		comparator = new ProductoComparator("paseo");
		Atraccion atraccion = new Atraccion("museo", "historia", Double.parseDouble("50.5"), Integer.parseInt("25"), Double.parseDouble("4.5"));

		Assert.assertTrue(comparator.compare(promocion, atraccion) > 0);
	}

	//  Atraccion contiene preferencia
	@Test
	public void CompareAtraccionesContienePreferenciaTest() {
		comparator = new ProductoComparator("historia");
		Atraccion atraccion = new Atraccion("museo", "historia", Double.parseDouble("50.5"), Integer.parseInt("25"), Double.parseDouble("4.5"));

		Assert.assertTrue(comparator.compare(promocion, atraccion) < 0);
	}

	//  atraccion1 es mas cara que atraccion2
	@Test
	public void CompareAtraccion1MasCaraQueAtraccion2Test() {
		Atraccion atraccion1 = new Atraccion("Montaña Rusa", "Aventura", Double.parseDouble("25.0"), Integer.parseInt("10"), Double.parseDouble("2.5"));
		Atraccion atraccion2 = new Atraccion("Pileta", "acuatico", Double.parseDouble("20.0"), Integer.parseInt("15"), Double.parseDouble("3.2"));

		Assert.assertTrue(comparator.compare(atraccion2, atraccion1) < 0);
	}

	// atraccion 2 es mas larga
	@Test
	public void CompareAtraccionDuracionMasLargaQueOtraTest() {
		Atraccion atraccion1 = new Atraccion("Montaña Rusa", "Aventura", Double.parseDouble("20.0"), Integer.parseInt("10"),
				Double.parseDouble("2.5"));
		Atraccion atraccion2 = new Atraccion("Pileta", "acuatico", Double.parseDouble("20.0"), Integer.parseInt("15"), Double.parseDouble("3.2"));

		Assert.assertTrue(comparator.compare(atraccion1, atraccion2) < 0);
	}

	//  Son iguales
	@Test
	public void CompareAtraccionesIgualesTest() {
		Atraccion atraccion1 = new Atraccion("Montaña Rusa", "Aventura", 20.0, 10, 3);
		Atraccion atraccion2 = new Atraccion("Pileta", "acuatico", 20.0, 15, 3);

		Assert.assertTrue(comparator.compare(atraccion1, atraccion2) == 0);
	}

}
