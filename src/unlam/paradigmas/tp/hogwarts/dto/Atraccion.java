package unlam.paradigmas.tp.hogwarts.dto;


public class Atraccion extends Producto {

    private final String nombre;
    private final double precio;
    private final double duracion;
    private int cupo;

    public Atraccion(String nombre, String tipo, double precio, int cupo, double tiempo) {
        super();
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.cupo = cupo;
        this.duracion = tiempo;
        this.esPromocion = false;
    }

    @Override
    public boolean hayCupo() {
        return this.cupo > 0;
    }

    @Override
    protected void descontarCupo() {
        this.cupo--;
    }

    public String getNombre() {
        return this.nombre;
    }

    @Override
    public double getPrecio() {
        return this.precio;
    }

    // TODO: este metodo solo se usa en Tests, se deja?
    public int getCupo() {
        return this.cupo;
    }

    @Override
    public double getDuracion() {
        return this.duracion;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Atraccion otra = (Atraccion) obj;

        return nombre.equals(otra.getNombre()) &&
                tipo.equals(otra.getTipo()) &&
                Double.compare(duracion, otra.getDuracion()) == 0 &&
                Double.compare(precio, otra.getPrecio()) == 0;
    }

    @Override
    public boolean contiene(Producto otro) {
        return otro.esPromocion() ? ((Promocion) otro).getAtracciones().contains(this) : this.equals(otro);
    }

    @Override
    public String toString() {
        return "Atracción" +
                "\nNombre: [" + nombre + "]" +
                "\n-Precio: $" + String.format("%.2f", precio) +
                "\n-Duración: " + String.format("%.2f", duracion);
    }
}
