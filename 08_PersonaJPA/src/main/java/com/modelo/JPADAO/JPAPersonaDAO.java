package com.modelo.JPADAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.modelo.conexion.ConexionBDD;
import com.modelo.dao.PersonaDAO;
import com.modelo.entidades.Persona;

public class JPAPersonaDAO extends JPAGenericDAO<Persona, Integer> implements PersonaDAO {

	public JPAPersonaDAO() {
		super(Persona.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Persona autorizar(String usuario, String password) {
		
		String sentenciaJPQL = "SELECT p FROM PERSONA p WHERE p.nombre= :nombre and p.password= :password";
		Query consulta =  em.createQuery(sentenciaJPQL);
		consulta.setParameter("nombre",usuario );
		consulta.setParameter("password", password);
		return (Persona) consulta.getSingleResult();
		
		
		/*
		Persona resultado = null;
		String SQL_AUTORIZAR = "SELECT * FROM persona WHERE nombre = ? and password = ?";

		try {
			PreparedStatement pstm = ConexionBDD.getInstance().getCnn().prepareStatement(SQL_AUTORIZAR);
			pstm.setString(1, usuario);
			pstm.setString(2, password);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				resultado = new Persona();
				resultado.setId(rs.getInt("id"));
				resultado.setNombre(rs.getString("nombre"));
				resultado.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
		*/
	}

	@Override
	public List<Persona> getAll() {
		List<Persona> lista = new ArrayList<Persona>();
		String SQL_CONSULTAR = "SELECT * FROM persona";

		ResultSet rs = null;
		try {
			rs = ConexionBDD.getInstance().getCnn().prepareStatement(SQL_CONSULTAR).executeQuery();

			while (rs.next()) {
				Persona resultado = new Persona();
				resultado.setId(rs.getInt("id"));
				resultado.setNombre(rs.getString("nombre"));
				resultado.setPassword(rs.getString("password"));

				lista.add(resultado);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			ConexionBDD.getInstance().cerrar(rs);
		}
		return lista;
	}

	

}
