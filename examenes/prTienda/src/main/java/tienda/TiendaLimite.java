package tienda;

public class TiendaLimite extends Tienda {
	private int limite;
	
	public TiendaLimite(int limite, String ficheroDatos) {
		super(ficheroDatos);
		
		if (limite < 0) {
			throw new TiendaException("Limite invalido: " + limite);
		}
		
		this.limite = limite;
	}

	@Override
	public void almacenar(Producto producto) {
		if (super.disponibles(producto) <= limite) {
			throw new TiendaException("No quedan unidades disponibles suficientes para ser trasladadas"
					+ "					a almacenadas");
		}
		
		super.almacenar(producto);
	}
	
	

}











