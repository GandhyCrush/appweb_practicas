package com.cmc.modelos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import modelo.entidades.Facultad;

public class JPAPropietarioDAO implements GenericDAO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "pro_nombre")
	private String nombre;
	@Column(name = "pro_clave")
	private String password;
	@Column(name = "pro_usuario")
	private String usuario;
	
	@ManyToOne(cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
	private Facultad facultad;
	
	
	public JPAPropietarioDAO() {}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", password=" + password + "]";
	}

}
