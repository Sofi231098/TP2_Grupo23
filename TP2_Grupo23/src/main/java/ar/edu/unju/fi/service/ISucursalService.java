package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Sucursal;
import jakarta.validation.Valid;

public interface ISucursalService {
	
	List<Sucursal> getLista();
	
	void guardar (@Valid Sucursal sucursal);
	
	Sucursal getBy(String codigo);
	
	void modificar(Sucursal sucursal);
	
	void eliminar(Sucursal sucursalEcontrada);
	
	Sucursal getSucursal();

}
