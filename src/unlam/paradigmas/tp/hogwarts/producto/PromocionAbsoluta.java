package unlam.paradigmas.tp.hogwarts.producto;

import java.util.ArrayList;

public class PromocionAbsoluta extends Promocion{
	
	public PromocionAbsoluta(ArrayList<Atraccion> atracciones,int valor) {
		super(atracciones);
		aplicarDescuento(valor);
	}
	
	private void aplicarDescuento(int valor) {
		setPrecioDescuento(getPrecioOriginal() - valor);
	}
	
}
