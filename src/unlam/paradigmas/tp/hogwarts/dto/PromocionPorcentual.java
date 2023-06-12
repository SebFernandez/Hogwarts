package unlam.paradigmas.tp.hogwarts.dto;

import java.util.List;

public class PromocionPorcentual extends Promocion {

    public PromocionPorcentual(List<Atraccion> atracciones, String tipo, int valor) {
        super(atracciones, tipo);
        aplicarDescuento(valor);
    }

    private void aplicarDescuento(int valor) { ///valor deberia estar entre 0 y 100
        double descuento = 1.00 - ((double) valor / 100);

        setPrecioFinalConDescuento(getPrecioOriginal() * descuento);
    }
}
