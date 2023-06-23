/**
 * ISucursalRepository es una interfaz que extiende CrudRepository para la entidad Sucursal.
 * Proporciona métodos para acceder y manipular los datos de las sucursales en la base de datos.
 */

package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Sucursal;

@Repository
public interface ISucursalRepository extends CrudRepository<Sucursal,Long>{
	
	/**
     * Retorna una lista de sucursales que coinciden con el estado especificado.
     *
     * @param estado es el estado de las sucursales a buscar.
     * @return una lista de sucursales que coinciden con el estado especificado.
     */
	public List<Sucursal> findByEstado(boolean estado);
	
}