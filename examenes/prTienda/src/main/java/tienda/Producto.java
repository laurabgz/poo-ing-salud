package tienda;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Producto implements Comparable<Producto> {
	private String denominacion;
	private String codigo;
	private Set<String> caracteristicas;
	private int precio;
	
	public Producto(String denominacion, Set<String> caracteristicas, String codigo, int precio) {
		if (denominacion == null && denominacion.isEmpty()) {
			throw new TiendaException("Denominacion incorrecta: " + denominacion);
		}
		if (codigo == null && codigo.isEmpty()) {
			throw new TiendaException("Codigo incorrecto: " + codigo);
		}
		if (precio < 0) {
			throw new TiendaException("Precio incorrecto: " + precio);
		}
		
		this.denominacion = denominacion;
		this.caracteristicas = new HashSet<String>(caracteristicas);
		this.codigo = codigo;
		this.precio = precio;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public String getCodigo() {
		return codigo;
	}

	public Set<String> getCaracteristicas() {
		return caracteristicas;
	}

	public int getPrecio() {
		return precio;
	}

	@Override
	public String toString() {
		return "[" + denominacion + ", " + caracteristicas + ", " + codigo + ", " + precio + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(denominacion.toUpperCase(), precio);
	}

	@Override
	public boolean equals(Object obj) {
		boolean same = false;
		
		if (obj instanceof Producto) {
			Producto otroProducto = (Producto) obj;
			same = denominacion.equalsIgnoreCase(otroProducto.denominacion)
					|| precio == otroProducto.precio;
		}
		
		return same;
	}

	@Override
	public int compareTo(Producto o) {
		int res = denominacion.compareToIgnoreCase(o.denominacion);
		
		if (res == 0) {
			res = Integer.compare(precio, o.precio);
		}
		
		return res;
	}
	
	

}















