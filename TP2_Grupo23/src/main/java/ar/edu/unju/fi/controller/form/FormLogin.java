package ar.edu.unju.fi.controller.form;

import org.springframework.stereotype.Component;

@Component
public class FormLogin {
	private String usuario;
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
