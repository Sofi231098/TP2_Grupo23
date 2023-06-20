package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Producto;
import jakarta.validation.Valid;

/**
 * La interfaz IProductoService define las operaciones relacionadas con los productos.
 */
public interface IProductoService {

	/**
	 * Obtiene la lista de productos.
	 * 
	 * @return una lista de objetos Producto que representa todos los productos existentes
	 */
	List<Producto> getLista();
	
	/**
	 * Guarda un producto.
	 * 
	 * @param producto el objeto Producto a guardar
	 */
	public void guardar(@Valid Producto producto);
	
	/**
	 * Obtiene un producto por su código.
	 * 
	 * @param codigo el código del producto a buscar
	 * @return el objeto Producto encontrado o null si no se encuentra ningún producto con el código especificado
	 */
	public Producto getBy(Long id);
	
	/**
	 * Modifica un producto existente.
	 * 
	 * @param producto el objeto Producto con los datos modificados
	 */
	public void modificar(@Valid Producto producto);
	
	/**
	 * Elimina un producto.
	 * 
	 * @param producto el objeto Producto a eliminar
	 */
	public void eliminar(Producto productoEncontrado);
	
	/**
	 * Obtiene el producto actual.
	 * 
	 * @return el objeto Producto actual
	 */
	Producto getProducto();
	
}