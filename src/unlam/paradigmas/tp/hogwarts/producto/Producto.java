package unlam.paradigmas.tp.hogwarts.producto;

public abstract class Producto {
	
	public abstract boolean hayCupo();
	public abstract void descontarCupo();
	public abstract boolean esTipo(String tipo);
	public abstract double getPrecio();
	public abstract double getDuracion();
}
