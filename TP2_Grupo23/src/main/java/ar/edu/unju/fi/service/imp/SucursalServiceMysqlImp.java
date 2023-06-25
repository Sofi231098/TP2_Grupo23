/**
 * SucursalServiceMysqlImp es una clase de implementación que implementa la interfaz ISucursalService.
 * Proporciona métodos para manipular las sucursales utilizando el repositorio ISucursalRepository para acceder a la base de datos MySQL.
 */

package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.repository.ISucursalRepository;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;




@Service("sucursalServiceMysql")
public class SucursalServiceMysqlImp implements ISucursalService {
	
	@Autowired
	private ISucursalRepository sucursalRepository;
	
	@Autowired
	private Sucursal sucursal;

	
	/**
     * Retorna una lista de todas las sucursales activas.
     *
     * @return una lista de todas las sucursales activas
     */
	@Override
	public List<Sucursal> getLista() {
		return sucursalRepository.findByEstado(true);
	}
	

	
	/**
     * Guarda una sucursal en la base de datos.
     *
     * @param sucursal la sucursal a guardar
     */
	@Override
	public void guardar(@Valid Sucursal sucursal) {
		sucursal.setEstado(true);
		sucursalRepository.save(sucursal);

	}

	
	
	/**
     * Retorna una sucursal que coincide con el código especificado.
     *
     * @param codigo el código de la sucursal a buscar
     * @return una sucursal que coincide con el código especificado
     */
	@Override
	public Sucursal getBy(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	/**
     * Retorna una sucursal que coincide con el ID especificado.
     *
     * @param id el ID de la sucursal a buscar
     * @return una sucursal que coincide con el ID especificado
     */
	@Override
	public Sucursal getBy(Long id) {
		return sucursalRepository.findById(id).get();
	}

	
	
	/**
     * Modifica una sucursal en la base de datos.
     *
     * @param sucursal la sucursal a modificar
     */
	@Override
	public void modificar(Sucursal sucursal) {
		sucursal.setEstado(true);
		sucursalRepository.save(sucursal);
		

	}

	
	
	/**
     * Establece el estado de una sucursal como inactivo en la base de datos.
     *
     * @param sucursalEcontrada la sucursal a eliminar
     */
	@Override
	public void eliminar(Sucursal sucursalEcontrada) {
		sucursalEcontrada.setEstado(false);
		sucursalRepository.save(sucursalEcontrada);

	}

	
	
	/**
     * Retorna la sucursal actual.
     *
     * @return la sucursal actual
     */
	@Override
	public Sucursal getSucursal() {
		
		return sucursal;
	}

}