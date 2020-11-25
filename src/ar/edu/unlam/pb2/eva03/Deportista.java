package ar.edu.unlam.pb2.eva03;

public class Deportista {
	private Integer numeroDeSocio;
	private String nombreSocio;
	
	public Deportista(Integer numeroDeSocio, String nombreSocio) {
		this.numeroDeSocio = numeroDeSocio;
		this.setNombreSocio(nombreSocio);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroDeSocio == null) ? 0 : numeroDeSocio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Deportista))
			return false;
		Deportista other = (Deportista) obj;
		if (numeroDeSocio == null) {
			if (other.numeroDeSocio != null)
				return false;
		} else if (!numeroDeSocio.equals(other.numeroDeSocio))
			return false;
		return true;
	}

	public Integer getNumeroDeSocio() {
		return numeroDeSocio;
	}

	public String getNombreSocio() {
		return nombreSocio;
	}

	public void setNombreSocio(String nombreSocio) {
		this.nombreSocio = nombreSocio;
	}
}
