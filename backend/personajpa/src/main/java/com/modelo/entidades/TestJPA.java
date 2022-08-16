package com.modelo.entidades;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class TestJPA {

	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("personajpa").createEntityManager();
		
		
		Persona p = new Persona("Federico", "federico123");
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();

	}

}
