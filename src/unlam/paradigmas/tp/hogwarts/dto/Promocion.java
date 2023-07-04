package unlam.paradigmas.tp.hogwarts.dto;

import java.util.List;

public class Promocion extends Producto {
    protected List<Atraccion> atracciones;
    private double duracion;
    private double precioOriginal;
    private double precioFinalConDescuento;

    public Promocion(List<Atraccion> atracciones, String tipo) {
        super();
        this.atracciones = atracciones;
        this.esPromocion = true;
        this.tipo = tipo;
        calcularDuracionTotal();
        calcularPrecioOriginal();
    }

    @Override
    public boolean hayCupo() {
        for (Atraccion atraccion : atracciones) {
            if (!atraccion.hayCupo())
                return false;
        }
        return true;
    }

    @Override
    protected void descontarCupo() {
        for (Atraccion atraccion : atracciones) {
            atraccion.descontarCupo();
        }
    }

    private void calcularPrecioOriginal() {
        this.precioOriginal = 0;
        for (Atraccion atraccion : atracciones) {
            precioOriginal += atraccion.getPrecio();
        }
    }

    private void calcularDuracionTotal() {
        this.duracion = 0;
        for (Atraccion atraccion : atracciones) {
            duracion += atraccion.getDuracion();
        }
    }

    protected void setPrecioFinalConDescuento(double precioFinalConDescuento) {
        this.precioFinalConDescuento = precioFinalConDescuento;
    }

    public List<Atraccion> getAtracciones() {
        return this.atracciones;
    }

    @Override
    public double getDuracion() {
        return this.duracion;
    }

    public double getPrecioOriginal() {
        return this.precioOriginal;
    }

    @Override
    public double getPrecio() {
        return this.precioFinalConDescuento;
    }

    @Override
    public boolean contiene(Producto otro) {
        if (otro.esPromocion()) {

            for (Atraccion atraccion : atracciones) {
                if (otro.contiene(atraccion))
                    return true;
            }
            return false;
        }

        return atracciones.contains(otro);
    }

    public String mostrarListaAtracciones() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < atracciones.size(); i++) {
            sb.append(atracciones.get(i).getNombre());
            if (i < atracciones.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public String toString() {
        String outAtrac = mostrarListaAtracciones();
        return "Promoción\n-Atracciones incluidas:" + outAtrac + "\n-Duración: " + duracion
                + " horas\n-Precio original: $" + precioOriginal + "\n-Precio con descuento: $"
                + String.format("%.0f", precioFinalConDescuento);
    }
}
