package unlam.paradigmas.tp.tierramedia.dto;

import java.util.Objects;

public class Atraccion {
    private String nombre;
    private int costo;
    private float hsDuración;
    private int cupos;
    private String tipo;///fijarse si esta bien como atributo

   
    public Atraccion(String nombre, int costo, float hsDuración, int cupos, String tipo) {
		super();
		this.nombre = nombre;
		this.costo = costo;
		this.hsDuración = hsDuración;
		this.cupos = cupos;
		this.tipo = tipo;
	}

	public float getHsDuración() {
        return hsDuración;
    }
	

    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public int getCupos() {
		return cupos;
	}

	public void setCupos(int cupos) {
		this.cupos = cupos;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setHsDuración(int hsDuración) {
        this.hsDuración = hsDuración;
    }

	@Override
	public String toString() {
		return "Atraccion [nombre=" + nombre + ", costo=" + costo + ", hsDuración=" + hsDuración + ", cupos=" + cupos
				+ ", tipo=" + tipo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(costo, cupos, hsDuración, nombre, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return costo == other.costo && cupos == other.cupos
				&& Float.floatToIntBits(hsDuración) == Float.floatToIntBits(other.hsDuración)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(tipo, other.tipo);
	}
	
	
   
}
