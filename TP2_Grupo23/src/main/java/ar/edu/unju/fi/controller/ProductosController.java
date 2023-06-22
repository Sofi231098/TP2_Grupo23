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

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.service.ICommonService;
import ar.edu.unju.fi.service.IProductoService;
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
	private IProductoService productoService;
	
	@Autowired
	private ICommonService commonService;
	
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
    	model.addAttribute("productos", productoService.getLista());
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
        model.addAttribute("producto", productoService.getProducto());
        model.addAttribute("categorias", commonService.getCategorias());
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
			modelView.addObject("categorias", commonService.getCategorias());
			return modelView;
		}
		productoService.guardar(producto);
		modelView.addObject("productos", productoService.getLista());
		return modelView;
	}
	
	/**
	 * Método controlador que devuelve la página con el formulario y los datos de un producto.
	 * 
	 * @param model se utiliza para agregar atributos al modelo
	 * @param codigo busca el articulo atravez de el codigo para poder modificarlo
	 * @return la página de modificación de producto
	 */
	@GetMapping("/productos/modificar/{id}")
	public String getModicarProductosPage(Model model, @PathVariable(value="id") Long id) {
		/*
		 * Obtiene el producto correspondiente al código proporcionado llamando al método getBy del servicio de productos.
		 */
		Producto productoEncontrado = productoService.getBy(id);
		
		/*
		 * Agrega el objeto Producto encontrado, las categorías y la bandera de edición al modelo para ser utilizados en la vista.
		 */
		boolean edicion = true;
		model.addAttribute("producto", productoEncontrado);
		model.addAttribute("categorias", commonService.getCategorias()); 
		model.addAttribute("edicion", edicion);
		
		/*
		 * Devuelve la vista "producto_nuevo" que permite la modificación del producto.
		 */
		return "producto_nuevo";
	}

	
	/**
	 * Método controlador que maneja la modificación de un producto.
	 * 
	 * @param producto el objeto Producto con los datos modificados
	 * @param result el objeto BindingResult que contiene los resultados de la validación de datos
	 * @param model se utiliza para agregar atributos al modelo
	 * @return una cadena que representa la vista a la que se redireccionará después de la modificación del producto
	 */
	@PostMapping("/productos/modificar")
	public String modificarProductos(@Valid @ModelAttribute("producto") Producto producto, BindingResult result, Model model) {
		/*
		 * Verifica si hay errores de validación en el objeto producto.
		 * Si hay errores, se muestra la página de edición de producto nuevamente con los mensajes de error.
		 */
		if (result.hasErrors()) {
			boolean edicion = true;
			model.addAttribute("edicion", edicion);
			model.addAttribute("categorias", commonService.getCategorias());
			return "producto_nuevo";			
		}
		
		/*
		 * Llama al método modificar del servicio de productos para actualizar el producto en la base de datos.
		 */
		productoService.modificar(producto);
		
		/*
		 * Redirecciona a la página de lista de productos después de la modificación del producto.
		 */
		return "redirect:/productos/lista";
	}

	
	/**
	 * Método controlador que maneja la eliminación de un producto.
	 * 
	 * @param codigo el código del producto a eliminar
	 * @return la pagina a la que se redireccionará después de la eliminación del producto
	 */
	@GetMapping("/productos/eliminar/{id}")
	public String eliminarProductos(@PathVariable(value="id") Long id) {
		/*
		 * Obtiene el producto correspondiente al código proporcionado llamando al método getBy del servicio de productos.
		 */
		Producto productoEncontrado = productoService.getBy(id);
		
		/*
		 * Llama al método eliminar de la capa service de productos para eliminar el producto.
		 */
		productoService.eliminar(productoEncontrado);
		
		/*
		 * Redirecciona a la página de lista de productos después de la eliminación del producto.
		 */
		return "redirect:/productos/lista";
	}

}