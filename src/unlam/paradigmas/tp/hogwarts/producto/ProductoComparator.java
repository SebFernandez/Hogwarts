package unlam.paradigmas.tp.hogwarts.producto;

import java.util.Comparator;

public class ProductoComparator implements Comparator<Producto> {
	private final String preferencia;

	public ProductoComparator(String preferencia) {
		this.preferencia = preferencia;
	}

	@Override
	public int compare(Producto prod1, Producto prod2) {
		int cmp;
		if ((cmp = cmpBol(prod1.esProductoPreferidoPorElUsuario(preferencia), prod2.esProductoPreferidoPorElUsuario(preferencia))) == 0)
			if ((cmp = cmpClase(prod1, prod2)) == 0)
				if ((cmp = Double.compare(prod1.getPrecio(), prod2.getPrecio())) == 0)
					cmp = (int) (prod1.getDuracion() - prod2.getDuracion()); ///TODO el redondeo hace que no funcione bien

		return cmp;
	}

	private int cmpBol(boolean b1, boolean b2) {
		if (b1 == b2)
			return 0;

		if (b1)
			return 1;

		return -1;
	}

	//	TODO: .getClass() e instanceof no le gustan al profesor
	private int cmpClase(Producto prod1, Producto prod2) {
		if (prod1.getClass() == prod2.getClass())
			return 0;

		if (prod1 instanceof Promocion)
			return 1;

		return -1;
	}
}
