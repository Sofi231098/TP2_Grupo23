package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Sucursal;
import jakarta.validation.Valid;

public interface ISucursalService {
	
	/**
	 * Obtiene una lista de todas las sucursales.
	 *
	 * @return Lista de sucursales.
	 */
	List<Sucursal> getLista();
	
	
	/**
	 * Guarda una sucursal.
	 *
	 * @param sucursal La sucursal a guardar.
	 */
	void guardar (@Valid Sucursal sucursal);
	
	
	/**
	 * Obtiene una sucursal por su código.
	 *
	 * @param codigo El código de la sucursal.
	 * @return La sucursal encontrada, o null si no se encuentra ninguna coincidencia.
	 */
	Sucursal getBy(String codigo);
	
	
	/**
	 * Modifica una sucursal existente.
	 *
	 * @param sucursal La sucursal modificada.
	 */
	void modificar(Sucursal sucursal);
	
	
	/**
	 * Elimina una sucursal.
	 *
	 * @param sucursalEcontrada La sucursal a eliminar.
	 */
	void eliminar(Sucursal sucursalEcontrada);
	
	
	/**
	 * Obtiene la sucursal actual.
	 *
	 * @return La sucursal actual.
	 */
	Sucursal getSucursal();

}
