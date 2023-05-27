package unlam.paradigmas.tp.hogwarts.producto;

public class Atraccion extends Producto {

	private final String nombre;
	private final String tipo;
	private int cupo;
	private final double precio;
	private final double duracion;

	public Atraccion(String nombre, String tipo, double precio, int cupo, double tiempo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
		this.cupo = cupo;
		this.duracion = tiempo;
	}

	public boolean hayCupo() {
		return cupo > 0;
	}

	public void descontarCupo() {
		this.cupo--;
	}

	public boolean esTipo(String tipo) {
		return this.tipo.equals(tipo);
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public double getPrecio() {
		return precio;
	}

	public int getCupo() {
		return cupo;
	}

	public double getDuracion() {
		return duracion;
	}

}
