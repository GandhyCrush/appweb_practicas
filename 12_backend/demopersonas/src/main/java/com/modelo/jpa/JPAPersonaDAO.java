package com.modelo.jpa;

import java.util.List;

import javax.persistence.Query;

import com.modelo.dao.PersonaDAO;
import com.modelo.entidades.Persona;

public class JPAPersonaDAO extends JPAGenericDAO<Persona, Integer> implements PersonaDAO {

	public JPAPersonaDAO() {
		super(Persona.class);
	}

	@Override
	public Persona autorizarPersona(String nombre, String clave) {

		Persona personaAutorizada = null;
		String sentenceJPQL = "SELECT p from Persona p WHERE p.nombre= :param_nombre AND p.clave= :param_clave";
		Query query = this.em.createQuery(sentenceJPQL);
		query.setParameter("param_nombre", nombre);
		query.setParameter("param_clave", clave);
		try {
			personaAutorizada = (Persona) query.getSingleResult();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return personaAutorizada;

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> get() {
		List<Persona> personas = null;
		String sentenceJPQL = "SELECT p from Persona p ORDER BY p.nombre ASC";
		Query query = this.em.createQuery(sentenceJPQL);
		try {
			personas = query.getResultList();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return personas;
	}

}
