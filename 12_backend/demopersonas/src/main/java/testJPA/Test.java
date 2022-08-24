package testJPA;

import com.modelo.dao.DAOFactory;
import com.modelo.entidades.Persona;

public class Test {

	public static void main(String[] args) {
		crearPersona();
		//actualizarPersona();
		listarPersona();
		
		
	}
	
	public static void crearPersona() {
		Persona p = new Persona();
		p.setClave("carlos123");
		p.setNombre("Carlos");
		
		DAOFactory.getFactory().getPersonaDAO().create(p);
	}
	
	public static void actualizarPersona() {
		Persona p = DAOFactory.getFactory().getPersonaDAO().getById(1);
		p.setNombre("Charlie");
		DAOFactory.getFactory().getPersonaDAO().update(p);
	}
	public static void listarPersona() {
		Persona p = DAOFactory.getFactory().getPersonaDAO().getById(1);
		System.out.println(p);
	}

}
