package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Servicio;
import ar.edu.unju.fi.repository.IServicioRepository;
import ar.edu.unju.fi.service.IServicioService;
import jakarta.validation.Valid;

@Service("serviciosServiceMysql")
public class ServiciosServiceMysqlImp implements IServicioService {

	@Autowired
	private IServicioRepository servicioRepository;
	
	@Autowired
	private Servicio servicio;
	
	/**
	 * Retorna una lista de Servicios que tienen un estado activo.
	 *
	 * @return una lista de servicios activos
	 */
	
	@Override
	public List<Servicio> getLista() {
		// TODO Auto-generated method stub
		return servicioRepository.findByEstado(true) ;
	}

	/**
	 * Guarda un servicio en la base de datos.
	 *
	 * @param servicio el servicio a guardar
	 */
	
	@Override
	public void guardar(@Valid Servicio servicio) {
		// TODO Auto-generated method stub
		servicioRepository.save(servicio);

	}
	
	/**
	 * Obtiene un servicio por su ID.
	 *
	 * @param id el ID del servicio a obtener
	 * @return el servicio correspondiente al ID
	 */

	@Override
	public Servicio getBy(Long id) {
		// TODO Auto-generated method stub
		return servicioRepository.findById(id).get();
	}

	/**
	 * Modifica un servicio existente en la base de datos.
	 *
	 * @param servicio el servicio a modificar
	 */
	
	@Override
	public void modificar(@Valid Servicio servicio) {
		// TODO Auto-generated method stub
		servicio.setEstado(true);
		servicioRepository.save(servicio);
	}

	/**
	 * Elimina un servicio estableciendo su estado como inactivo en la base de datos.
	 *
	 * @param servicioEncontrada el servicio a eliminar
	 */
	
	@Override
	public void eliminar(Servicio servicioEncontrada) {
		// TODO Auto-generated method stub
		servicioEncontrada.setEstado(false);
		servicioRepository.save(servicioEncontrada);
	}

	/**
	 * Retorna el servicio actual.
	 *
	 * @return el servicio actual
	 */
	
	@Override
	public Servicio getServicio() {
		// TODO Auto-generated method stub
		return servicio;
	}

}
