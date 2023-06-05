package ar.edu.unju.fi.listas;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Servicios;

/**
 * Clase que representa una lista de servicios.
 */

@Component
public class ListaServicios {

	private List<Servicios> servicios;
	
	 /**
     * Constructor de la clase ListaServicios.
     * Inicializa la lista de servicios y agrega algunos servicios de ejemplo.
     */
	
	public ListaServicios() {
		servicios = new ArrayList<Servicios>();
		servicios.add(new Servicios ("Maximiliano A. Flores","388-4265789","Lunes","9 a 12 - 16 a 20"));
		servicios.add(new Servicios ("Luis G. Panduro","388-4256789","Martes","9 a 12 - 16 a 20"));
		servicios.add(new Servicios ("Maria J. Becerra ","388-5123456","Miercoles","9 a 12 - 16 a 20"));
		servicios.add(new Servicios ("Sofia B. Lopez","388-5123654","Jueves","9 a 12 - 16 a 20"));
		servicios.add(new Servicios ("Marcelo J. Perez","388-4343666","Viernes","9 a 12 - 16 a 20"));
		servicios.add(new Servicios ("Melanie A. Quevedo","388-5102300","Sabado","9 a 12 - 14 a 20"));
		servicios.add(new Servicios ("Angel E. Gallardo","3884-569820","Domingo","9 a 12 - 14 a 20"));
	}
	
	/**
     * Obtiene la lista de servicios.
     *
     * @return la lista de servicios
     */
	
	public List<Servicios> getServicios(){
		return servicios;
	}
	
	 /**
     * Establece la lista de servicios.
     *
     * @param servicios la lista de servicios a establecer
     */
	
	public void setServicios(List<Servicios> servicios) {
		this.servicios = servicios;
	}
	
}
