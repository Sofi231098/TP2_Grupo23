package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;


/**
 * Representa una sucursal del sistema
 * @author Marisol P Castillo
 * @version 1.0 date: 01/06/23
 *
 */



@Component
public class Sucursal {
	
	@Positive(message="Debe ingresar un número válido.")
	/**Representa el código de la sucursal*/private String codigo;
	@Past(message="")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull(message="Este campo no puede quedar sin una fecha.")
	@Past(message="La fecha debe ser menor a la fecha actual.")
	/**Representa la fecha de inicio de la sucursal*/private LocalDate fechaInicio;
	@NotEmpty(message="El nombre no puede quedar vacío.")
	/**Representa el nombre de la sucursal*/private String nombre;
	@NotBlank(message="Debe seleccionar una provincia.")
	/**Representa la provincia de la sucursal*/private String provincia;
	@Size(min=5, max=100, message="La dirección debe tener entre 5 y 100 caracteres.")
	/**Representa la dirección de la sucursal*/private String direccion;
	@NotEmpty(message="Debe ingresar un número de teléfono.")  //opcional creo yo no todos tienen telefono por ej si es nueva la sucursal.
	/**Representa el teléfono de la sucursal*/private String telefono;
	@NotBlank(message="Debe seleccionar un horario de atención.")
	/**Representa el horario de la sucursal*/private String horario;
	
	
	
	//--------------Constructores-------------------
	
	/**
	 * Constructor por defecto
	 */
	public Sucursal() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Constructor Paramétrizado
	 * @param codigo es el código de la sucursal
	 * @param fechaInicio es la fecha de inicio de la sucursal
	 * @param nombre es el nombre de la sucursal
	 * @param provincia es la provincia de la sucursal
	 * @param direccion es la dirección de la sucursal
	 * @param telefono es el telefono de la sucursal
	 * @param horario es el horario de la sucursal
	 */
	
	public Sucursal(String codigo, LocalDate fechaInicio, String nombre, String provincia, String direccion, String telefono, String horario) {
		
		this.codigo = codigo;
		this.fechaInicio = fechaInicio;
		this.nombre = nombre;
		this.provincia = provincia;
		this.direccion = direccion;
		this.telefono = telefono;
		this.horario = horario;
		
	}
	
/**
 * Getters y Setters
 * @return
 */

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}


	
	
	
	
	
	
	
	
	
}
	