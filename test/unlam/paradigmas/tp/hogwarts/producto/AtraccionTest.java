package unlam.paradigmas.tp.hogwarts.producto;

import org.junit.Assert;
import org.junit.Test;
import unlam.paradigmas.tp.hogwarts.dto.Atraccion;
import unlam.paradigmas.tp.hogwarts.dto.Promocion;

import java.util.ArrayList;
import java.util.List;

public class AtraccionTest {
	@Test
	public void equalsTest() {
        Atraccion atraccion1 = new Atraccion("Atracción ", "Tipo 1", 15.0, 10, 60.0);
        Atraccion atraccion2 = new Atraccion("Atracción ", "Tipo 1", 15.0, 15, 60.0);
        Atraccion atraccion3 = new Atraccion("Atracción 3", "Tipo 2", 5.0, 5, 20.0);

        List<Atraccion> atraccionesPromocion = new ArrayList<>();
        atraccionesPromocion.add(atraccion1);
        Promocion promocion = new Promocion(atraccionesPromocion, "Aventura");

        Assert.assertEquals(atraccion1, atraccion1);
        Assert.assertEquals(atraccion1, atraccion2);
        Assert.assertNotEquals(atraccion2, atraccion3);
        Assert.assertNotEquals(atraccion2, promocion);
    }
}
