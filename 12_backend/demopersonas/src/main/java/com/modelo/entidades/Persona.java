package com.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
public class Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idPersona")
	private Integer id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="clave")
	private String clave;

	/*
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "propietario")
	private List<NumeroTelefono> telefonos;
	*/

	public Persona() {

	}

	public Persona(String nombre, String clave) {
		this.nombre = nombre;
		this.clave = clave;
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

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}


	@Override
	public String toString() {
		return this.nombre+ ' '+ this.clave;
	}
	@Override
	public int hashCode() {
		int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
	}
	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
	}

}
