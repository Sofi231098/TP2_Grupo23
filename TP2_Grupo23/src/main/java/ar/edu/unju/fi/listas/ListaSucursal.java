package ar.edu.unju.fi.listas;

import java.util.List;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import ar.edu.unju.fi.model.Sucursal;


@Component
public class ListaSucursal {
	private List<Sucursal> sucursales;
	
	public ListaSucursal() {
		sucursales = new ArrayList<Sucursal>();
		sucursales.add(new Sucursal("0001","Centro","JUJUY", "Independencia esq Alberdi", "3886439281", "Lunes a Sábado 9 a 21 hs"));
		sucursales.add(new Sucursal ("0002","Palpalá","JUJUY","Avenida Libertad 1090", "3885398765","Lunes a Sábado 9 a 21 hs" ));
		sucursales.add(new Sucursal("0003","Perico","JUJUY","Avenida Congreso 130", "3888563823","Lunes a Sábado 9 a 21 hs"));
		sucursales.add(new Sucursal("0004","San Pedro","JUJUY","Rogelio Leach 152", "3883475284","Lunes a Sábado 9 a 21 hs"));
		sucursales.add(new Sucursal("0005","Salta Capital","SALTA","Casero 676","387654029","Lunes a Sábado 9 a 21 hs"));
		sucursales.add(new Sucursal("0006","Guemes","SALTA","Leandro N. Alem 645","3876542093","Lunes a Sábado 9 a 21 hs"));
		sucursales.add(new Sucursal("0007","Orán","SALTA","Avenida Vicente Lopez y Planes 437","3874359870","Lunes a Sábado 9 a 21 hs"));
		sucursales.add(new Sucursal("0008","San Miguel","TUCUMAN", "Avenida Ejército del Norte 1662","3816283949","Lunes a Sábado 9 a 21 hs"));
		sucursales.add(new Sucursal("0009","Yerba Buena","TUCUMAN","Avenida Aconquija 2016","3817362983","Lunes a Sábado 9 a 21 hs"));
		sucursales.add(new Sucursal("0010","Tafi Viejo","TUCUMAN","Gral. Jose de San Martin 271","3817629012","Lunes a Sábado 9 a 21 hs"));	
	}
	
	public List<Sucursal> getSucursales() {
		return sucursales;
	}
	
	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}

}


