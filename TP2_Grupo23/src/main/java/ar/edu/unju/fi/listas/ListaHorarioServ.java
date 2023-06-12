package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ListaHorarioServ {
	private List<String> horariosserv;
	
	public ListaHorarioServ() {
		horariosserv = new ArrayList<String>();
		horariosserv.add("08:00 a 09:00");
		horariosserv.add("09:00 a 10:00");
		horariosserv.add("10:00 a 11:00");
		horariosserv.add("11:00 a 12:00");
		horariosserv.add("13:00 a 14:00");
		horariosserv.add("15:00 a 16:00");
		horariosserv.add("17:00 a 18:00");
		horariosserv.add("18:00 a 19:00");
		horariosserv.add("20:00 a 21:00");
		horariosserv.add("22:00 a 23:00");
	}
	
	public List<String> getHorarioServ() {
		return horariosserv;
	}
	
	public void setHorarioServ(List <String> horariosserv) {
		this.horariosserv = horariosserv;
	}
}