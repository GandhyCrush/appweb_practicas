package com.modelo.dao;


import com.modelo.entidades.Persona;

public interface PersonaDAO extends GenericDAO<Persona, Integer> {


	public Persona autorizarPersona(String nombre, String clave);

}
