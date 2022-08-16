package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Persona;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("jsp/login.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Persona personaAutorizada= null;
		//1.- Obtener los parametros
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("password");
		
		//2.- Concetarse al Modelo
		Persona personaModelo = new Persona();
		List<Persona> personas = personaModelo.getPersonas();
		
		for (Persona persona : personas) {
			if(persona.getNombre().equals(usuario) && persona.getClave().equals(clave)) {
				personaAutorizada = persona;
				break;
			}
		}
		
		if(personaAutorizada!=null) {
			//3.- Redirecciono a la Vista
			//request.setAttribute("personas", personas);
			request.getRequestDispatcher("ListarPersonasController").forward(request, response);
		}else {
			response.sendRedirect("jsp/login.jsp");
		}
		
		
		
		
		
		
		
	}

}
