package unlam.paradigmas.tp.hogwarts.producto;

import java.util.ArrayList;

public class PromocionPorcentual extends Promocion{
	
	public PromocionPorcentual(ArrayList<Atraccion> atracciones,int valor) {
		super(atracciones);
		aplicarDescuento(valor);
	}

	private void aplicarDescuento(int valor) { ///valor deberia estar entre 0 y 100
		setPrecioDescuento(getPrecioOriginal()*(1.00 -((double)valor/100)));
	}
}
