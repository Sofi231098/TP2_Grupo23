package ar.edu.unju.fi.listas;
import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.model.IndexModel;

public class ListaIndex {
	private List<IndexModel> index;
	
	
	public ListaIndex() { 
		index = new ArrayList<IndexModel>();
		index.add(new IndexModel("Ayudarte con el cuidado de tus mascotas con nuestros consejos de salud."));
		index.add(new IndexModel("Acompañarte en su crecimiento con nuestros productos seleccionados especialmente para tu mascota."));
		index.add(new IndexModel("Brindarte los mejores servicios de paseo con nuestro personal especialmente capacitado."));
	}


	public List<IndexModel> getIndex() {
		return index;
	}


	public void setIndex(List<IndexModel> index) {
		this.index = index;
	}
	
	
}
