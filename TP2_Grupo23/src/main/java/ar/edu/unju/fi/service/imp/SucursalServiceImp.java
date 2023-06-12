package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.model.Sucursal;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;


@Service
public class SucursalServiceImp implements ISucursalService {
	@Autowired
	private ListaSucursal listaSucursales;
	@Autowired
	private Sucursal sucursal;
	
	public List<Sucursal> getLista() {
		return listaSucursales.getSucursales();
	}
	
	public void guardar (@Valid Sucursal sucursal) {
		listaSucursales.getSucursales().add(sucursal);
	}
	
	public Sucursal getBy(String codigo) {
		Sucursal sucursalEncontrada = null;
		for(Sucursal sucu : listaSucursales.getSucursales()) {
			if(sucu.getCodigo().equals(codigo)) {
				sucursalEncontrada = sucu;
				break;
			}
		}
		return sucursalEncontrada;
	}
	
	public void modificar(Sucursal sucursal) {
		for(Sucursal sucu: listaSucursales.getSucursales()) {
			if(sucu.getNombre().equals(sucursal.getNombre())) {
				sucu.setProvincia(sucursal.getProvincia());
				sucu.setDireccion(sucursal.getDireccion());
				sucu.setTelefono(sucursal.getTelefono());
				sucu.setHorario(sucursal.getHorario());
			}
		}
	}
	
	
	public void eliminar(Sucursal sucursal) {
		listaSucursales.getSucursales().remove(sucursal);
	}
	
	
	@Override
	public Sucursal getSucursal() {
		return sucursal;
	}
	
}	
