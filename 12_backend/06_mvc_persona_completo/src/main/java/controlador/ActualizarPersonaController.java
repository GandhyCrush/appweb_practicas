package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Persona;

/**
 * Servlet implementation class ActualizarPersonaController
 */
@WebServlet("/ActualizarPersonaController")
public class ActualizarPersonaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ActualizarPersonaController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.- Obtener Parámetros
		int idPersona = Integer.parseInt(request.getParameter("idPersona"));
		// 2.- Llamar al Modelo
		Persona personaModelo = new Persona();
		Persona p = new Persona();
		p = personaModelo.getPersona(idPersona);

		// 3.- Llamar a la Vista
		request.setAttribute("persona", p);
		request.getRequestDispatcher("/jsp/actualizarpersona.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.- Obtener Parámetros
		int id = Integer.parseInt(request.getParameter("txtId")) ;
		String nombre = request.getParameter("txtNombre");
		String clave = request.getParameter("txtClave");

		// 2.- Llamar al Modelo
		Persona p = new Persona();
		p.setId(id);
		p.setNombre(nombre);
		p.setPassword(clave);
		
		Persona personaModelo = new Persona();
		personaModelo.update(p);
		
		// 3.- Llamar a la Vista
		request.getRequestDispatcher("ListarPersonasController").forward(request, response);
	}

}
