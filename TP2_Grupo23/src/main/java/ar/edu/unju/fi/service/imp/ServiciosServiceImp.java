package ar.edu.unju.fi.service.imp;



	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import ar.edu.unju.fi.entity.Servicio;

	import ar.edu.unju.fi.repository.IServicioRepository;
	import ar.edu.unju.fi.service.IServicioService;
	import jakarta.validation.Valid;

	/**
	 * Implementación de la interfaz IServicioService.
	 * Maneja las operaciones de gestión de servicio.
	 */
	@Service
	public class ServiciosServiceImp implements IServicioService {

		@Autowired
		private IServicioRepository servicioRepository;
	  
	    @Autowired
	    private Servicio servicio;
	    
	    /**
	     * Obtiene una lista de todas las servicios.
	     *
	     * @return la lista de servicios
	     */
	    public List<Servicio> getLista() {
	        return servicioRepository.findByEstado(true);
	    }
	    
	    /**
	     * Guarda una nueva servicio.
	     *
	     * @param servicos la servicio a guardar
	     */
	    public void guardar(@Valid Servicio servicio) {
	        servicioRepository.save(servicio);
	    }
	    
	    /**
	     * Obtiene una servicios específica por su nombre.
	     *
	     * @param nombre el nombre de la servicios
	     * @return la servicios con el nombre especificado
	     */
	    public Servicio getBy(Long id) {
	        return servicioRepository.findById(id).get() ;
	    }
	    
	    /**
	     * Modifica una servicios existente.
	     *
	     * @param sucursal la servicios actualizada
	     */
	    public void modificar(@Valid Servicio servicio) {
	        servicio.setEstado(true);
	        servicioRepository.save(servicio);
	    }
	    
	    /**
	     * Elimina una sucursal.
	     *
	     * @param sucursal la sucursal a eliminar
	     */
	    public void eliminar(Servicio servicio) {
	        servicio.setEstado(false);
	    	servicioRepository.save(servicio);
	    }
	    
	    /**
	     * Obtiene la sucursal actual.
	     *
	     * @return la sucursal actual
	     */
	    @Override
	    public Servicio getServicio() {
	        return servicio;
	    }
	
}

