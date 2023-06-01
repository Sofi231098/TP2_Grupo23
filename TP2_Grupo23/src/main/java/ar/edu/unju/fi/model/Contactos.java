package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Contactos {
	private String usuario;
	private String emailUsuario ;
	private String ciudadUsuario;
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
