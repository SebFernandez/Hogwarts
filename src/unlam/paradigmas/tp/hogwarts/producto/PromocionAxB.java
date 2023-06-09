package unlam.paradigmas.tp.hogwarts.producto;

import java.util.List;

public class PromocionAxB extends Promocion {

	public PromocionAxB(List<Atraccion> atracciones, int valor) {
		super(atracciones);
		aplicarDescuento(valor);
	}

	private void aplicarDescuento(int valor) {
		double precioFinal = getPrecioOriginal();

		for (int i = valor; i < atracciones.size(); i++) {
			precioFinal -= this.atracciones.get(i).getPrecio();
		}

		setPrecioFinalConDescuento(precioFinal);
	}
}
