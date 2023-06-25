package ar.edu.unju.fi.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Servicio;

@Repository
public interface IServicioRepository extends CrudRepository <Servicio,Long>{
 
	/**
	 * Busca y devuelve una lista de Servicios según su estado.
	 *
	 * @param estado el estado del servicio
	 * @return una lista de servicios que coinciden con el estado dado
	 */
	
	
	public List<Servicio> findByEstado(boolean estado);
	
}
