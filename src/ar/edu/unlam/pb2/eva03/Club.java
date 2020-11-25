package ar.edu.unlam.pb2.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ar.edu.unlam.pb2.eva03.enumeradores.TipoDeEvento;

public class Club {

	private String nombre;
	private Set<Deportista> socios;
	private Map<String, Evento> competencias;
	
	
	public Club(String nombre) {
		this.nombre = nombre;
		this.socios = new HashSet<Deportista>();
		this.competencias = new HashMap<String,Evento>();
	}


	public void agregarDeportista(Deportista deportista) {
		this.socios.add(deportista);
	}


	public Object getCantidadSocios() {
		return this.socios.size();
	}


	public void crearEvento(TipoDeEvento evento, String desc) {
		this.competencias.putIfAbsent(desc, new Evento(evento));
	}


	public Integer inscribirEnEvento(String evento, Deportista depor) throws NoEstaPreparado {
		return this.competencias.get(evento).inscribirParticipante(depor);
	}
	
	
}
