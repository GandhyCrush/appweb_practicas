package modelo.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Facultad
 *
 */
@Entity(name = "Facultad")
public class Facultad implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String nombre;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "facultad")
	private List<Persona> estudiantes;
	
	public Facultad() {
		super();
	}

	public Facultad(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Persona> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Persona> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
	
   
}
