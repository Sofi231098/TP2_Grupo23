package ar.edu.unju.fi.listas;

import java.util.ArrayList;

import java.util.List;
import ar.edu.unju.fi.model.Servicios;

public class ListaServicios {

	private List<Servicios> servicios;
	
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
	
	public List<Servicios> getServicios(){
		return servicios;
	}
	
	public void setServicios(List<Servicios> servicios) {
		this.servicios = servicios;
	}
	
}
