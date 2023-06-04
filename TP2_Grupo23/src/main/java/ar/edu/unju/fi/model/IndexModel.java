package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Component
public class IndexModel {
	private static Integer nextId = 0;
	@NotEmpty(message="El campo no puede estar vacio")
	@Size(min=20, max=150, message="el objetivo debe contener entre 20 y 150 caracteres")
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
