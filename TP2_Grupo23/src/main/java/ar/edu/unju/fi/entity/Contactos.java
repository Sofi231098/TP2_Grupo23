package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/**
 * @author Sofia Trinidad Yañez
 */
@Component
public class Contactos {
	/**
	 * Validacion donde el nombre del usuario no puede estar vacio
	 */
	@NotEmpty(message="El nombre no puede estar vacio")
	private String usuario;
	/**
	 * Validacion donde elcorreo del usuario debe tener formato de e-mail y no puede estar vacio
	 */
	@Email(message="Debe introducir un e-mail con formato valido")
	@NotEmpty(message="El e-mail no puede estar vacio")
	private String emailUsuario ;
	/**
	 * La ciudad del usuario no puede estar en blanco
	 */
	@NotBlank(message="Ingrese una provincia para mejorar la comunicacion")
	private String ciudadUsuario;
	/**
	 * Validacion donde el mensaje no debe estar vacío y solo puede contener entre 20 y 150 caracteres
	 */
	@Size(min=20, max=150, message="el mensaje debe contener entre 20 y 150 caracteres")
	private String mensajeUsuario ;
	
	/**
	 *  constructor vacio y sobrecargado de la clase Contactos
	 */
	public Contactos(){
			
		}
	
	public Contactos(String usuario, String emailUsuario, String ciudadUsuario, String mensajeUsuario) {
		super();
		this.usuario = usuario;
		this.emailUsuario = emailUsuario;
		this.ciudadUsuario = ciudadUsuario;
		this.mensajeUsuario = mensajeUsuario;
	}

	/**
	 * Getters y Setters de cada atributo
	 */
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getCiudadUsuario() {
		return ciudadUsuario;
	}

	public void setCiudadUsuario(String ciudadUsuario) {
		this.ciudadUsuario = ciudadUsuario;
	}

	public String getMensajeUsuario() {
		return mensajeUsuario;
	}

	public void setMensajeUsuario(String mensajeUsuario) {
		this.mensajeUsuario = mensajeUsuario;
	}
	
	/**
	 *Devuelve los datos ingresados, se pueden ver en la consola
	 */
	@Override
	public String toString() {
		return "Contactos [usuario=" + usuario + ", emailUsuario=" + emailUsuario + ", ciudadUsuario=" + ciudadUsuario
				+ ", mensajeUsuario=" + mensajeUsuario + "]";
	}

}
