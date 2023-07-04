package unlam.paradigmas.tp.hogwarts.producto;

import org.junit.Assert;
import org.junit.Test;
import unlam.paradigmas.tp.hogwarts.dto.Atraccion;
import unlam.paradigmas.tp.hogwarts.servicio.ProductoComparator;

public class ProductoComparatorTest {
    private ProductoComparator comparator;

    @Test
    public void CompareAtraccion2MasCaraQueAtraccion1Test() {
        Atraccion atraccion1 = new Atraccion("Montaña Rusa", "Aventura", Double.parseDouble("25.0"),
                Integer.parseInt("10"), Double.parseDouble("2.5"));
        Atraccion atraccion2 = new Atraccion("Pileta", "Aventura", Double.parseDouble("30.0"), Integer.parseInt("15"),
                Double.parseDouble("3.2"));

        comparator = new ProductoComparator();
        Assert.assertTrue(comparator.compare(atraccion1, atraccion2) > 0);
    }

    @Test
    public void CompareAtraccion1MasCaraQueAtraccion2Test() {
        Atraccion atraccion1 = new Atraccion("Montaña Rusa", "Aventura", Double.parseDouble("25.0"),
                Integer.parseInt("10"), Double.parseDouble("2.5"));
        Atraccion atraccion2 = new Atraccion("Pileta", "Aventura", Double.parseDouble("20.0"), Integer.parseInt("15"),
                Double.parseDouble("3.2"));

        comparator = new ProductoComparator();
        Assert.assertTrue(comparator.compare(atraccion1, atraccion2) < 0);
    }

    @Test
    public void CompareAtraccionDuracionMasLargaQueOtraTest() {
        Atraccion atraccion1 = new Atraccion("Montaña Rusa", "Aventura", Double.parseDouble("20.0"),
                Integer.parseInt("10"), Double.parseDouble("2.5"));
        Atraccion atraccion2 = new Atraccion("Pileta", "Aventura", Double.parseDouble("20.0"), Integer.parseInt("15"),
                Double.parseDouble("3.2"));

        comparator = new ProductoComparator();
        Assert.assertTrue(comparator.compare(atraccion1, atraccion2) > 0);
    }

    @Test
    public void CompareAtraccionesIgualesTest() {
        Atraccion atraccion1 = new Atraccion("Montaña Rusa", "Aventura", 20.0, 10, 3);
        Atraccion atraccion2 = new Atraccion("Pileta", "Historia", 20.0, 15, 3);

        comparator = new ProductoComparator();

        Assert.assertEquals(0, comparator.compare(atraccion1, atraccion2));
    }
}
