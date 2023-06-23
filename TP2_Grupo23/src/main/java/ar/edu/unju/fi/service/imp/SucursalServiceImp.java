/**
Esta clase implementa la interfaz ISucursalService y proporciona los métodos necesarios para manipular las sucursales.
*/

package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;


@Service("sucursalServiceImp")
public class SucursalServiceImp implements ISucursalService {
	@Autowired
	private ListaSucursal listaSucursales;
	@Autowired
	private Sucursal sucursal;
	
	
	/**
	 * Devuelve la lista de sucursales.
	 * 
	 * @return lista de sucursales.
	 */
	public List<Sucursal> getLista() {
		return listaSucursales.getSucursales();
	}
	
	
	/**
	 * Agrega una sucursal a la lista de sucursales.
	 * 
	 * @param sucursal la sucursal a guardar.
	 */
	public void guardar (@Valid Sucursal sucursal) {
		listaSucursales.getSucursales().add(sucursal);
	}
	
	
	/**
	 * Obtiene una sucursal por su código.
	 * 
	 * @param codigo el código de la sucursal a buscar.
	 * @return la sucursal encontrada o null si no se encuentra.
	 */
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
	
	
	
	/**
	 * Modifica una sucursal existente.
	 * 
	 * @param sucursal la sucursal modificada.
	 */
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
	
	
	
	/**
	 * Elimina una sucursal de la lista de sucursales.
	 * 
	 * @param sucursal la sucursal a eliminar.
	 */
	public void eliminar(Sucursal sucursal) {
		listaSucursales.getSucursales().remove(sucursal);
	}
	
	
	/**
	 * Retorna la sucursal actual.
	 * 
	 * @return la sucursal actual.
	 */
	@Override
	public Sucursal getSucursal() {
		return sucursal;
	}
	
	

	/**
     * Retorna una sucursal que coincide con el ID especificado.
     *
     * @param id el ID de la sucursal a buscar
     * @return una sucursal que coincide con el ID especificado
     */
	@Override
	public Sucursal getBy(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}