package unlam.paradigmas.tp.tierramedia.dto;

import java.util.Objects;

public class Atraccion {
    private String ubicación;
    private int hsDuración;

    public Atraccion(String ubicación, int hsDuración) {
        this.ubicación = ubicación;
        this.hsDuración = hsDuración;
    }

    public String getUbicación() {
        return ubicación;
    }

    public void setUbicación(String ubicación) {
        this.ubicación = ubicación;
    }

    public int getHsDuración() {
        return hsDuración;
    }

    public void setHsDuración(int hsDuración) {
        this.hsDuración = hsDuración;
    }

    @Override
    public String toString() {
        return "Atraccion{" +
                "ubicación='" + ubicación + '\'' +
                ", hsDuración=" + hsDuración +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atraccion atraccion = (Atraccion) o;
        return getHsDuración() == atraccion.getHsDuración() && Objects.equals(getUbicación(), atraccion.getUbicación());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUbicación(), getHsDuración());
    }
}
