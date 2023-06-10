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
				Double.compare(duracion, otra.getDuracion()) ==0 && // TODO: revisar si es correcta esta comparacion
				Double.compare(precio,otra.getPrecio()) == 0;
	}
	@Override
	public boolean contiene(Producto otro) {
		if (otro instanceof Promocion) {
			Promocion otraProm = (Promocion) otro;
			return otraProm.getAtracciones().contains(this);
		} 
		else /// si otro es atraccion entonces: 
			return this.equals(otro);
	}

	@Override
	public boolean comprar() { // TODO: completar
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nombre + " Tipo: " + tipo + " Precio: " + precio + " Duracion: " + duracion;
	}
}
