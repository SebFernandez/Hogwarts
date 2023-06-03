package unlam.paradigmas.tp.hogwarts.producto;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ProductoComparatorTest {

	@Test
	public void compareTest() { // TODO muchos asserts en un test?
		Atraccion atraccion1 = new Atraccion("Montaña Rusa", "Aventura",25.0,10, 2.5);
		Atraccion atraccion2 = new Atraccion("Pileta", "acuatico",20.0,15, 3.2);		
		List<Atraccion> atracciones = new ArrayList<>();
        atracciones.add(atraccion1);
        atracciones.add(atraccion2);
        
        Promocion promocion = new Promocion(atracciones);
        Atraccion atraccion = new Atraccion("museo", "historia",50.5,25, 4.5);
        
        ProductoComparator comparator = new ProductoComparator("Aventura");
        Assert.assertTrue(comparator.compare(promocion,atraccion) > 0); //promocion contiene preferencia
        
        comparator = new ProductoComparator("paseo");
        Assert.assertTrue(comparator.compare(promocion,atraccion) > 0); // promocion es tipo Promocion
        
        comparator = new ProductoComparator("historia");
        Assert.assertTrue(comparator.compare(promocion,atraccion) < 0); // atraccion contiene preferencia
        Assert.assertTrue(comparator.compare(atraccion2,atraccion1) < 0); // atraccion1 es mas cara
		
        atraccion1 = new Atraccion("Montaña Rusa", "Aventura",20.0,10, 2.5);
		atraccion2 = new Atraccion("Pileta", "acuatico",20.0,15, 3.2);
		Assert.assertTrue(comparator.compare(atraccion1,atraccion2) < 0); // atraccion 2 es mas larga
		
		
		atraccion1 = new Atraccion("Montaña Rusa", "Aventura",20.0,10, 3);
		atraccion2 = new Atraccion("Pileta", "acuatico",20.0,15, 3);
		Assert.assertTrue(comparator.compare(atraccion1,atraccion2) == 0); // son iguales

	}

}
