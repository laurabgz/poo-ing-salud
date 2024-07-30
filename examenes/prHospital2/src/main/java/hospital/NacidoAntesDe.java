package hospital;

public class NacidoAntesDe implements Criterio {
	private int ano;
	
	public NacidoAntesDe(int ano) {
		this.ano = ano;
	}

	@Override
	public boolean cumpleCondicion(Paciente paciente, Habitacion habitacion) {
		return false;
	}
	

}
