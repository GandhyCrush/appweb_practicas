package com.modelo.JPADAO;

import com.modelo.dao.DAOFactory;
import com.modelo.dao.DepartamentoDAO;
import com.modelo.dao.PersonaDAO;

public class JPADAOFactory extends DAOFactory{

	public PersonaDAO getPersonaDAO() {
		return new JPAPersonaDAO();
	}

	@Override
	public DepartamentoDAO getDepartamentoDAO() {
		return new JPADepartamentoDAO();
	}



}
