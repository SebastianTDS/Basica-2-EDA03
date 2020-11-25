package ar.edu.unlam.pb2.eva03;

import ar.edu.unlam.pb2.eva03.interfaces.ICorredor;

public class Corredor extends Deportista implements ICorredor{

	private Integer kilometrosEntrenados;
	private Integer distanciaPreferida;
	
	public Corredor(Integer numeroDeSocio, String nombreSocio, Integer distanciaPreferida) {
		super(numeroDeSocio, nombreSocio);
		this.setDistanciaPreferida(distanciaPreferida);
	}

	@Override
	public void setCantidadDeKilometrosEntrenados(Integer km) {
		this.kilometrosEntrenados = km;
	}

	@Override
	public Integer getCantidadDeKilometrosEntrenados() {
		return kilometrosEntrenados;
	}

	public Integer getDistanciaPreferida() {
		return distanciaPreferida;
	}

	public void setDistanciaPreferida(Integer distanciaPreferida) {
		this.distanciaPreferida = distanciaPreferida;
	}
	
}
