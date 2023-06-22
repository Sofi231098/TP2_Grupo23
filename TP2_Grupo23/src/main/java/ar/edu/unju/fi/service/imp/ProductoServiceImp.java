package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.listas.ListaProductos;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

/**
 * @author Farja Naima Blanca
 * Implementación de la interfaz IProductoService que define las operaciones relacionadas con los productos.
 */
@Service
public class ProductoServiceImp implements IProductoService {

	@Autowired
	private ListaProductos listaProductos;
	
	@Autowired
	private Producto producto;
	
	/**
	 * Obtiene la lista de productos.
	 * 
	 * @return una lista de objetos Producto que representa todos los productos existentes
	 */
	public List<Producto> getLista() {
		return listaProductos.getProductos();
	}

	/**
	 * Guarda un producto en la lista de productos.
	 * 
	 * @param producto el objeto Producto a guardar en la lista
	 */
	public void guardar(@Valid Producto producto) {
		/*
		 * Agrega el producto a la lista de productos existente.
		 */
		listaProductos.getProductos().add(producto);
	}

	/**
	 * Obtiene un producto por su código.
	 * 
	 * @param codigo el código del producto a buscar
	 * @return el objeto Producto encontrado o null si no se encuentra ningún producto con el código especificado
	 */
	public Producto getBy(Long id) {
		/*
		 * Recorre la lista de productos y compara el código de cada producto con el código especificado.
		 * Si se encuentra un producto con el código buscado, se devuelve ese producto.
		 * Si no se encuentra ningún producto con el código especificado, se devuelve null.
		 */
		Producto productoEncontrado = null;
		for (Producto prod : listaProductos.getProductos()) {
			if (prod.getId().equals(id)) {
				productoEncontrado = prod;
				break;
			}
		}
		return productoEncontrado;
	}

	/**
	 * Modifica un producto existente en la lista de productos.
	 * 
	 * @param producto el objeto Producto con los datos modificados
	 */
	public void modificar(@Valid Producto producto) {
		/*
		 * Recorre la lista de productos y compara el código de cada producto con el código del producto especificado.
		 * Si se encuentra un producto con el mismo código, se actualizan los datos del producto con los nuevos valores.
		 * Si no se encuentra ningún producto con el mismo código, no se realiza ninguna modificación.
		 */
		for (Producto prod : listaProductos.getProductos()) {
			if (prod.getId().equals(producto.getId())) {
				prod.setNombre(producto.getNombre());
				prod.setPrecio(producto.getPrecio());
				prod.setDescripcion(producto.getDescripcion());
				prod.setDescuento(producto.getDescuento());
				prod.setCategoria(producto.getCategoria());
			}
		}
	}

	/**
	 * Elimina un producto de la lista de productos.
	 * 
	 * @param producto el objeto Producto a eliminar de la lista
	 */
	public void eliminar(Producto producto) {
		/*
		 * Elimina el producto de la lista de productos existente.
		 */
		listaProductos.getProductos().remove(producto);
	}

	/**
	 * Obtiene el producto actual.
	 * 
	 * @return el objeto Producto actual
	 */
	@Override
	public Producto getProducto() {
		return producto;
	}

}