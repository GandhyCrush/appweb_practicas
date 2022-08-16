package modelo.entidades;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestJPA {

	public static void main(String[] args) {
		EntityManager em =  Persistence.createEntityManagerFactory("07_jpa").createEntityManager();
		/*
		//INSERCION
		Persona p = new Persona();
		p.setNombre("Carlos");
		p.setPassword("carlos123");
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		
		//CONSULTA
		
		Persona personaConsultada =  em.find(Persona.class, 1);
		System.out.println(personaConsultada);
		
		//ACTUALIZACION
		Persona personaActualizar =  em.find(Persona.class, 1);
		personaActualizar.setNombre("Carlos Magno");
		
		em.getTransaction().begin();
		em.merge(personaActualizar);
		em.getTransaction().commit();
		
		//ELIMINAR
		Persona personaEliminar = em.find(Persona.class, 2);
		
		em.getTransaction().begin();
		em.remove(personaEliminar);
		em.getTransaction().commit();
		*/
		
		/*CONSULTA TRUCHA*/
		
		String nombre = "Carlos";
		String clave = "carlos123";
		
		String sentenciaJPQL = "SELECT p FROM PERSONA p WHERE p.nombre= :nombre and p.password= :password";
		
		Query consulta =  em.createQuery(sentenciaJPQL);
		consulta.setParameter("nombre",nombre );
		consulta.setParameter("password", clave);
		
		Persona personaAutorizada =  (Persona) consulta.getSingleResult();
		
		System.out.println(personaAutorizada);
		
		// Consulta nativa (SQL)
		String sentenciaSQL = "SELECT per.* FROM Persona per where per.per_nombre ='Carlos' and per.per_clave='carlos123'";
		Query consultaNativa = em.createNativeQuery(sentenciaSQL, Persona.class);
		System.out.println((Persona)consultaNativa.getSingleResult());
		
		
		
		
		
		

	}

}
