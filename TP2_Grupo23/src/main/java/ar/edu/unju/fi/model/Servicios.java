package ar.edu.unju.fi.model;

public class Servicios {

	private String paseador;
	private String telefono;
	private String dias;
	private String horarios;
	
	public Servicios() {
		// TODO Auto-generated constructor stub
	}

	public Servicios(String paseador, String telefono, String dias, String horarios) {
		super();
		this.paseador = paseador;
		this.telefono = telefono;
		this.dias = dias;
		this.horarios = horarios;
	}

	public String getPaseador() {
		return paseador;
	}

	public void setPaseador(String paseador) {
		this.paseador = paseador;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDias() {
		return dias;
	}

	public void setDias(String dias) {
		this.dias = dias;
	}

	public String getHorarios() {
		return horarios;
	}

	public void setHorarios(String horarios) {
		this.horarios = horarios;
	}
	
}
