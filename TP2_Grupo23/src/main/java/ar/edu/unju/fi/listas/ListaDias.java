package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Constructor de la clase ListaDias.
 * Inicializa la lista de días con valores predefinidos.
 */

@Component
public class ListaDias {
	private List<String> dias;
	
	public ListaDias() {
		dias = new ArrayList<String>();
		dias.add("Lunes");
		dias.add("Martes");
		dias.add("Miércoles");
		dias.add("Jueves");
		dias.add("Viernes");
		dias.add("Sábado");
		dias.add("Domingo");
		
	}
	
	/**
	 * Método getter para obtener la lista de días.
	 * @return la lista de días
	 */
	
	public List<String> getDias() {
		return dias;
	}
	
	/**
	 * Método setter para modificar la lista de días.
	 * @param dias la nueva lista de días
	 */
	
	public void setDias(List<String> dias) {
		this.dias = dias;
	}
 }