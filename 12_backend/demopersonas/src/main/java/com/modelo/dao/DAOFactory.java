package com.modelo.dao;

import com.modelo.jdbcdao.JDBCDAOFactory;

public abstract class DAOFactory {
	protected static DAOFactory instancia = new JDBCDAOFactory();
	
	public static DAOFactory getFactory() {
		return instancia;
	}
	
	public abstract PersonaDAO getPersonaDAO();
	public abstract DepartamentoDAO getDepartamentoDAO();

}
