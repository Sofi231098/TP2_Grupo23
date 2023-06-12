package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * La clase ListaCategorias representa una lista de las categorías de productos.
 */
@Component
public class ListaCategorias {

    private List<String> categorias;

    /**
     * Constructor de la clase ListaCategorias.
     * Inicializa la lista de categorías y agrega las categorías predefinidas.
     */
    public ListaCategorias() {
        categorias = new ArrayList<String>();
        categorias.add("Alimento perro adulto");
        categorias.add("Alimento gato adulto");
        categorias.add("Alimento perro cachorro");
        categorias.add("Alimento gato cachorro");
        categorias.add("Accesorios");
        categorias.add("Cuidados");
        categorias.add("Juguetes");
        categorias.add("Vestimenta");
    }

    /**
     * Obtiene la lista de categorías.
     * 
     * @return una lista de cadenas que representa las categorías de productos
     */
    public List<String> getCategorias() {
        return categorias;
    }

    /**
     * Establece la lista de categorías.
     * 
     * @param categorias la lista de cadenas que representa las categorías de productos a establecer
     */
    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }
}