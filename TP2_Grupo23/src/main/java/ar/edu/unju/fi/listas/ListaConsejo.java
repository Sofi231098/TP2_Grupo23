package ar.edu.unju.fi.listas;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.model.Consejo;


public class ListaConsejo {
	private List<Consejo> consejos;
	
	public ListaConsejo() {
		consejos = new ArrayList<Consejo>();
		consejos.add(new Consejo(LocalDate.of(2021, 04, 10), "Bañar a tu perro."));
        consejos.add(new Consejo(LocalDate.of(2021, 04, 10), "Alimentacion acorde para tu mascota."));
        consejos.add(new Consejo(LocalDate.of(2021, 04, 10), "Dale una identidad a tu mascota."));
        consejos.add(new Consejo(LocalDate.of(2021, 04, 10), "Ejercicio para peludos."));
        consejos.add(new Consejo(LocalDate.of(2021, 04, 10), "Proporcionar un espacio exclusivo para el descanso de tu mascota."));
        consejos.add(new Consejo(LocalDate.of(2021, 04, 10), "Aplica las vacunas a tiempo."));
        consejos.add(new Consejo(LocalDate.of(2021, 04, 10), "Busca juguetes seguros."));
        consejos.add(new Consejo(LocalDate.of(2021, 04, 10), "Buscar un veterianrio de confianza."));
	}
	
	public List<Consejo> getConsejos(){	
		return consejos;
	}

	public void setConsejos(List<Consejo> consejos) {
		this.consejos = consejos;
	}

	
	

	
}