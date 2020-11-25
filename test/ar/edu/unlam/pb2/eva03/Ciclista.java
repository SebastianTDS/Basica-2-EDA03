package ar.edu.unlam.pb2.eva03;

public class Ciclista extends Deportista{

	private String tipoDeBicicleta;
	
	public Ciclista(Integer numeroDeSocio, String nombreSocio, String tipoDeBicicleta) {
		super(numeroDeSocio, nombreSocio);
		this.tipoDeBicicleta = tipoDeBicicleta;
	}

	public String getTipoDeBicicleta() {
		return tipoDeBicicleta;
	}

	public void setTipoDeBicicleta(String tipoDeBicicleta) {
		this.tipoDeBicicleta = tipoDeBicicleta;
	}

}
