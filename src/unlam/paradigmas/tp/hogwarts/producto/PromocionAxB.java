package unlam.paradigmas.tp.hogwarts.producto;

import java.util.ArrayList;

public class PromocionAxB extends Promocion{

	public PromocionAxB(ArrayList<Atraccion> atracciones,int valor) {
		super(atracciones);
		aplicarDescuento(valor);
	}
	
	private void aplicarDescuento(int valor) {
		double precioFinal = getPrecioOriginal();
		for (int i = valor; i < atracciones.size(); i++) {
			precioFinal -= atracciones.get(i).getPrecio();
		}
		setPrecioDescuento(precioFinal);
	}
}
