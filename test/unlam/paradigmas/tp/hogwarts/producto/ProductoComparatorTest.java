package unlam.paradigmas.tp.hogwarts.producto;

import org.junit.Assert;
import org.junit.Test;
import unlam.paradigmas.tp.hogwarts.dto.Atraccion;
import unlam.paradigmas.tp.hogwarts.dto.Promocion;
import unlam.paradigmas.tp.hogwarts.servicio.ProductoComparator;

import java.util.List;

public class ProductoComparatorTest {
	private ProductoComparator comparator;

	//  Promocion contiene preferencia
//	@Test
//	public void comparePromocionContienePreferenciaTest() {
//		Promocion promocion = new Promocion(List.of(
//				new Atraccion("Montaña Rusa", "Aventura", Double.parseDouble("25.0"), Integer.parseInt("10"), Double.parseDouble("2.5")),
//				new Atraccion("Pileta", "acuatico", Double.parseDouble("20.0"), Integer.parseInt("15"), Double.parseDouble("3.2"))
//		));
//
//		comparator = new ProductoComparator("Aventura");
//		Atraccion atraccion = new Atraccion("museo", "historia", Double.parseDouble("50.5"), Integer.parseInt("25"), Double.parseDouble("4.5"));
//
//		Assert.assertTrue(comparator.compare(promocion, atraccion) > 0);
//	}

	//  Promocion es tipo Promocion
	@Test
	public void ComparePromocionEsTipoPromocionTest() {
		Promocion promocion = new Promocion(List.of(
				new Atraccion("Montaña Rusa", "Aventura", Double.parseDouble("25.0"), Integer.parseInt("10"), Double.parseDouble("2.5")),
				new Atraccion("Pileta", "acuatico", Double.parseDouble("20.0"), Integer.parseInt("15"), Double.parseDouble("3.2"))
		), "Aventura");

		comparator = new ProductoComparator();
		Atraccion atraccion = new Atraccion("museo", "historia", Double.parseDouble("50.5"), Integer.parseInt("25"), Double.parseDouble("4.5"));

		Assert.assertTrue(comparator.compare(promocion, atraccion) > 0);
	}
	@Test
	public void CompareAtraccion1MasCaraQueAtraccion2Test() {
		Atraccion atraccion1 = new Atraccion("Montaña Rusa", "Aventura", Double.parseDouble("25.0"), Integer.parseInt("10"), Double.parseDouble("2.5"));
		Atraccion atraccion2 = new Atraccion("Pileta", "Aventura", Double.parseDouble("20.0"), Integer.parseInt("15"), Double.parseDouble("3.2"));
		
		comparator = new ProductoComparator();
		Assert.assertTrue(comparator.compare(atraccion2, atraccion1) < 0);
	}
	@Test
	public void CompareAtraccionDuracionMasLargaQueOtraTest() {
		Atraccion atraccion1 = new Atraccion("Montaña Rusa", "Aventura", Double.parseDouble("20.0"), Integer.parseInt("10"),
				Double.parseDouble("2.5"));
		Atraccion atraccion2 = new Atraccion("Pileta", "Aventura", Double.parseDouble("20.0"), Integer.parseInt("15"), Double.parseDouble("3.2"));
		
		comparator = new ProductoComparator();
		Assert.assertTrue(comparator.compare(atraccion1, atraccion2) < 0);
	}
	@Test
	public void CompareAtraccionesIgualesTest() {
		Atraccion atraccion1 = new Atraccion("Montaña Rusa", "Aventura", 20.0, 10, 3);
		Atraccion atraccion2 = new Atraccion("Pileta", "Historia", 20.0, 15, 3);
		
		comparator = new ProductoComparator();

		Assert.assertEquals(0, comparator.compare(atraccion1, atraccion2));
	}
	//TODO: testear ordenamiento con comparator
}
