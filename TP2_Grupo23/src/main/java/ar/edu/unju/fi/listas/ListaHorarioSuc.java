/**
 * Esta clase representa una lista de horarios para una sucursal.
 * Contiene métodos para obtener y establecer los horarios de la sucursal.
 */

package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ListaHorarioSuc {
	private List<String> horarios;
	
	/**
     * Constructor de la clase ListaHorarioSuc.
     * Inicializa la lista de horarios y agrega algunos horarios predefinidos.
     */
	public ListaHorarioSuc() {
		horarios = new ArrayList<String>();
		horarios.add("Lunes a Sábado 9 a 21 hs");
		horarios.add("Lunes a Sábado 9 a 13hs y 17 a 21 hs");
	}
	
	
	
	/**
     * Obtiene los horarios de la sucursal.
     *
     * @return una lista de strings con los horarios de la sucursal.
     */
	public List<String> getHorarioSuc() {
		return horarios;
	}
	
	
	
	/**
     * Establece los horarios de la sucursal.
     *
     * @param horarios una lista de strings con los horarios de la sucursal.
     */
	public void setHorarioSuc(List <String> horarios) {
		this.horarios = horarios;
	}
}
