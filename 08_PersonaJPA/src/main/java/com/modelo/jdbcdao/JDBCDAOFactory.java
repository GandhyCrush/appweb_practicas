package com.modelo.jdbcdao;

import com.modelo.dao.DAOFactory;
import com.modelo.dao.DepartamentoDAO;
import com.modelo.dao.PersonaDAO;

public class JDBCDAOFactory extends DAOFactory{

	public PersonaDAO getPersonaDAO() {
		return new JDBCPersonaDAO();
	}

	@Override
	public DepartamentoDAO getDepartamentoDAO() {
		return new JDBCDepartamentoDAO();
	}



}
