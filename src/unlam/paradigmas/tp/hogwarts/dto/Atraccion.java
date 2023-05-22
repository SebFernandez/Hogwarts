package unlam.paradigmas.tp.hogwarts.dto;

import java.util.Objects;

public class Atraccion {
    private String ubicacion;
    private int hsDuracion;

    public Atraccion(String ubicacion, int hsDuracion) {
        this.ubicacion = ubicacion;
        this.hsDuracion = hsDuracion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getHsDuracion() {
        return hsDuracion;
    }

    public void setHsDuracion(int hsDuracion) {
        this.hsDuracion = hsDuracion;
    }

    @Override
    public String toString() {
        return "Atraccion{" +
                "ubicación='" + ubicacion + '\'' +
                ", hsDuración=" + hsDuracion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atraccion atraccion = (Atraccion) o;
        return getHsDuracion() == atraccion.getHsDuracion() && Objects.equals(getUbicacion(), atraccion.getUbicacion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUbicacion(), getHsDuracion());
    }
}
