package com.modelo.dao;

import com.modelo.entidades.Persona;

public interface GenericDAO <T, ID>{
	public void create(T instancia);
	public void update(T instancia);
	public void delete (T instancia);
	public Persona getById(ID id);

}
