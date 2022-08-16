package com.modelo.jdbcdao;

import java.util.List;

import com.modelo.dao.DepartamentoDAO;
import com.modelo.entidades.Departamento;
import com.modelo.entidades.Persona;

public class JDBCDepartamentoDAO extends JDBCGenericDAO<Departamento, Integer> implements DepartamentoDAO {

	@Override
	public void create(Departamento instancia) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Departamento instancia) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Departamento instancia) {
		// TODO Auto-generated method stub

	}

	@Override
	public Persona getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Departamento> getByPersona(Persona p) {
		// TODO Auto-generated method stub
		return null;
	}

}
