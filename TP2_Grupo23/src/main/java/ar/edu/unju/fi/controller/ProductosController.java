package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaProductos;
import ar.edu.unju.fi.model.Producto;

@Controller
@RequestMapping("/")
public class ProductosController {
	
	ListaProductos listaProductos = new ListaProductos();
	
	@GetMapping("/productos")
	public String getProductosPage() {
		return "productos";
		
	}
	
	@GetMapping("productos/lista")
    public String getListaProductospage(Model model){
    	model.addAttribute("productos", listaProductos.getProductos());
    	return "productos";
	}
	
	@GetMapping("/nuevo")
    public String getNuevoProductos(Model model) {
		boolean edicion = false;
    	model.addAttribute("productos", new Producto());
    	model.addAttribute("edicion" , edicion);
    	return "producto_nuevo";
	}
	
	@PostMapping("/productos/guardar")
	public ModelAndView getGuardarProductoPage(@ModelAttribute("producto") Producto producto) {
		ModelAndView modelView =new ModelAndView("productos");
		listaProductos.getProductos().add(producto);
		modelView.addObject("productos", listaProductos.getProductos());
		return modelView;
	}
	
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
		model.addAttribute("productos", ProductoEncontrado);
		model.addAttribute("edicion", edicion);
		return "producto_nuevo";
	}
	
	@PostMapping("/productos/modificar")
	public String modificarProductos(@ModelAttribute("productos") Producto producto) {
		for (Producto prod: listaProductos.getProductos()) {
			if(prod.getNombre().equals(producto.getNombre())) {
    		prod.setCodigo(producto.getCodigo());
    		prod.setPrecio(producto.getPrecio());
    		prod.setDescuento(producto.getDescuento());
    		prod.setCategoria(producto.getCategoria());
    		break;
			}
		}
		return "redirect:/productos/lista";
		}
	
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