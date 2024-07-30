package agenda;

import java.util.Objects;

public class Contacto {
	private String nombre, apellido, correoElectronico, telefonoContacto;
	
	public Contacto(String nombre, String apellido, String correoElectronico, String telefonoContacto) {
		if (nombre == null || nombre.isEmpty()) {
			throw new AgendaException("Nombre incorrecto: " + nombre);
		}
		if (apellido == null || apellido.isEmpty()) {
			throw new AgendaException("Apellido incorrecto: " + apellido);
		}
		if (correoElectronico == null || correoElectronico.isEmpty()) {
			throw new AgendaException("Correo Electronico incorrecto: " + correoElectronico);
		}
		if (telefonoContacto == null || telefonoContacto.isEmpty()) {
			throw new AgendaException("Telefono de Contacto incorrecto: " + telefonoContacto);
		}
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.correoElectronico = correoElectronico;
		this.telefonoContacto = telefonoContacto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.isEmpty()) {
			throw new AgendaException("Nombre incorrecto: " + nombre);
		}
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		if (apellido == null || apellido.isEmpty()) {
			throw new AgendaException("Apellido incorrecto: " + apellido);
		}
		this.apellido = apellido;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		if (correoElectronico == null || correoElectronico.isEmpty()) {
			throw new AgendaException("Correo Electronico incorrecto: " + correoElectronico);
		}
		this.correoElectronico = correoElectronico;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		if (telefonoContacto == null || telefonoContacto.isEmpty()) {
			throw new AgendaException("Telefono de Contacto incorrecto: " + telefonoContacto);
		}
		this.telefonoContacto = telefonoContacto;
	}

	@Override
	public String toString() {
		return "Contacto (" + nombre + "," + apellido + "," + telefonoContacto + "," + correoElectronico + ")";
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, correoElectronico, nombre, telefonoContacto);
	}

	@Override
	public boolean equals(Object obj) {
		boolean same = false;
		
		if (obj instanceof Contacto) {
			Contacto otroContacto = (Contacto) obj;
			same = nombre.equalsIgnoreCase(otroContacto.nombre) ||
					apellido.equalsIgnoreCase(otroContacto.apellido) ||
					correoElectronico.equalsIgnoreCase(otroContacto.correoElectronico) ||
					telefonoContacto.equalsIgnoreCase(otroContacto.telefonoContacto);
		}
		
		return same;
	}
	
	
	
	

}















