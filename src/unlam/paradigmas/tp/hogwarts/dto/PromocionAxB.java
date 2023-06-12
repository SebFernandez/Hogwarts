package unlam.paradigmas.tp.hogwarts.dto;

import java.util.List;

public class PromocionAxB extends Promocion {

    public PromocionAxB(List<Atraccion> atracciones, String tipo, int valor) {
        super(atracciones, tipo);
        aplicarDescuento(valor);
    }

    private void aplicarDescuento(int valor) {
        double precioFinal = getPrecioOriginal();
        for (int i = valor - 1; i < atracciones.size(); i++) {
            precioFinal -= this.atracciones.get(i).getPrecio();
        }

        setPrecioFinalConDescuento(precioFinal);
    }
}
