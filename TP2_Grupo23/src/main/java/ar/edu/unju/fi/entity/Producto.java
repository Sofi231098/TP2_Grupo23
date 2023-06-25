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
import jakarta.validation.constraints.NotNull;



/**
 * Representa los articulos del sistema
 * @author Farja Naima Blanca
 * @version 1.0 date: 03/06/2023
 */
@Component
@Entity
@Table(name="productos")
public class Producto {
	
	@Id
	@Column(name="art_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**Representa el ID del articulo*/
	private Long id;
	
	@Column(name="art_codigo", nullable = false)
	@NotEmpty(message="El codigo del artículo debe ser registrado")
	/**Representa el codigo del articulo*/
	private String codigo;
	
	@Column(name="art_nombre", nullable = false)
	@NotEmpty(message="El nombre del artículo no puede estar vacío")
	/**Representa el nombre del articulo*/
	private String nombre;
	
	@Column(name="art_descripcion", length = 5000, nullable = false)
	@NotEmpty(message="Debe agregar una descripción breve del producto")
	/**Representa la descripcion del articulo*/ 
	private String descripcion;
	
	@Column(name="art_precio", nullable = false)
	@NotNull(message="Se requiere proporcionar un valor para el precio del articulo")
	/**Representa el precio del articulo*/
	private Double precio;
	
	@Column(name="art_descuento", nullable = false)
	@NotNull(message="El campo descuento no puede ser nulo debe ser entre 0% y 50%")
	/**Representa el descuento que se va a realizar en el articulo*/
	private Integer descuento;
	
	@Column(name="art_categoria", nullable = false)
    @NotBlank(message="Debe elegir una categoría")
    /**Representa la categoria del articulo*/
    private String  categoria;
    
	@Column (name="art_estado", nullable = false)
    private boolean estado;
    
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
	
	public Producto (String codigo, String nombre, String descripcion, Double precio, Integer descuento, String categoria) {
		super();
		this.codigo = codigo;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
