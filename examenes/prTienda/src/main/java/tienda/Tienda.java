package tienda;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Tienda {
	private SortedMap<Producto, Integer> disponibles;
	private SortedMap<Producto, Integer> almacenadas;
	
	public Tienda(String ficheroDatos) {
		disponibles = new TreeMap<Producto, Integer>();
		almacenadas = new TreeMap<Producto, Integer>();
		leerDatos(ficheroDatos);
	}
	
	private void leerDatos(String ficheroDatos){
		File file = new File(ficheroDatos);
		
		try (Scanner sc = new Scanner(file)) {
			leerDatos(sc);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void leerDatos(Scanner sc) {
		while (sc.hasNextLine()) {
			String linea = sc.nextLine();
			
			try {
				String[] datos = linea.split("%");
				
				if (datos.length != 5) {
					throw new TiendaException("Datos incorrectos: " + datos);
				}
				
				String denominacion = datos[0].trim();
				
				Set<String> caracteristicas = new HashSet<String>();
				String caracteristicasString = datos[1];
				String[] caracteristicasArray = caracteristicasString.split(",");
				for (String caracteristica: caracteristicasArray) {
					caracteristicas.add(caracteristica.trim());
				}
				
				String codigo = datos[2].trim();
				
				int precio = Integer.parseInt(datos[3]);
				
				Producto producto = new Producto(denominacion, caracteristicas, codigo, precio);
				disponibles.put(producto, disponibles.getOrDefault(producto, 1));
			} catch (TiendaException e) {
				throw new TiendaException();
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Precio incorrecto");
			}
			
		}
	}
	
	public void agregar(Producto producto, int unidades) {
		if (unidades < 1) {
			throw new TiendaException("Unidades incorrectas");
		}
		disponibles.put(producto, disponibles.getOrDefault(producto, 1));
	}
	
	public int disponibles(Producto producto) {
		return disponibles.get(producto);
	}
	
	public Producto producto(String denominacion, int precio) {
		Producto productoEncontrado = null;
		
		for (Producto p: disponibles.keySet()) {
			if (p.getDenominacion().equalsIgnoreCase(denominacion) || p.getPrecio() == precio) {
				productoEncontrado = p;
			}
		}
		
		return productoEncontrado;
	}
	
	public Set<Producto> productosConCaracteristicas(String caracteristica) {
		Set<Producto> productos = new HashSet<Producto>();
		
		for (Producto p: disponibles.keySet()) {
			for (String caracteristicaProducto: p.getCaracteristicas()) {
				if (caracteristicaProducto.equalsIgnoreCase(caracteristica)) {
					productos.add(p);
				}
			}
		}
		
		return productos;
	}
	
	public void almacenar(Producto producto) {
		if (!disponibles.containsKey(producto) && disponibles.get(producto) <= 0) {
			throw new TiendaException("No hay unidades suficientes del producto.");
		}
		
		int unidadesDisponibles = disponibles.get(producto);
		disponibles.put(producto, unidadesDisponibles - 1);
		
		if (disponibles.get(producto) == 0) {
			disponibles.remove(producto);
		}
		
		almacenadas.put(producto, almacenadas.getOrDefault(producto, 0) + 1);
	}
	
	public void recuperar(Producto producto) {
		if (!almacenadas.containsKey(producto)) {
			throw new TiendaException("El producto no está en las unidades almacenadas: " + producto);
		}
		
		int unidadesAlmacenadas = almacenadas.get(producto);
		disponibles.put(producto, disponibles.getOrDefault(producto, 0) + 1);
		almacenadas.put(producto, unidadesAlmacenadas - 1);
		
		if (almacenadas.get(producto) == 0) {
			almacenadas.remove(producto);
		}
	}
	
	public void guardarProductos(String nombreFichero) {
		try (PrintWriter pw = new PrintWriter(new FileWriter(nombreFichero))) {
			guardarProductos(pw);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void guardarProductos(PrintWriter pw) {
		pw.println("Productos:\n");

		for (Producto producto: disponibles.keySet()) {
			pw.println(producto);
			pw.println("Disponibles: " + disponibles.get(producto) + 
						" Almacenados:" + almacenadas.get(producto));
		}
	}

}















