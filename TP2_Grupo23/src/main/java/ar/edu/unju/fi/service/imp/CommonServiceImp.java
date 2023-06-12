package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaCategorias;
import ar.edu.unju.fi.listas.ListaHorarioSuc;
import ar.edu.unju.fi.listas.ListaProvincia;
import ar.edu.unju.fi.service.ICommonService;



/**
 * Implementación del servicio común.
 */

@Service
public class CommonServiceImp implements ICommonService{
	
	@Autowired
	private ListaProvincia listaProvincia;
	
	/**
     * Obtiene la lista de provincias.
     * 
     * @return lista de provincias
     */
	@Override
	public List<String> getProvincias() {
		return listaProvincia.getProvincias();
	}
	
	
	
	@Autowired
	private ListaHorarioSuc listaHorario;
	
	/**
     * Obtiene la lista de horarios de sucursales.
     * 
     * @return lista de horarios de sucursales
     */
	@Override
	public List<String> getHorarioSuc() {
		return listaHorario.getHorarioSuc();
	}
	
	
	/*
	@Autowired
	private ListaDias listaDia;*/
	
	/**
     * Obtiene la lista de días.
     * 
     * @return lista de días
     */
	/*@Override
	public List<String> getDias() {
		return listaDia.getDias();
	}*/
	
	
	/*
	@Autowired
	private ListaHorarioServ listaHorarioServi;*/
	
	/**
     * Obtiene la lista de horarios de servicio.
     * 
     * @return lista de horarios de servicio
     */
	/*@Override
	public List<String> getHorarioServ() {
		return listaHorarioServ.getHorarioServ();
	}*/
	
	
	
	@Autowired 
	private ListaCategorias listaCategoria;
	
	/**
     * Obtiene la lista de categorías.
     * 
     * @return lista de categorías
     */
	@Override
	public List<String> getCategorias() {
		return listaCategoria.getCategorias();
	}
	
	
	
	

}
