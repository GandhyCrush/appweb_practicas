package com.modelo.dao;

import com.modelo.JPADAO.JPADAOFactory;
import com.modelo.jdbcdao.JDBCDAOFactory;

public abstract class DAOFactory {
	protected static DAOFactory instancia = new JPADAOFactory();
	
	public static DAOFactory getFactory() {
		return instancia;
	}
	
	public abstract PersonaDAO getPersonaDAO();
	public abstract DepartamentoDAO getDepartamentoDAO();

}
