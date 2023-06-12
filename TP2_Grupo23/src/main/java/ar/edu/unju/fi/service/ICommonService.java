package ar.edu.unju.fi.service;

import java.util.List;

public interface ICommonService {
	
	/**
     * Obtiene la lista de provincias disponibles.
     *
     * @return Lista de provincias.
     */
	List<String> getProvincias();
	
	
	
	
	/**
     * Obtiene la lista de horarios de atención de las sucursales.
     *
     * @return Lista de horarios de atención de las sucursales.
     */
	List<String> getHorarioSuc();
	
	
	
	
	/**
     * Obtiene la lista de categorías disponibles.
     *
     * @return Lista de categorías.
     */
	List<String> getCategorias();
	
	
	

	/**
     * Obtiene la lista de días disponibles.
     *
     * @return Lista de días.
     */
	List<String> getDias();
	
	
	
	
	/**
     * Obtiene la lista de horarios de servicio.
     *
     * @return Lista de horarios de servicio.
     */
	List<String> getHorarioServ();
}