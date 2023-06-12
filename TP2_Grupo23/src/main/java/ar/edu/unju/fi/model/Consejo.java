package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotEmpty;

@Component 
public class Consejo {
	@NotEmpty(message="debe poner un titulo")
	private String titulo;
	@NotEmpty(message="debe poner un consejo")
	private String Consejo;

	public Consejo() {
	
	}

	public Consejo(String titulo, String consejo) {
		super();
		this.titulo = titulo;
		Consejo = consejo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConsejo() {
		return Consejo;
	}

	public void setConsejo(String consejo) {
		Consejo = consejo;
	}
	
	
	

}