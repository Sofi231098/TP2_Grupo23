package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotEmpty;

@Component 
public class Consejo {
	@NotEmpty(message="debe poner un titulo")
	private String titulo;
	@NotEmpty(message="debe poner un consejo")
	private String consejo;

	public Consejo() {
	
	}

	public Consejo(@NotEmpty(message = "debe poner un titulo") String titulo,
			@NotEmpty(message = "debe poner un consejo") String consejo) {
		super();
		this.titulo = titulo;
		this.consejo = consejo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConsejo() {
		return consejo;
	}

	public void setConsejo(String consejo) {
		this.consejo = consejo;
	}

}