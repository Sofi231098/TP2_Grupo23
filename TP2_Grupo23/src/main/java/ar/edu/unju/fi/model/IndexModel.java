package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class IndexModel {
	private static Integer nextId = 0;
	private String objetivos;
	private int id;
	
	public IndexModel() {
		nextId++;
		this.id = nextId;
	}

	public IndexModel(String objetivos) {
		super();
		this.objetivos = objetivos;
		nextId++;
		this.id = nextId;
	}

	public String getObjetivos() {
		return objetivos;
	}

	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
