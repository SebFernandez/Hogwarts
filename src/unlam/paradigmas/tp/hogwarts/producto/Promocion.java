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

	protected void setPrecioDescuento(double precioDescuento) {
		this.precioDescuento = precioDescuento;
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
		return this.precioDescuento;
	}

	public void mostrarListaAtracciones() {
		System.out.print("[");
        for (int i = 0; i < atracciones.size(); i++) {
            System.out.print(atracciones.get(i).getNombre());
            if (i < atracciones.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
	}

}
