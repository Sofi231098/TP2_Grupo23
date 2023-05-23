package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;




public class Consejo {

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechadeingreso;
	private String titulo;

	public Consejo() {
		// TODO Auto-generated constructor stub
	}

	public Consejo(LocalDate fechadeingreso, String titulo) {
		super();
		this.fechadeingreso = fechadeingreso;
		this.titulo = titulo;
	}

	public LocalDate getFechadeingreso() {
		return fechadeingreso;
	}

	public void setFechadeingreso(LocalDate fechadeingreso) {
		this.fechadeingreso = fechadeingreso;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}