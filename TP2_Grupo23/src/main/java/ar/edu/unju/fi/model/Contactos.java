package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Component
public class Contactos {
	@NotEmpty(message="El nombre no puede estar vacio")
	private String usuario;
	@Email(message="Debe introducir un e-mail con formato valido")
	@NotEmpty(message="El e-mail no puede estar vacio")
	private String emailUsuario ;
	@NotBlank(message="Ingrese una provincia para mejorar la comunicacion")
	private String ciudadUsuario;
	@Size(min=20, max=150, message="el mensaje debe contener entre 20 y 150 caracteres")
	private String mensajeUsuario ;
	
	public Contactos(){
			
		}
	
	public Contactos(String usuario, String emailUsuario, String ciudadUsuario, String mensajeUsuario) {
		super();
		this.usuario = usuario;
		this.emailUsuario = emailUsuario;
		this.ciudadUsuario = ciudadUsuario;
		this.mensajeUsuario = mensajeUsuario;
	}

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
	
	@Override
	public String toString() {
		return "Contactos [usuario=" + usuario + ", emailUsuario=" + emailUsuario + ", ciudadUsuario=" + ciudadUsuario
				+ ", mensajeUsuario=" + mensajeUsuario + "]";
	}

}
