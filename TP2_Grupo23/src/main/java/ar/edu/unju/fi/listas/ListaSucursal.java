/**
 * Clase que representa una lista de sucursales.
 */

package ar.edu.unju.fi.listas;

import java.util.List;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import ar.edu.unju.fi.model.Sucursal;


@Component



public class ListaSucursal {
	private List<Sucursal> sucursales;
	
	
	/**
     * Constructor de la clase ListaSucursal.
     * Inicializa la lista de sucursales y sev agrega algunas sucursales de ejemplo.
     */
	public ListaSucursal() {
		sucursales = new ArrayList<Sucursal>();
		sucursales.add(new Sucursal("0001",LocalDate.of(2003, 12, 03), "Centro","JUJUY", "Independencia esq Alberdi", "3886439281", "Lunes a Sábado 9 a 21 hs"));
		sucursales.add(new Sucursal ("0002",LocalDate.of(2004, 06, 13), "Palpalá","JUJUY","Avenida Libertad 1090", "3885398765","Lunes a Sábado 9 a 21 hs" ));
		sucursales.add(new Sucursal("0003",LocalDate.of(2006, 07, 10), "Perico","JUJUY","Avenida Congreso 130", "3888563823","Lunes a Sábado 9 a 21 hs"));
		sucursales.add(new Sucursal("0004",LocalDate.of(2007, 05, 31), "San Pedro","JUJUY","Rogelio Leach 152", "3883475284","Lunes a Sábado 9 a 21 hs"));
		sucursales.add(new Sucursal("0005",LocalDate.of(2008, 12, 01), "Salta Capital","SALTA","Casero 676","387654029","Lunes a Sábado 9 a 21 hs"));
		sucursales.add(new Sucursal("0006",LocalDate.of(2014, 11, 03), "Guemes","SALTA","Leandro N. Alem 645","3876542093","Lunes a Sábado 9 a 21 hs"));
		sucursales.add(new Sucursal("0007",LocalDate.of(2018, 12, 9), "Orán","SALTA","Avenida Vicente Lopez y Planes 437","3874359870","Lunes a Sábado 9 a 21 hs"));
		sucursales.add(new Sucursal("0008",LocalDate.of(2019, 03, 04), "San Miguel","TUCUMAN", "Avenida Ejército del Norte 1662","3816283949","Lunes a Sábado 9 a 21 hs"));
		sucursales.add(new Sucursal("0009",LocalDate.of(2022, 12, 18), "Yerba Buena","TUCUMAN","Avenida Aconquija 2016","3817362983","Lunes a Sábado 9 a 21 hs"));
		sucursales.add(new Sucursal("0010",LocalDate.of(2023, 02, 16), "Tafi Viejo","TUCUMAN","Gral. Jose de San Martin 271","3817629012","Lunes a Sábado 9 a 21 hs"));	
	}
	
	
	/**
     * Obtiene la lista de sucursales.
     * @return Lista de sucursales.
     */
	public List<Sucursal> getSucursales() {
		return sucursales;
	}
	
	/**
     * Establece la lista de sucursales.
     * @param sucursales Lista de sucursales.
     */
	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}

}


