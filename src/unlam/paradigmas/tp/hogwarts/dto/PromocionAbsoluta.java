package unlam.paradigmas.tp.hogwarts.dto;

import java.util.List;

public class PromocionAbsoluta extends Promocion {

    public PromocionAbsoluta(List<Atraccion> atracciones, String tipo, int valor) {
        super(atracciones, tipo);
        aplicarDescuento(valor);
    }

    private void aplicarDescuento(int valor) {
        setPrecioFinalConDescuento(getPrecioOriginal() - valor);
    }

}
