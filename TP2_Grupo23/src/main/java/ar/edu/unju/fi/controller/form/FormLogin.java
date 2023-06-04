package ar.edu.unju.fi.controller.form;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotEmpty;

@Component
public class FormLogin {
	@NotEmpty(message="El campo no puede estar vacio")
	private String usuario;
	@NotEmpty(message="El campo no puede estar vacio")
	private String password;
	
	public FormLogin() {
		
	} 
	
	public FormLogin(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;

	} 


	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
