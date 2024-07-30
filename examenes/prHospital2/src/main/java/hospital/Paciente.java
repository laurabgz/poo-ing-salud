package hospital;

import java.util.Objects;

public class Paciente implements Comparable<Paciente>{
	private String nombre, apellidos, nuss;
	private int anoNacimiento;
	
	public Paciente(String nombre, String apellidos, String nuss, int anoNacimiento) throws HospitalException {
		if (nuss == null && nuss.isEmpty() && nuss.length() != 10 && nussValido(nuss)) {
			throw new HospitalException("Nuss incorrecto: " + nuss);
		}
		if (nombre == null && nombre.isEmpty()) {
			throw new HospitalException("Nuss incorrecto: " + nuss);
		}
		if (apellidos == null && apellidos.isEmpty()) {
			throw new HospitalException("Nuss incorrecto: " + nuss);
		}
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nuss = nuss;
		this.anoNacimiento = anoNacimiento;
		
	}
	
	private boolean nussValido(String nuss) {
		return nuss.indexOf(0, 8) % 19 == nuss.indexOf(8, 10);
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getNuss() {
		return nuss;
	}

	public int getAnoNacimiento() {
		return anoNacimiento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre.toUpperCase(), apellidos.toUpperCase(), nuss.toUpperCase(), anoNacimiento);
	}

	@Override
	public boolean equals(Object obj) {
		boolean same = false;
		
		if (obj instanceof Paciente) {
			Paciente otroPaciente = (Paciente) obj;
			same = nombre.equalsIgnoreCase(otroPaciente.nombre) && apellidos.equalsIgnoreCase(otroPaciente.apellidos)
					&& nuss.equalsIgnoreCase(otroPaciente.nuss) && anoNacimiento == otroPaciente.anoNacimiento;
		}
		
		return same;
	}

	@Override
	public int compareTo(Paciente o) {
		int res = Integer.compare(anoNacimiento, o.anoNacimiento);
		
		if (res == 0) {
			res = Integer.compare(Integer.parseInt(nuss), Integer.parseInt(o.nuss));
			
			if (res == 0) {
				res = apellidos.compareToIgnoreCase(o.apellidos);
				
				if (res == 0) {
					res = nombre.compareToIgnoreCase(o.nombre);
				}
			}
		}
		
		return res;
	}

	@Override
	public String toString() {
		return "Paciente [nombre=" + nombre + ", apellidos=" + apellidos + ", nuss=" + nuss
				+ ", anoDeNacimiento=" + anoNacimiento + "]";
	}
	
}



















