package hospital;

import java.util.Objects;

public class Habitacion implements Comparable<Habitacion> {
	private int planta, numero;
	
	public Habitacion(int planta, int numero) {
		this.planta = planta;
		this.numero = numero;
	}

	public int getPlanta() {
		return planta;
	}

	public void setPlanta(int planta) {
		this.planta = planta;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero, planta);
	}

	@Override
	public boolean equals(Object obj) {
		boolean same = false;
		
		if (obj instanceof Habitacion) {
			Habitacion otraHabitacion = (Habitacion) obj;
			same = planta == otraHabitacion.planta && numero == otraHabitacion.numero;
		}
		
		return same;
	}

	@Override
	public int compareTo(Habitacion o) {
		int res = Integer.compare(planta, o.planta);
		
		if (res == 0) {
			res = Integer.compare(numero, o.numero);
		}
		
		return 0;
	}

	@Override
	public String toString() {
		return "Habitacion [planta=" + planta + ", numero=" + numero + "]";
	}
	
	
	

}











