package modelo.entidades;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class TestJPA {

	public static void main(String[] args) {
		EntityManager em =  Persistence.createEntityManagerFactory("07_jpa").createEntityManager();
		
		Persona p = new Persona();
		p.setNombre("Carlos");
		p.setPassword("carlos123");
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();

	}

}
