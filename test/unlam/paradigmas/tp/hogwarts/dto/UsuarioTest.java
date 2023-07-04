package unlam.paradigmas.tp.hogwarts.dto;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UsuarioTest {
    @Test
    public void comprarTest() {
        Usuario usuario = new Usuario("carlos", "aventura", 35F, 65);
        Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 15.0, 10, 40.0);
        Atraccion atraccion2 = new Atraccion("Atracción 2", "Tipo 1", 5.0, 15, 20.0);


        Assert.assertTrue(usuario.comprar(atraccion1));
        Assert.assertFalse(usuario.comprar(atraccion1));
        Assert.assertTrue(usuario.comprar(atraccion2));

    }

    @Test
    public void comprarTest2() {
        Usuario usuario = new Usuario("carlos", "aventura", 35F, 65);
        Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 35.0002, 30, 4.0);
        Atraccion atraccion2 = new Atraccion("Atracción 2", "Tipo 2", 5.0, 0, 4.0);
        Atraccion atraccion3 = new Atraccion("Atracción 3", "Tipo 3", 5.0, 1, 67);
        Assert.assertFalse(usuario.comprar(atraccion1)); // no se compra por precio
        Assert.assertFalse(usuario.comprar(atraccion2)); // no se compra por cupo
        Assert.assertFalse(usuario.comprar(atraccion3)); // no se compra por tiempo
    }

    @Test
    public void compraAtraccionTest() {
        Usuario usuario = new Usuario("carlos", "aventura", 35F, 65);
        Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 15.0, 10, 40.0);
        Atraccion atraccion2 = new Atraccion("Atracción 2", "Tipo 1", 5.0, 15, 20.0);
        usuario.comprar(atraccion1);
        Assert.assertTrue(usuario.estaComprado(atraccion1));
        Assert.assertFalse(usuario.estaComprado(atraccion2));
    }

    @Test
    public void compraPromocionTest() {
        Usuario usuario = new Usuario("carlos", "aventura", 3500F, 650);
        Atraccion atraccion1 = new Atraccion("Atracción 1", "Aventura", 15.0, 10, 40.0);
        Atraccion atraccion2 = new Atraccion("Atracción 2", "Aventura", 5.0, 15, 20.0);
        Atraccion atraccion3 = new Atraccion("Atracción 3", "Aventura", 30.1, 30, 4.0);
        Atraccion atraccion4 = new Atraccion("Atracción 4", "Degustacion", 5.0, 1, 4.0);

        List<Atraccion> atracciones = new ArrayList<>();
        atracciones.add(atraccion1);
        atracciones.add(atraccion2);
        atracciones.add(atraccion3);
        Promocion promocion1 = new Promocion(atracciones, "Aventura");

        usuario.comprar(promocion1);

        Assert.assertTrue(usuario.estaComprado(atraccion1));
        Assert.assertTrue(usuario.estaComprado(atraccion2));
        Assert.assertTrue(usuario.estaComprado(atraccion3));
        Assert.assertFalse(usuario.estaComprado(atraccion4));
    }

    @Test
    public void compraPromocionTest2() {
        Usuario usuario = new Usuario("carlos", "aventura", 3500F, 650);
        Atraccion atraccion1 = new Atraccion("Atracción 1", "Tipo 1", 15.0, 10, 40.0);
        Atraccion atraccion2 = new Atraccion("Atracción 2", "Tipo 1", 5.0, 15, 20.0);
        Atraccion atraccion3 = new Atraccion("Atracción 3", "Tipo 2", 30.1, 30, 4.0);
        Atraccion atraccion4 = new Atraccion("Atracción 4", "Tipo 2", 5.0, 1, 4.0);

        List<Atraccion> atracciones = new ArrayList<>();
        atracciones.add(atraccion1);
        atracciones.add(atraccion3);
        atracciones.add(atraccion4);
        Promocion promocion1 = new Promocion(atracciones, "Aventura");

        atracciones.clear();

        atracciones.add(atraccion1);
        atracciones.add(atraccion2);
        Promocion promocion2 = new Promocion(atracciones, "Aventura");

        usuario.comprar(promocion1);

        Assert.assertTrue(usuario.estaComprado(promocion2));
    }

    @Test
    public void equalsTest() {
        Usuario usuario1 = new Usuario("carlos", "aventura", 35F, 65);
        Usuario usuario2 = new Usuario("carlos", "aventura", 20F, 60);

        Assert.assertEquals(usuario1, usuario2);
    }

}
