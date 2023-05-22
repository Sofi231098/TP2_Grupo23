package ar.edu.unju.fi.model;

public class ModelConsejos {
	private String Titulo;
	private String Consejo;
	
	
	public ModelConsejos( ) {
	}
	
	public ModelConsejos(String titulo, String consejo) {
		super();
		Titulo = titulo;
		Consejo = consejo;
		
	}
	
	
	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getConsejo() {
		return Consejo;
	}
	public void setConsejo(String consejo) {
		Consejo = consejo;
	}

	}
