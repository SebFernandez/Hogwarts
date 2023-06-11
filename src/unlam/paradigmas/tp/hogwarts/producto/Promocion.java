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
		precioFinalConDescuento = precioOriginal; // TODO corregir
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

	@Override
	public boolean contiene(Producto otro) { // TODO testear metodo
		if (otro instanceof Promocion) {
			Promocion otraPromocion = (Promocion) otro;

			for (Atraccion atraccion : atracciones) { // pregunto si la otra promocion contiene alguna de mis
														// atracciones
				if (otraPromocion.contiene(atraccion))
					return true;
			}
			return false;
		}
		// otro es Atraccion entonces pregunto si esta en mi lista de atracciones
		return atracciones.contains(otro);
	}

	public String mostrarListaAtracciones() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < atracciones.size(); i++) {
			sb.append(atracciones.get(i).getNombre());
			if (i < atracciones.size() - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	@Override
	public String toString() { // TODO revisar
		String outAtrac = mostrarListaAtracciones();
		String out = "Promoción\n-Atracciones incluidas:" + outAtrac + "\n-Duración: " + duracion
				+ " horas\n-Precio original: $" + precioOriginal + "\n-Precio con descuento: $"
				+ String.format("%.0f", precioFinalConDescuento);

		return out;
	}

}
