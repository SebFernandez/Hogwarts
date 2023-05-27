package unlam.paradigmas.tp.hogwarts.producto;

import java.util.List;

public class PromocionPorcentual extends Promocion {

	public PromocionPorcentual(List<Atraccion> atracciones, int valor) {
		super(atracciones);
		aplicarDescuento(valor);
	}

	private void aplicarDescuento(int valor) { ///valor deberia estar entre 0 y 100
		double descuento = 1.00 - ((double) valor / 100);

		setPrecioDescuento(getPrecioOriginal() * descuento);
	}
}
