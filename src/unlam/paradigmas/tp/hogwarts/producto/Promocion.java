package unlam.paradigmas.tp.hogwarts.producto;

import java.util.List;

public class Promocion extends Producto {
	protected List<Atraccion> atracciones;
	private double duracion;
	private double precioOriginal;
	private double precioDescuento;

	public Promocion() {
	}

	public Promocion(List<Atraccion> atracciones) {
		super();
		this.atracciones = atracciones;
		calcularDuracionFinal();
		calcularPrecioOriginal();
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

	public boolean esTipo(String tipo) {
		for (Atraccion atraccion : atracciones) {
			if (atraccion.esTipo(tipo))
				return true;
		}
		return false;
	}

	private void calcularPrecioOriginal() {
		precioOriginal = 0;
		for (Atraccion atraccion : atracciones) {
			precioOriginal += atraccion.getPrecio();
		}
	}

	private void calcularDuracionFinal() {
		duracion = 0;
		for (Atraccion atraccion : atracciones) {
			duracion += atraccion.getDuracion();
		}
	}

	protected void setPrecioDescuento(double precioDescuento) {
		this.precioDescuento = precioDescuento;
	}

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

	public double getDuracion() {
		return duracion;
	}

	public double getPrecioOriginal() {
		return precioOriginal;
	}

	public double getPrecio() {
		return precioDescuento;
	}

}
