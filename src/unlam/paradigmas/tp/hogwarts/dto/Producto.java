package unlam.paradigmas.tp.hogwarts.dto;

import unlam.paradigmas.tp.hogwarts.servicio.ProductoComparator;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class Producto {

    protected boolean esPromocion;
    protected String tipo;

    public static LinkedList<Producto> prepararOfertas(List<Promocion> promociones, Map<String, Atraccion> atracciones) {
        LinkedList<Producto> ofertas = new LinkedList<>();
        ofertas.addAll(promociones);
        ofertas.addAll(atracciones.values());

        ofertas.sort(new ProductoComparator());

        return ofertas;
    }

    public abstract boolean hayCupo();

    protected abstract void descontarCupo();

    public abstract double getPrecio();

    public abstract double getDuracion();

    public String getTipo() {
        return this.tipo;
    }

    public abstract boolean contiene(Producto otro);

    public boolean comprar() {
        if (hayCupo()) {
            descontarCupo();
            return true;
        }
        return false;
    }

    public boolean esPromocion() {
        return this.esPromocion;
    }

    public boolean esOfertable(Usuario usuario) {
        return (usuario.getPresupuesto() >= this.getPrecio() &&
                usuario.getHorasDisponibles() >= this.getDuracion() &&
                !usuario.estaComprado(this) &&
                this.hayCupo());
    }

    public boolean esGustoPreferido(Usuario usuario) {
        return usuario.getGusto().equals(getTipo());
    }


}
