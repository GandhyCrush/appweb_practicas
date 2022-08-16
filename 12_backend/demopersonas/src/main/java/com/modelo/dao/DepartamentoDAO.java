package com.modelo.dao;

import java.util.List;

import com.modelo.entidades.Departamento;
import com.modelo.entidades.Persona;

public interface DepartamentoDAO extends GenericDAO<Departamento, Integer> {
	public List<Departamento> getByPersona(Persona p);

}
