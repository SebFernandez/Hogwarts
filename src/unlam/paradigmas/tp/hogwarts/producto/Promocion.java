package unlam.paradigmas.tp.hogwarts.producto;

import java.util.List;

public class Promocion extends Producto {
	protected List<Atraccion> atracciones;
	private double duracion;
	private double precioOriginal;
	private double precioFinalConDescuento;

	public Promocion() {
	}

	public Promocion(List<Atraccion> atracciones) {
		super();
		this.atracciones = atracciones;
		calcularDuracionFinal();
		calcularPrecioOriginal();
		this.esPromocion = true;
	}

	public boolean hayCupo() {
		for (Atraccion atraccion : atracciones) {
			if (!atraccion.hayCupo())
				return false;
		}
		return true;
	}

	public void descontarCupo() {
		for (Atraccion atraccion : atracciones) {
			atraccion.descontarCupo();
		}
	}

	public boolean esProductoPreferidoPorElUsuario(String tipo) {
		for (Atraccion atraccion : atracciones) {
			if (atraccion.esProductoPreferidoPorElUsuario(tipo))
				return true;
		}
		return false;
	}

	private void calcularPrecioOriginal() {
		this.precioOriginal = 0;
		for (Atraccion atraccion : atracciones) {
			precioOriginal += atraccion.getPrecio();
		}
	}

	private void calcularDuracionFinal() {
		this.duracion = 0;
		for (Atraccion atraccion : atracciones) {
			duracion += atraccion.getDuracion();
		}
	}

	protected void setPrecioFinalConDescuento(double precioFinalConDescuento) {
		this.precioFinalConDescuento = precioFinalConDescuento;
	}

	public List<Atraccion> getAtracciones() {
		return this.atracciones;
	}

	public double getDuracion() {
		return this.duracion;
	}

	public double getPrecioOriginal() {
		return this.precioOriginal;
	}

	public double getPrecio() {
		return this.precioFinalConDescuento;
	}
	
	private String getNombresDeAtracciones() {
		String nombresDeAtraccione = "";
		for(Atraccion atraccionesIncluidas: atracciones) {
			nombresDeAtraccione += atraccionesIncluidas.getNombre() + ", ";
		}
		return nombresDeAtraccione;
	}
	@Override
	public String toString() {
		return "Promocion " + "\n"
				+ "Atracciones incluidas:" + getNombresDeAtracciones() + "\n"
				+ "Duracion=" + duracion + "\n"
				+ "Precio original:" + precioOriginal + "\n"
				+ "Precio final con descuento:" + precioFinalConDescuento;
	}

	@Override
	public boolean contiene(Producto otro) {
		// TODO completar metodo
		return false;
	}

}
