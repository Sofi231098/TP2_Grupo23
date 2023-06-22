package ar.edu.unju.fi.service;

	import java.util.List;

import ar.edu.unju.fi.entity.Servicios;
import jakarta.validation.Valid;

	/**
	 * Esta interfaz define el contrato para gestionar objetos Sucursal.
	 */
	public interface IServicioService {

	    /**
	     * Obtiene una lista de todas las sucursales.
	     *
	     * @return la lista de sucursales
	     */
	    List<Servicios> getLista();

	    /**
	     * Guarda una nueva sucursal.
	     *
	     * @param sucursal la sucursal a guardar
	     */
	    void guardar(@Valid Servicios servicio);

	    /**
	     * Obtiene una sucursal especÃ­fica por su nombre.
	     *
	     * @param nombre el nombre de la sucursal
	     * @return la sucursal con el nombre especificado
	     */
	    Servicios getBy(String nombre);

	    /**
	     * Modifica una sucursal existente.
	     *
	     * @param servicio la servicio actualizada
	     */
	    void modificar(@Valid Servicios servicio);

	    /**
	     * Elimina una sucursal.
	     *
	     * @param servicioEncontrada la sucursal a eliminar
	     */
	    void eliminar(Servicios servicioEncontrada);

	    /**
	     * Obtiene la sucursal actual.
	     *
	     * @return la sucursal actual
	     */
	    Servicios getServicio();
}
