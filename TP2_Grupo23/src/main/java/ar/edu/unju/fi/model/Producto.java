package ar.edu.unju.fi.model;


public class Producto {

	private int codigo;
    private String nombre;
    private double precio;
    private int descuento;
    private double preciodescuento;
    private String  categoria;
    
    public Producto() {
		// TODO Auto-generated constructor stub
	}
    
	public Producto(int codigo, String nombre, double precio, int descuento, double preciodescuento, String categoria) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.descuento = descuento;
		this.preciodescuento = preciodescuento;
		this.categoria = categoria;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	public double getPreciodescuento() {
		if (descuento > 0 && descuento > 50) {
			
			return preciodescuento = (precio * descuento)/100;
			
		}			
		return preciodescuento;
	}
	public void setPreciodescuento(double preciodescuento) {
		this.preciodescuento = preciodescuento;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
    
    
}
