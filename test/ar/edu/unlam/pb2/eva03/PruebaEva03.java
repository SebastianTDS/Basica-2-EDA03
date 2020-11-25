package ar.edu.unlam.pb2.eva03;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.eva03.enumeradores.TipoDeBicicleta;
import ar.edu.unlam.pb2.eva03.enumeradores.TipoDeEvento;

public class PruebaEva03 {
	
	@Test
	public void queSePuedaCrearUnNadador() {
		Nadador nuevo = new Nadador(1, "Camila", "Espalda");

		assertEquals("Espalda", nuevo.getEstiloPreferido());
		assertEquals((Integer)1, nuevo.getNumeroDeSocio());
	}
	
	@Test
	public void queSePuedaCrearUnCorredor() {
		Corredor nuevo = new Corredor(2, "Carolina", 10000);
		nuevo.setCantidadDeKilometrosEntrenados(50000);
		
		assertEquals((Integer)10000, nuevo.getDistanciaPreferida());
		assertEquals((Integer)50000, nuevo.getCantidadDeKilometrosEntrenados());
		assertEquals((Integer)2, nuevo.getNumeroDeSocio());
	}
	
	@Test
	public void  queSePuedaCrearUnCiclista() {
		Ciclista nuevo = new Ciclista(3, "Enzo", "Ruta");

		assertEquals("Ruta", nuevo.getTipoDeBicicleta());
		assertEquals((Integer) 3, nuevo.getNumeroDeSocio());
	}
	
	@Test
	public void  queSePuedaCrearUnTriatleta() {
		Triatleta nuevo = new Triatleta(4, "Luna", "Olimpico", TipoDeBicicleta.TRIA);
		
		assertEquals("Olimpico", nuevo.getDistanciaPreferida());
		assertEquals(TipoDeBicicleta.TRIA, nuevo.getTipoDeBicicleta());
		assertEquals((Integer)4, nuevo.getNumeroDeSocio());
	}
	
	@Test
	public void  queSePuedanIncorporarDistintosDeportistas() {
		// El número de socio no se puede repetir
		Club actual = new Club("CARP");
		
		actual.agregarDeportista(new Corredor(1000, "Camila", 42000));
		actual.agregarDeportista(new Corredor(1001, "Natalia", 5000));
		actual.agregarDeportista(new Corredor(1002, "Jorge", 21000));
		actual.agregarDeportista(new Nadador(1003, "Lucrecia", "Pecho"));
		actual.agregarDeportista(new Triatleta(1004, "Tamara", "Olimpico", TipoDeBicicleta.RUTA));
		actual.agregarDeportista(new Ciclista(1005, "Alberto", "Mountain"));
		actual.agregarDeportista(new Ciclista(1006, "Domingo", "BMX"));
		actual.agregarDeportista(new Corredor(1007, "Luciana", 10000));
		actual.agregarDeportista(new Nadador(1008, "Luna", "Crol"));
		actual.agregarDeportista(new Nadador(1009, "Victor", "Mariposa"));
		actual.agregarDeportista(new Triatleta(1004, "Cecilia", "Ironman", TipoDeBicicleta.TRIA));
			
		assertEquals((Integer) 10, actual.getCantidadSocios());		
	}
	
	@Test (expected = NoEstaPreparado.class)
	public void  queUnCorredorNoSePuedaInscribirEnUnaCarreraDeNatacion () throws NoEstaPreparado{	
		// En las carreras de natación sólo pueden inscribirse los que sean INadador
		Deportista celeste = new Corredor(1000, "Celeste", 10000);
		Club actual = new Club("Sitas");
		actual.agregarDeportista(celeste);
		actual.crearEvento(TipoDeEvento.CARRERA_NATACION_EN_AGUAS_ABIERTAS, "Maraton de aguas abiertas");
		
		assertNotEquals((Integer)1, actual.inscribirEnEvento("Maraton de aguas abiertas", celeste));		
	}
	
	@Test (expected = NoEstaPreparado.class)
	public void  queUnCorredorNoSePuedaInscribirEnUnTriatlon () throws NoEstaPreparado{		
		// En los triatlones sólo pueden inscribirse los que sean INadador & ICiclista
		Deportista celeste = new Corredor(1000, "Celeste", 10000);
		Club actual = new Club("Sitas");
		
		actual.crearEvento(TipoDeEvento.TRIATLON_IRONMAN, "Triatlon Khona");
		
		assertNotEquals((Integer)1, actual.inscribirEnEvento("Triatlon Khona", celeste));		
	}
	
	@Test
	public void  queUnCorredorPuedaCorrerUnaMaraton() throws NoEstaPreparado{		
		Deportista celeste = new Corredor(999, "Celeste", 42000);
		Club actual = new Club("Moron");
				
		((Corredor)celeste).setCantidadDeKilometrosEntrenados(100000);
		actual.crearEvento(TipoDeEvento.CARRERA_42K, "Maraton de New York");
		
		assertEquals((Integer)1, actual.inscribirEnEvento("Maraton de New York", celeste));			
	}
	
	/* Tests Adicionales */
	
	@Test 
	public void  queUnTriatletaPuedaParticiparEnUnTriatlon () throws NoEstaPreparado{		
		Deportista celeste = new Triatleta(4, "Celeste", "Olimpico", TipoDeBicicleta.TRIA);
		Club actual = new Club("Sitas");
		
		actual.crearEvento(TipoDeEvento.TRIATLON_IRONMAN, "Triatlon Khona");
		
		assertEquals((Integer)1, actual.inscribirEnEvento("Triatlon Khona", celeste));		
	}
	
	@Test 
	public void  queUnNadadorPuedaParticiparEnUnaCarreraDeNatacion () throws NoEstaPreparado{		
		Deportista camila = new Nadador(1, "Camila", "Espalda");
		Club actual = new Club("Sitas");
		
		actual.crearEvento(TipoDeEvento.CARRERA_NATACION_EN_AGUAS_ABIERTAS, "Carrera Rio de la Plata");
		
		assertEquals((Integer)1, actual.inscribirEnEvento("Carrera Rio de la Plata", camila));		
	}
	
	@Test
	public void queNoSeInscribanDosPersonasIgualesAlMismoEvento() throws NoEstaPreparado {
		Deportista camila = new Nadador(1, "Camila", "Espalda");
		Club actual = new Club("Sitas");
		
		actual.crearEvento(TipoDeEvento.CARRERA_NATACION_EN_AGUAS_ABIERTAS, "Carrera Rio de la Plata");
		
		assertEquals((Integer)1, actual.inscribirEnEvento("Carrera Rio de la Plata", camila));
		assertNotEquals((Integer)2, actual.inscribirEnEvento("Carrera Rio de la Plata", camila));
	}
	
	@Test
	public void queUnTriatletaSePuedaAnotarEnTodosLosEventos() throws NoEstaPreparado {
		Deportista andy = new Triatleta(4, "Andres", "Olimpico", TipoDeBicicleta.TRIA);
		Club actual = new Club("Sitas");
		
		actual.crearEvento(TipoDeEvento.CARRERA_NATACION_EN_AGUAS_ABIERTAS, "Carrera Rio de la Plata");
		actual.crearEvento(TipoDeEvento.CARRERA_42K, "Carrera 42Km");
		actual.crearEvento(TipoDeEvento.TRIATLON_OLIMPICO, "Triatlon Olimpico");
		
		assertEquals((Integer)1, actual.inscribirEnEvento("Carrera Rio de la Plata", andy));
		assertEquals((Integer)1, actual.inscribirEnEvento("Carrera 42Km", andy));
		assertEquals((Integer)1, actual.inscribirEnEvento("Triatlon Olimpico", andy));
	}
}
