package ar.edu.unju.fi.model;


public class Consejo {
	private String titulo;
	private String Consejo;

	public Consejo() {
		// TODO Auto-generated constructor stub
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