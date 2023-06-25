package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Producto;

@Repository
public interface IProductoRepository extends CrudRepository<Producto, Long> {

	public List<Producto> findByEstado(boolean estado);
	
}
