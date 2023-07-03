package unlam.paradigmas.tp.hogwarts.producto;

import org.junit.Assert;
import org.junit.Test;
import unlam.paradigmas.tp.hogwarts.dto.Atraccion;
import unlam.paradigmas.tp.hogwarts.dto.PromocionAbsoluta;
import unlam.paradigmas.tp.hogwarts.dto.PromocionAxB;
import unlam.paradigmas.tp.hogwarts.dto.PromocionPorcentual;

import java.util.ArrayList;
import java.util.List;

public class PromocionTest {

    @Test
    public void promocionAbsolutaTest() {
        Atraccion atraccion = new Atraccion("Atracción 1", "Tipo 1", 15.0, 10, 40.0);
        List<Atraccion> atracciones = new ArrayList<>();
        atracciones.add(atraccion);
        PromocionAbsoluta promocion = new PromocionAbsoluta(atracciones, "Aventura", 10);

        Assert.assertEquals(0, Double.compare(promocion.getPrecio(), 5));
    }

    @Test
    public void promocionPorcentualTest() {
        Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 10.0, 10, 40.0);
        Atraccion atraccion2 = new Atraccion("Atracción 1", "Tipo 1", 10.0, 10, 40.0);
        List<Atraccion> atracciones = new ArrayList<>();
        atracciones.add(atraccion1);
        atracciones.add(atraccion2);
        PromocionPorcentual promocion = new PromocionPorcentual(atracciones, "Aventura", 10); // se le aplica 10% de descuento

        Assert.assertEquals(0, Double.compare(promocion.getPrecio(), 18));
    }

    @Test
    public void promocionAxBTest() {
        Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 10.0, 10, 40.0);
        Atraccion atraccion2 = new Atraccion("Atracción 2", "Tipo 1", 7.0, 10, 40.0);
        Atraccion atraccion3 = new Atraccion("Atracción 3", "Tipo 1", 5.0, 10, 40.0);
        Atraccion atraccion4 = new Atraccion("Atracción 4", "Tipo 1", 2.0, 10, 40.0);
        List<Atraccion> atracciones = new ArrayList<>();
        atracciones.add(atraccion1);
        atracciones.add(atraccion2);
        atracciones.add(atraccion3);
        atracciones.add(atraccion4);
        PromocionAxB promocion = new PromocionAxB(atracciones, "Aventura", 3); // desde la 3ra son gratis
        Assert.assertEquals(0, Double.compare(promocion.getPrecio(), 17));
    }

}
