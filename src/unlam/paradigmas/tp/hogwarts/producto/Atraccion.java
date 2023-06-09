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
		this.esPromocion=false;
	}

	public boolean hayCupo() {
		return this.cupo > 0;
	}

	public void descontarCupo() {
		this.cupo--;
	}

	public boolean esProductoPreferidoPorElUsuario(String tipo) {
		return this.tipo.equals(tipo);
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getTipo() {
		return this.tipo;
	}

	public double getPrecio() {
		return this.precio;
	}

	public int getCupo() {
		return this.cupo;
	}

	public double getDuracion() {
		return this.duracion;
	}
	
	
	@Override
	public String toString() {
		return "Atraccion " + "\n"
				+ "Nombre:" + nombre + "\n"
				+ "Tipo=" + tipo + "\n"
				+ "Cupo=" + cupo + "\n"
				+ "Precio=" + precio + "\n"
				+ "Duracion=" + duracion;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}

		Atraccion otra = (Atraccion) obj;

		return nombre.equals(otra.getNombre()) &&
				tipo.equals(otra.getTipo()) &&
				duracion == otra.getDuracion() &&   //  TODO: Comparar floats o double puede tener problemas de precisión. Podemos usar BigDecimal que es la solución de Java al problema mencionado.
				precio == otra.getPrecio();
	}

	/*
	Este metodo comprueba si un producto contiene a otro producto,
	en este caso verifica si una atraccion contiene una promocion o otra atraccion, 
	en caso de que la promocion contenga dentro de sus atracciones a la atraccion this("el objeto llamador"),
	devolvera verdadero, si 'otro' es una atraccion simplemente la compara con la actual(this).
	*/
	@Override
	public boolean contiene(Producto otro) {
		if (otro instanceof Promocion) {
			Promocion otraProm = (Promocion) otro;
			return otraProm.getAtracciones().contains(this); //TODO esto usa el equals de Atraccion? RTA: Sí.
		} else
			return this.equals(otro);
	}

}
