package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Producto;

public class ListaProductos {
	
	private List<Producto> productos;
	
	public ListaProductos() {
		productos = new ArrayList<Producto>();
		productos.add(new Producto(1110, "Pedrigree Adulto", 12600, 30 , 8820, "Alimento perro adulto"));
		productos.add(new Producto(1111, "Raza Adulto", 8000, 30 , 5600, "Alimento perro adulto"));
		productos.add(new Producto(1112, "Sabrocito Adulto", 9500, 20 , 6650, "Alimento perro adulto"));
		productos.add(new Producto(1113, "Pedrigree cachorro", 9600, 10 , 8640, "Alimento perro chachorro"));
		productos.add(new Producto(1114, "Raza cachorro", 6000, 10 , 5400, "Alimento perro cachorro"));
		productos.add(new Producto(1115, "Sabrocito cachorro", 7600, 10 , 6840, "Alimento perro cachorro"));
		productos.add(new Producto(1116, "Whiskas Adulto", 8000, 30 , 5600, "Alimento gato adulto"));
		productos.add(new Producto(1117, "Purina Cat Chow Adulto", 4500, 20 , 7000, "Alimento gato adulto"));
		productos.add(new Producto(1118, "Raza gato adulto", 9500, 30 , 6650, "Alimento gato adulto"));
		productos.add(new Producto(1119, "Whiskas gatito", 6500, 10 , 5850, "Alimento gato cachorro"));
		productos.add(new Producto(1119, "Purina Cat Chow gatito", 8200, 10 , 7380, "Alimento gato cachorro"));
		productos.add(new Producto(1119, "Raza gatito", 6000, 10 , 5400, "Alimento gato cachorro"));
		productos.add(new Producto(1120, "Hueso", 900, 0 , 900, "Juguete"));
		productos.add(new Producto(1121, "Soga", 1200, 10, 1080, "Juguete"));
		productos.add(new Producto(1122, "Sapito", 1200, 20, 960, "Juguete"));
		productos.add(new Producto(1123, "Collar para Perro", 1800, 50, 900, "Accesorios"));
		productos.add(new Producto(1124, "Laser", 600, 0, 600, "Juguete"));
		productos.add(new Producto(1125, "Varilla para gato", 800, 10,720, "Juguete"));
		productos.add(new Producto(1126, "Ratoncito", 1200, 20, 960, "Juguete"));
		productos.add(new Producto(1127, "Collar para gatos", 1800, 50, 900, "Accesorios"));
		

		
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
}
