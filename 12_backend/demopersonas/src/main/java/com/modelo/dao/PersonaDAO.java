package com.modelo.dao;

import java.util.List;

import com.modelo.entidades.Persona;

public interface PersonaDAO extends GenericDAO<Persona, Integer> {
	
	
	
	public Persona autorizar(String usuario, String password);
	public List<Persona> getAll();

}
