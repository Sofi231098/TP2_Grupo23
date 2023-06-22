package ar.edu.unju.fi.listas;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.IndexModel;

/**
 * @author Sofia Trinidad Yañez
 * 
 */
@Component
public class ListaIndex {
	/**
	 * declaracion de los objetos inyectados, lista de objetos
	 */
	private List<IndexModel> index;
	
	
	/**
	 * constructor de la clase ListaIndex
	 * Array donde se encuentran los objetivos 
	 */
	public ListaIndex() { 
		index = new ArrayList<IndexModel>();
		index.add(new IndexModel("Ayudarte con el cuidado de tus mascotas con nuestros consejos de salud."));
		index.add(new IndexModel("Acompañarte en su crecimiento con nuestros productos seleccionados especialmente para tu mascota."));
		index.add(new IndexModel("Brindarte los mejores servicios de paseo con nuestro personal especialmente capacitado."));
	}


	/**
	 * Aquí se obtiene la lista de objetos IndexModel
	 */
	public List<IndexModel> getIndex() {
		return index;
	}


	/**
	 * Aquí se establece la lista de objetos IndexModel
	 * @param index
	 */
	public void setIndex(List<IndexModel> index) {
		this.index = index;
	}
	
	
}
