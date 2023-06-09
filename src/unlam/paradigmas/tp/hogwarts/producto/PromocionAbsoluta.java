package unlam.paradigmas.tp.hogwarts.producto;

import java.util.List;

public class PromocionAbsoluta extends Promocion {

	public PromocionAbsoluta(List<Atraccion> atracciones, int valor) {
		super(atracciones);
		aplicarDescuento(valor);
	}

	private void aplicarDescuento(int valor) {
		setPrecioFinalConDescuento(getPrecioOriginal() - valor);
	}

}
