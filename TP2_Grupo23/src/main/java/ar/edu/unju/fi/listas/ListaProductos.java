package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Producto;

/**
 * 
 * @author Farja Naima Blanca
 *
 */
@Component
public class ListaProductos {
	
	private List<Producto> productos;
	
	/**
	 * Constructor de la clase ListaProductos.
	 * Inicializa la lista de productos y agrega algunos productos de ejemplo.
	 */
	
	public ListaProductos() {
		productos = new ArrayList<Producto>();
		productos.add(new Producto("1110", "Pedrigree Adulto", 12600, 30 ,"Alimento perro adulto"));
        productos.add(new Producto("1111", "Raza Adulto", 8000, 30 ,"Alimento perro adulto"));
        productos.add(new Producto("1112", "Sabrocito Adulto", 9500, 20 ,"Alimento perro adulto"));
        productos.add(new Producto("1113", "Pedrigree cachorro", 9600, 10 , "Alimento perro chachorro"));
        productos.add(new Producto("1114", "Raza cachorro", 6000, 10 ,"Alimento perro cachorro"));
        productos.add(new Producto("1115", "Sabrocito cachorro", 7600, 10 , "Alimento perro cachorro"));
        productos.add(new Producto("1116", "Whiskas Adulto", 8000, 30 ,  "Alimento gato adulto"));
        productos.add(new Producto("1117", "Purina Cat Chow Adulto", 4500, 20 ,  "Alimento gato adulto"));
        productos.add(new Producto("1118", "Raza gato adulto", 9500, 30 ,  "Alimento gato adulto"));
        productos.add(new Producto("1119", "Whiskas gatito", 6500, 10 , "Alimento gato cachorro"));
        productos.add(new Producto("1120", "Purina Cat Chow gatito", 8200, 10 , "Alimento gato cachorro"));
        productos.add(new Producto("1121", "Raza gatito", 6000, 10 , "Alimento gato cachorro"));
        productos.add(new Producto("1122", "Hueso", 900, 0 , "Juguete"));
        productos.add(new Producto("1123", "Soga", 1200, 10,  "Juguete"));
        productos.add(new Producto("1124", "Sapito", 1200, 20,  "Juguete"));
        productos.add(new Producto("1125", "Collar para Perro", 1800, 50, "Accesorios"));
        productos.add(new Producto("1126", "Laser", 600, 0, "Juguete"));
        productos.add(new Producto("1127", "Varilla para gato", 800, 10, "Juguete"));
        productos.add(new Producto("1128", "Ratoncito", 1200, 20, "Juguete"));
        productos.add(new Producto("1129", "Collar para gatos", 1800, 50, "Accesorios"));
		

		
	}
	
	/**
	 * Obtiene la lista de productos.
	 * @return la lista de productos
	 */

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
}
