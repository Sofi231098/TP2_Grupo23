package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.ModelConsejos;

public class ListaConsejo {
	private List<ModelConsejos> consejos;
	
	
	
	public ListaConsejo() {
	consejos = new ArrayList<ModelConsejos>();
	 consejos.add(new ModelConsejos("juega con tu mascota","juega en dias soleados"));	 
	}
	
	public  List<ModelConsejos> getConsejos(){
		return consejos;
	}
	
	public void setconsejos(List< ModelConsejos> consejos) {
		this.consejos = consejos;
	}


}
