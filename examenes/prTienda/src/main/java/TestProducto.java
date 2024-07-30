import java.util.HashSet;
import java.util.Set;
import tienda.*;

public class TestProducto {

	public static void main(String[] args) {
		Set<String> caracteristicas = new HashSet<>();
		caracteristicas.add("procesador ACME");
		caracteristicas.add("8GB RAM" );
		caracteristicas.add("1TB HDD");
		
		Producto producto1 = new Producto("ordenador de sobremesa", caracteristicas, "informática" , 700);
		Producto producto2 = new Producto("Ordenador de Sobremesa", new HashSet<>(), "hardware", 700);
		
		System.out.println(producto1);
		System.out.println(producto2);
		System.out.println("Los productos " + ((producto1.equals(producto2)) ? "" : "no ") + "son iguales");

	}

}
