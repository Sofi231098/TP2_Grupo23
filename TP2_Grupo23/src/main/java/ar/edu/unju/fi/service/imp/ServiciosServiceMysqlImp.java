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
	
	@Override
	public List<Servicio> getLista() {
		// TODO Auto-generated method stub
		return servicioRepository.findByEstado(true) ;
	}

	@Override
	public void guardar(@Valid Servicio servicio) {
		// TODO Auto-generated method stub
		servicioRepository.save(servicio);

	}

	@Override
	public Servicio getBy(Long id) {
		// TODO Auto-generated method stub
		return servicioRepository.findById(id).get();
	}

	@Override
	public void modificar(@Valid Servicio servicio) {
		// TODO Auto-generated method stub
		servicio.setEstado(true);
		servicioRepository.save(servicio);
	}

	@Override
	public void eliminar(Servicio servicioEncontrada) {
		// TODO Auto-generated method stub
		servicioEncontrada.setEstado(false);
		servicioRepository.save(servicioEncontrada);
	}

	@Override
	public Servicio getServicio() {
		// TODO Auto-generated method stub
		return servicio;
	}

}
