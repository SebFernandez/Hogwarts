package unlam.paradigmas.tp.hogwarts.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Usuario {
    private String nombre;
    private String gusto;
    private float presupuesto;
    private int horas; // TODO: esto deberia ser double?
    private Set<Producto> compras;

    public Usuario(String nombre, String gusto, float presupuesto, int horas) {
        this.nombre = nombre;
        this.gusto = gusto;
        this.presupuesto = presupuesto;
        this.horas = horas;
        this.compras = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGusto() {
        return gusto;
    }

    public void setGusto(String gusto) {
        this.gusto = gusto;
    }

    public float getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(float presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public Set<Producto> getCompras() {
        return compras;
    }

    ;

    public boolean estaComprado(Producto otro) {
        for (Producto producto : compras) {
            if (producto.contiene(otro))
                return true;
        }
        return false;

//        Producto producto = null;
//        if(compras.iterator().hasNext())
//            producto = compras.iterator().next();
//
//
//        //  TODO: URGENTE. Iterator de la colección Set nunca sale del while.
//        while(compras.iterator().hasNext() && !producto.contiene(otro))
//            producto = compras.iterator().next();
//
//        return producto != null && producto.contiene(otro);
    }

    public boolean comprar(Producto producto) {
        if (!estaComprado(producto) && Double.compare(presupuesto, producto.getPrecio()) >= 0 && Double.compare(horas, producto.getDuracion()) >= 0) {
            compras.add(producto);
            this.presupuesto -= producto.getPrecio();
            this.horas -= producto.getDuracion();
            return producto.comprar();
        }

        return false;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", gusto='" + gusto + '\'' +
                ", presupuesto=" + presupuesto +
                ", horas=" + horas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Float.compare(usuario.getPresupuesto(), getPresupuesto()) == 0 && getHoras() == usuario.getHoras() && Objects.equals(getNombre(), usuario.getNombre()) && Objects.equals(getGusto(), usuario.getGusto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getGusto(), getPresupuesto(), getHoras());
    }
}
