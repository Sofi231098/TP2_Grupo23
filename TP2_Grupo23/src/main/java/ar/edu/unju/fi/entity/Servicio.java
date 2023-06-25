package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/**
 * Representa una sucursal del sistema
 * @author Flores Fabricio A 
 * @version 2.0 date: 01/06/23
 *
 */


@Component
@Entity
@Table(name="servicios")
public class Servicio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="serv_id")
	private Long id;
	
	@NotEmpty(message="El nombre no puede quedar vacío.")
	@Size(min=10,max=50,message ="Ingrese su nombre completo")
	/**Representa el nombre del paseador*/
	
	@Column (name="serv_paseador",length = 50, nullable = false)
	private String paseador;
	
	/**@NotEmpty(message="El nombre no puede quedar vacío.")*/
	@Size(min=10,max=20,message ="Ingrese un numero valido. Ej: 388-4123456")
	
	/**Representa el numero de telefono del paseador*/
	@Column(name="serv_telefono",length = 20, nullable = false)
	private String telefono;
	
	@NotBlank(message="Este campo es obligatorio.")
	/**Representa los dias de paseo que tiene el paseador*/
	@Column(name="serv_dias")
	private String dias;
	
	@NotBlank(message="Este campo es obligatorio.")
	/**Representa los horarios de paseo que tiene el paseador*/
	@Column(name="serv_horarios")
	private String horarios;
	
	@Column(name="serv_estado")
	private boolean estado;
	
	//--------------Constructores-------------------
	
		/**
		 * Constructor por defecto
		 */
	
	
	public Servicio() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor Paramétrizado
	 * @param paseador es el nombre del servicio
	 * @param telefono es el telefono del servicio
	 * @param dias es el dia del servicio
	 * @param horarios es el horario del servicio
	 * @param estado es para acicnale un valor booleano en Mysql
	 * @param id se una en Mysql para poder general un id a cada paseador que solo se vera en la Base de datos 
	 */
	
	

	public Servicio( Long id,String paseador, String telefono, String dias, String horarios,boolean estado) {
		super();
		this.id =id;
		this.paseador = paseador;
		this.telefono = telefono;
		this.dias = dias;
		this.horarios = horarios;
		this.estado = estado;
	}

	/**
	 * Getters y Setters
	 * @return
	 */
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}