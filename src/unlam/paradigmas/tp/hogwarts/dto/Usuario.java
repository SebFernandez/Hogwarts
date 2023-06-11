package unlam.paradigmas.tp.hogwarts.dto;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

import unlam.paradigmas.tp.hogwarts.producto.Producto;

public class Usuario {
	private String nombre;
	private String gusto;
	private float presupuesto;
	private int horas;
	private Set<Producto> compras;

	public Usuario(String nombre, String gusto, float presupuesto, int horas) {
		this.nombre = nombre;
		this.gusto = gusto;
		this.presupuesto = presupuesto;
		this.horas = horas;
		this.compras = new HashSet<>();
	}

	public Usuario() {

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

	// TODO: chequear que no tire un null.
	public boolean estaComprado(Producto otro) {
		Producto producto = null;
		Iterator<Producto> itCompras = compras.iterator();

		if (itCompras.hasNext())
			producto = itCompras.next();

		while (itCompras.hasNext() && !producto.contiene(otro))
			producto = itCompras.next();

		return producto != null && producto.contiene(otro);
	}

	public boolean comprar(Producto producto) {
		if (!estaComprado(producto)) {
			compras.add(producto);
			this.presupuesto -= producto.getPrecio();
			this.horas -= producto.getDuracion();
			return true;
		}

		return false;
	}

//    @Override
//    public String toString() {
//        return "Usuario{" +
//                "nombre='" + nombre + '\'' +
//                ", gusto='" + gusto + '\'' +
//                ", presupuesto=" + presupuesto +
//                ", horas=" + horas +
//                '}';
//    }

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Usuario usuario = (Usuario) o;
		return Float.compare(usuario.getPresupuesto(), getPresupuesto()) == 0 && getHoras() == usuario.getHoras()
				&& Objects.equals(getNombre(), usuario.getNombre()) && Objects.equals(getGusto(), usuario.getGusto());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getNombre(), getGusto(), getPresupuesto(), getHoras());
	}
}
