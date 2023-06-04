package ar.edu.unju.fi.controller.form;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotEmpty;

/**
 * @author Sofia Trinidad Yañez
 * clase,constructor y atributos de la pagina de logueo
 */
@Component
public class FormLogin {
	/**
	 * Validación donde el nombre del usuario no puede estar vacío.
	 */
	@NotEmpty(message="El campo no puede estar vacio")
	private String usuario;
	/**
	 * Validación donde la contraseña del usuario no puede estar vacía.
	 */
	@NotEmpty(message="El campo no puede estar vacio")
	private String password;
	
	/**
	 * constructor vacio
	 */
	public FormLogin() {
		
	} 
	
	/**
	 * constructor sobrecargado
	 * @param usuario  nombre del usuario
	 * @param password contraseña del usuario
	 */
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
