package ar.edu.unlam.pb2.eva03;

import ar.edu.unlam.pb2.eva03.enumeradores.TipoDeBicicleta;
import ar.edu.unlam.pb2.eva03.interfaces.ICiclista;
import ar.edu.unlam.pb2.eva03.interfaces.INadador;

public class Triatleta extends Deportista implements INadador, ICiclista{

	private String distanciaPreferida;
	private TipoDeBicicleta tipoDeBicicleta;
	
	public Triatleta(Integer numeroDeSocio, String nombreSocio, String distanciaPreferida, TipoDeBicicleta bici) {
		super(numeroDeSocio, nombreSocio);
		this.setDistanciaPreferida(distanciaPreferida);
		this.setTipoDeBicicleta(bici);
	}

	public String getDistanciaPreferida() {
		return distanciaPreferida;
	}

	public void setDistanciaPreferida(String distanciaPreferida) {
		this.distanciaPreferida = distanciaPreferida;
	}

	public TipoDeBicicleta getTipoDeBicicleta() {
		return tipoDeBicicleta;
	}

	public void setTipoDeBicicleta(TipoDeBicicleta tipoDeBicicleta) {
		this.tipoDeBicicleta = tipoDeBicicleta;
	}
	
}
