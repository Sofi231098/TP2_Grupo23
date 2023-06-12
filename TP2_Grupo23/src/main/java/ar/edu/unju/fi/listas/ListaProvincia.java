/**
 * Esta clase representa una lista de provincias para una sucursal.
 * Contiene métodos para obtener y establecer la lista de provincias.
 */


package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class ListaProvincia {
	private List<String> provincias;
	
	/**
	 * Constructor de la clase ListaProvincia.
	 * Inicializa la lista de provincias y agrega algunas provincias por defecto.
	 */
	public ListaProvincia() {
		provincias = new ArrayList<String>();
		provincias.add("JUJUY");
		provincias.add("SALTA");
		provincias.add("TUCUMÁN");
	}
	
	
	/**
	 * Obtiene la lista de provincias.
	 *
	 * @return la lista de provincias.
	 */
	public List<String> getProvincias() {
		return provincias;
	}
	
	/**
	 * Establece la lista de provincias.
	 *
	 * @param provincias la lista de provincias a establecer.
	 */
	public void setProvincias(List<String> provincias) {
		this.provincias = provincias;
	}
 }