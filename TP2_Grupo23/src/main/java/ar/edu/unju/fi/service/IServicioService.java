package ar.edu.unju.fi.service;

	import java.util.List;

	import ar.edu.unju.fi.entity.Servicio;
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
	    List<Servicio> getLista();

	    /**
	     * Guarda una nueva sucursal.
	     *
	     * @param sucursal la sucursal a guardar
	     */
	    void guardar(@Valid Servicio servicio);

	    /**
	     * Obtiene una sucursal espesifica por su nombre.
	     *
	     * @param nombre el nombre de la sucursal
	     * @return la sucursal con el nombre especificado
	     */
	    Servicio getBy(Long id);

	    /**
	     * Modifica una sucursal existente.
	     *
	     * @param servicio la servicio actualizada
	     */
	    void modificar(@Valid Servicio servicio);

	    /**
	     * Elimina una sucursal.
	     *
	     * @param servicioEncontrada la sucursal a eliminar
	     */
	    void eliminar(Servicio servicioEncontrada);

	    /**
	     * Obtiene la sucursal actual.
	     *
	     * @return la sucursal actual
	     */
	    Servicio getServicio();
}
