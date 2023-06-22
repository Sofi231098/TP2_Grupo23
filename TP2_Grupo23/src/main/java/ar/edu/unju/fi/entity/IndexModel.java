package ar.edu.unju.fi.model;
import org.springframework.stereotype.Component;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/**
 * @author Sofia Trinidad Yañez
 */
@Component
public class IndexModel {
	/**
	 * Atributo estático que genera un id para los objetivos
	 */
	private static Integer nextId = 0;
	/**
	 * Validacion donde la creacion o modificacion de un objetivo no puede estar vacioy debe contener enntre 20 y 150 caracteres.
	 */
	@NotEmpty(message="El campo no puede estar vacio")
	@Size(min=20, max=150, message="el objetivo debe contener entre 20 y 150 caracteres")
	private String objetivos;
	private int id;
	
	
	/**
	 *  Constructor de la clase IndexModel donde el atributo id va aumentando de a 1.
	 */
	public IndexModel() {
		nextId++;
		this.id = nextId;
	}

	/**
	 *Constructor sobrecargado de la clase IndexModel con sus atributos
	 */
	public IndexModel(String objetivos) {
		super();
		this.objetivos = objetivos;
		nextId++;
		this.id = nextId;
	}

	
	/**
	 * Getters y Setters de cada atributo
	 */
	public String getObjetivos() {
		return objetivos;
	}

	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
