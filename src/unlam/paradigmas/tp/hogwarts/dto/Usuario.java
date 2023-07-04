package unlam.paradigmas.tp.hogwarts.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
    private final String nombre;
    private final String gusto;
    private final List<Producto> compras;
    private float presupuesto;
    private double horasDisponibles;

    public Usuario(String nombre, String gusto, float presupuesto, int horasDisponibles) {
        this.nombre = nombre;
        this.gusto = gusto;
        this.presupuesto = presupuesto;
        this.horasDisponibles = horasDisponibles;
        this.compras = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getGusto() {
        return gusto;
    }

    public float getPresupuesto() {
        return presupuesto;
    }

    public double getHorasDisponibles() {
        return horasDisponibles;
    }

    public List<Producto> getCompras() {
        return compras;
    }

    public boolean estaComprado(Producto otro) {
        for (Producto producto : compras) {
            if (producto.contiene(otro))
                return true;
        }
        return false;
    }

    public boolean comprar(Producto producto) {
        if (!estaComprado(producto) && Double.compare(presupuesto, producto.getPrecio()) >= 0 &&
                Double.compare(horasDisponibles, producto.getDuracion()) >= 0 && producto.comprar()) {
            compras.add(producto);
            this.presupuesto -= producto.getPrecio();
            this.horasDisponibles -= producto.getDuracion();
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Usuario: " + nombre + " | " +
                "Preferencia: " + gusto + " | " +
                "Presupuesto: " + presupuesto + " | " +
                "Horas: " + horasDisponibles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(getNombre(), usuario.getNombre()) && Objects.equals(getGusto(), usuario.getGusto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getGusto());
    }
}
