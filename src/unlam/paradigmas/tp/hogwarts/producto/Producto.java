package unlam.paradigmas.tp.hogwarts.producto;

import unlam.paradigmas.tp.hogwarts.dto.Usuario;

public abstract class Producto {
	
//	protected boolean esPromocion; // TODO cual es la finalidad de esto?

	public abstract boolean hayCupo();

	public abstract void descontarCupo();

	public abstract boolean esProductoPreferidoPorElUsuario(String preferencia);

	public abstract double getPrecio();

	public abstract double getDuracion();
	
	public abstract boolean contiene(Producto otro);
	
	public boolean esOfertable(Usuario usuario) {
		return (usuario.getPresupuesto() >= this.getPrecio() &&
				usuario.getHoras() >= this.getDuracion() &&
				!usuario.estaComprado(this) &&
				this.hayCupo());
	}
}
