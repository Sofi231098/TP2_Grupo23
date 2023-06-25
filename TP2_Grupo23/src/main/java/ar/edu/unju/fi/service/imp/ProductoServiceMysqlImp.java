package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.repository.IProductoRepository;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

@Service("productoServiceMysqlImp")
public class ProductoServiceMysqlImp implements IProductoService {
	
	@Autowired
	private IProductoRepository productoRepository;

	@Autowired
	private Producto producto;
	
	@Override
	public List<Producto> getLista() {
		return productoRepository.findByEstado(true);
	}

	@Override
	public void guardar(@Valid Producto producto) {
		producto.setEstado(true);
		productoRepository.save(producto);

	}

	@Override
	public Producto getBy(String codigo) {
		return null;
	}
	
	@Override
	public Producto getBy(Long id) {
		return productoRepository.findById(id).get();
	}

	@Override
	public void modificar(Producto producto) {
		producto.setEstado(true);
		productoRepository.save(producto);

	}

	@Override
	public void eliminar(Producto producto) {
		//eliminacion logica
		producto.setEstado(false);
		productoRepository.save(producto);

	}

	@Override
	public Producto getProducto() {
		return producto;
	}

}
