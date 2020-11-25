package ar.edu.unlam.pb2.eva03;

import ar.edu.unlam.pb2.eva03.interfaces.INadador;

public class Nadador extends Deportista implements INadador{

	private String estiloPreferido;
	
	public Nadador(Integer numeroDeSocio, String nombreSocio, String estiloPreferido) {
		super(numeroDeSocio, nombreSocio);
		this.setEstiloPreferido(estiloPreferido);
	}

	public String getEstiloPreferido() {
		return estiloPreferido;
	}

	public void setEstiloPreferido(String estiloPreferido) {
		this.estiloPreferido = estiloPreferido;
	}

}
