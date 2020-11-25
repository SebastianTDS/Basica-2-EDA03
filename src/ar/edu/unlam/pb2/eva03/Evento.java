package ar.edu.unlam.pb2.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ar.edu.unlam.pb2.eva03.enumeradores.TipoDeEvento;
import ar.edu.unlam.pb2.eva03.interfaces.ICiclista;
import ar.edu.unlam.pb2.eva03.interfaces.ICorredor;
import ar.edu.unlam.pb2.eva03.interfaces.INadador;

public class Evento {

	private TipoDeEvento tipo;
	private Integer numeroDeInscripcion;
	private Map<Integer, Deportista> participantes;
	
	
	public Evento(TipoDeEvento tipo) {
		this.setTipo(tipo);
		this.participantes = new HashMap<Integer,Deportista>();
		this.numeroDeInscripcion = 0;
	}
	
	public Integer inscribirParticipante(Deportista depor) throws NoEstaPreparado {
		switch(this.tipo) {
		case CARRERA_NATACION_EN_AGUAS_ABIERTAS:
		case CARRERA_NATACION_EN_PICINA:
			if(!(depor instanceof INadador))
				throw new NoEstaPreparado();
			break;
		case TRIATLON_IRONMAN:
		case TRIATLON_MEDIO:
		case TRIATLON_OLIMPICO:
		case TRIATLON_SHORT:
		case DUATLON:
			if(!(depor instanceof INadador) && !(depor instanceof ICiclista))
				throw new NoEstaPreparado();
			break;
		case CARRERA_10K:
		case CARRERA_21K:
		case CARRERA_42K:
		case CARRERA_5K:
			if(!(depor instanceof ICorredor))
				throw new NoEstaPreparado();
			break;
		}
		if(this.participantes.containsValue(depor)) return this.numeroDeInscripcion;
		
		this.participantes.putIfAbsent(numeroDeInscripcion, depor);
		return ++this.numeroDeInscripcion;
	}


	public TipoDeEvento getTipo() {
		return tipo;
	}


	public void setTipo(TipoDeEvento tipo) {
		this.tipo = tipo;
	}


	public Integer getNumeroDeInscripcionSiguiente() {
		return numeroDeInscripcion;
	}
}
