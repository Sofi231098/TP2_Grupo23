package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid; 

@Service 
public class ConsejoServiceImp implements IConsejoService {
	/*sale del controller*/
	@Autowired
	private ListaConsejo listaConsejos;
	@Autowired
	private Consejo Consejo;

	@Override
	public List<Consejo> getLista() {
		return listaConsejos.getConsejos();
	}

	

	@Override
	public void guardar(Consejo consejo) {
		
	 listaConsejos.getConsejos().add(consejo);
	 
		}
	public Consejo getBy(String titulo){
		Consejo consejoEncontrado=null;
		for (Consejo cons :  listaConsejos.getConsejos()) {
			if (cons.getTitulo().equals(titulo)) {
				consejoEncontrado = cons;
				break;
			}
		}
		return consejoEncontrado;
	}
		
	public void modificar(@Valid Consejo consejos) {
		for (Consejo cons:  listaConsejos.getConsejos()) {
			if(cons.getTitulo().equals(consejos.getTitulo())) {
			cons.setConsejo(consejos.getConsejo());	
		
		}
	  }
		
	}
	public void eliminar (Consejo consejo) {
		listaConsejos.getConsejos().remove(consejo);
		
	}
	@Override
	public Consejo getConsejo() {
		return Consejo;
	}
	
}
	
