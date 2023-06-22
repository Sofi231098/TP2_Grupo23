package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/**
 * Representa una sucursal del sistema
 * @author Flores Fabricio A 
 * @version 1.0 date: 01/06/23
 *
 */


@Component
public class Servicios {
	@NotEmpty(message="El nombre no puede quedar vacío.")
	@Size(min=10,max=50,message ="Ingrese su nombre completo")
	/**Representa el nombre del paseador*/ private String paseador;
	@NotEmpty(message="El nombre no puede quedar vacío.")
	@Size(min=10,max=20,message ="Ingrese un numero valido. Ej: 388-4123456")
	/**Representa el numero de telefono del paseador*/private String telefono;
	@NotBlank(message="Este campo es obligatorio.")
	/**Representa los dias de paseo que tiene el paseador*/private String dias;
	@NotBlank(message="Este campo es obligatorio.")
	/**Representa los horarios de paseo que tiene el paseador*/private String horarios;
	
	
	//--------------Constructores-------------------
	
		/**
		 * Constructor por defecto
		 */
	
	
	public Servicios() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor Paramétrizado
	 * @param paseador es el nombre del servicio
	 * @param telefono es el telefono del servicio
	 * @param dias es el dia del servicio
	 * @param horarios es el horario del servicio
	 */
	
	

	public Servicios(String paseador, String telefono, String dias, String horarios) {
		super();
		this.paseador = paseador;
		this.telefono = telefono;
		this.dias = dias;
		this.horarios = horarios;
	}

	/**
	 * Getters y Setters
	 * @return
	 */
	
	public String getPaseador() {
		return paseador;
	}

	public void setPaseador(String paseador) {
		this.paseador = paseador;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDias() {
		return dias;
	}

	public void setDias(String dias) {
		this.dias = dias;
	}

	public String getHorarios() {
		return horarios;
	}

	public void setHorarios(String horarios) {
		this.horarios = horarios;
	}
	
}
