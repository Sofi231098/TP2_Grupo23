package ar.edu.unju.fi.service.imp;



	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Servicios;
import ar.edu.unju.fi.listas.ListaServicios;
import ar.edu.unju.fi.service.IServicioService;
	import jakarta.validation.Valid;

	/**
	 * Implementación de la interfaz IServicioService.
	 * Maneja las operaciones de gestión de servicio.
	 */
	@Service
	public class ServiciosServiceImp implements IServicioService {

	    @Autowired
	    private ListaServicios listaServicios;
	    @Autowired
	    private Servicios servicio;
	    
	    /**
	     * Obtiene una lista de todas las servicios.
	     *
	     * @return la lista de servicios
	     */
	    public List<Servicios> getLista() {
	        return listaServicios.getServicios();
	    }
	    
	    /**
	     * Guarda una nueva servicio.
	     *
	     * @param servicos la servicio a guardar
	     */
	    public void guardar(@Valid Servicios servicio) {
	        listaServicios.getServicios().add(servicio);
	    }
	    
	    /**
	     * Obtiene una servicios específica por su nombre.
	     *
	     * @param nombre el nombre de la servicios
	     * @return la servicios con el nombre especificado
	     */
	    public Servicios getBy(String paseador) {
	        Servicios servicioEncontrado = null;
	        for(Servicios serv : listaServicios.getServicios()) {
				
				if(serv.getPaseador().equals(paseador)) {
					servicioEncontrado = serv;
					break;
				}
			}
	        return servicioEncontrado;
	    }
	    
	    /**
	     * Modifica una servicios existente.
	     *
	     * @param sucursal la servicios actualizada
	     */
	    public void modificar(@Valid Servicios servicio) {
	        for (Servicios serv : listaServicios.getServicios()) {
	            if (serv.getPaseador().equals(servicio.getPaseador())) {
	            	serv.setTelefono(servicio.getTelefono());
	            	serv.setDias(servicio.getDias());
					serv.setHorarios(servicio.getHorarios());
	                
	            }
	        }
	  
	    }
	    
	    /**
	     * Elimina una sucursal.
	     *
	     * @param sucursal la sucursal a eliminar
	     */
	    public void eliminar(Servicios servicio) {
	        listaServicios.getServicios().remove(servicio);
	    }
	    
	    /**
	     * Obtiene la sucursal actual.
	     *
	     * @return la sucursal actual
	     */
	    @Override
	    public Servicios getServicio() {
	        return servicio;
	    }
	
}

