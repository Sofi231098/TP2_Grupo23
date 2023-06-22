package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;



/**
 * Representa los articulos del sistema
 * @author Farja Naima Blanca
 * @version 1.0 date: 03/06/2023
 */
@Component
public class Producto {
	
	@NotNull(message="El ID del artículo debe ser registrado")
	/**Representa el ID del articulo*/private Long id;
	@NotEmpty(message="El nombre del artículo no puede estar vacío")
	/**Representa el nombre del articulo*/private String nombre;
	@NotEmpty(message="Debe agregar una descripción breve del producto")
	/**Representa la descripcion del articulo*/ private String descripcion;
	@NotNull(message="Se requiere proporcionar un valor para el precio del articulo")
	/**Representa el precio del articulo*/private Double precio;
	@NotNull(message="El campo descuento no puede ser nulo debe ser entre 0% y 50%")
	/**Representa el descuento que se va a realizar en el articulo*/private Integer descuento;
    @NotBlank(message="Debe elegir una categoría")
    /**Representa la categoria del articulo*/private String  categoria;
    
    //----------Constructores--------------
    
    /**
     * Constructores por defecto
     */
    
    public Producto() {
		// TODO Auto-generated constructor stub
	}
    
    /**
     * Constructor parametrisado
     * @param codigo es el codigo del articulo
     * @param nombre es el nombre del articulo
     * @param precio es el precio del articulo
     * @param descuento es el descuento que se le va a realizar al articulo
     * @param categoria es la categoria del articulo
     */	
	
	public Producto(@NotNull(message = "Debe ingresar el codigo del articulo") Long id,
			@NotEmpty(message = "Este campo no puede estar vacio") String nombre,
			@NotEmpty(message = "Debe agregar una descripcion breve del producto") String descripcion,
			@NotNull(message = "El valor debe ser un numero positivo") Double precio,
			@NotNull(message = "El descuento debe ser de entre 0% y 50%") Integer descuento,
			@NotBlank(message = "Debe elegir una categoria") String categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.descuento = descuento;
		getPreciodescuento();
		this.categoria = categoria;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}

	public double getPreciodescuento() {
		if (descuento >= 0 || descuento <= 50) {
			
			return (precio -(precio * descuento)/100);
			
		}else {			
			
		return precio;
		}
	}
	public void setPreciodescuento(double preciodescuento) {
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
    
    
}
