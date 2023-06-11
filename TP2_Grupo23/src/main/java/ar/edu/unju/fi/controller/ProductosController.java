package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.listas.ListaProductos;
import ar.edu.unju.fi.model.Producto;
import jakarta.validation.Valid;

/**
 * Controlador para administrar las operaciones relacionadas con la pagina Productos
 * @author Farja Naima Blanca
 *
 */
@Controller
@RequestMapping("/")
public class ProductosController {
	
	@Autowired
	private ListaProductos listaProductos;
	
	@Autowired
	private Producto producto;
	
	@GetMapping("/productos")
    public String getProductosPage() {
        return "productos";
	}
	
	/**
     * Solicitud GET para mostrar la lista de productos.
     * @param model el modelo utilizado para pasar datos a la vista
     * @return la vista "productos" que muestra la lista de productos
     */
	@GetMapping("/productos/lista")
    public String getListaProductospage(Model model){
    	model.addAttribute("productos", listaProductos.getProductos());
    	return "productos";
	}
	/**
    * Solicitud GET para mostrar el formulario para agregar un nuevo producto.
    * @param model el modelo utilizado para pasar datos a la vista
    * @return la vista "producto_nuevo" que muestra el formulario para agregar un nuevo producto
    */
    @GetMapping("/nuevo")
    public String getNuevoProducto(Model model) {
        boolean edicion = false;
        model.addAttribute("producto", producto);
        model.addAttribute("edicion", edicion);
        return "producto_nuevo";
    }
	
    /**
     * Solicitud POST para guardar un nuevo producto.
     * @param producto el producto enviado desde el formulario
     * @param result el objeto BindingResult que contiene los resultados de la validación
     * @return el modelo y vista "productos" si no hay errores, o la vista "producto_nuevo" si hay errores de validación
     */
	@PostMapping("/productos/guardar")
	public ModelAndView getGuardarProductoPage(@Valid @ModelAttribute("producto") Producto producto, BindingResult result) {
		ModelAndView modelView =new ModelAndView("productos");
		if (result.hasErrors()) {
			modelView.setViewName("producto_nuevo");
			modelView.addObject("producto", producto);
			return modelView;
		}
		listaProductos.getProductos().add(producto);
		modelView.addObject("productos", listaProductos.getProductos());
		return modelView;
	}
	
	/**
	 * Solicitud GET para mostrar el formulario para modificar un producto existente.
	 * @param model el modelo utilizado para pasar datos a la vista
	 * @param codigo el código del producto a modificar
	 * @return la vista "producto_nuevo" que muestra el formulario para modificar un producto
	 */
	@GetMapping("/productos/modificar/{nombre}")
	public String getModicarProductosPage(Model model, @PathVariable(value="nombre")String nombre) {
		Producto ProductoEncontrado = new Producto();
		boolean edicion = true;
		for (Producto prod : listaProductos.getProductos()) {
			if (prod.getNombre().equals(nombre)) {
				ProductoEncontrado = prod;
				break;
			}
		}
		model.addAttribute("producto", ProductoEncontrado);
		model.addAttribute("edicion", edicion);
		return "producto_nuevo";
	}
	
	@PostMapping("/productos/modificar")
	public String modificarProductos(@Valid @ModelAttribute("producto") Producto producto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			boolean edicion=true;
			model.addAttribute("edicion", edicion);
			return "producto_nuevo";			
		}
		
		for (Producto prod: listaProductos.getProductos()) {
			if(prod.getCodigo().equals(producto.getCodigo())) {
    		prod.setNombre(producto.getNombre());
    		prod.setPrecio(producto.getPrecio());
    		prod.setDescripcion(producto.getDescripcion());
    		prod.setDescuento(producto.getDescuento());
    		prod.setCategoria(producto.getCategoria());
    		break;
			}
		}
		return "redirect:/productos/lista";
		}
	
	/**
	 * Solicitud GET para eliminar un producto existente.
	 * @param model el modelo utilizado para pasar datos a la vista
	 * @param codigo el código del producto a eliminar
	 * @return la vista redirect:/productos/lista 
	 */
	@GetMapping("/productos/eliminar/{nombre}")
    public String eliminarProductos(@PathVariable(value="nombre")String nombre) {
        for(Producto prod: listaProductos.getProductos()) {
            if(prod.getNombre().equals(nombre)) {
                listaProductos.getProductos().remove(prod);
                break;

            }
        }
        return "redirect:/productos/lista";

    }
}