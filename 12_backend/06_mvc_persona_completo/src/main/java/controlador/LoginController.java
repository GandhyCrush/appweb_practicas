package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		//Variable con persona autorizada
		Persona personaAutorizada = null;
		
		//1.- Obtener los parámetros
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		//2.- Me comunico con el Modelo
		Persona personaModelo = new Persona();
		personaAutorizada = personaModelo.autorizarPersona(usuario, password);
	
		
		//3.- Redirecciono a la Vista
		if(personaAutorizada!= null) {
			
			//Crear la sesión
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogeado", personaAutorizada);
			
			request.getRequestDispatcher("/MenuOpcionesController").forward(request, response);
		}else {
			response.sendRedirect("jsp/login.jsp");
		}
		
		
		
		
	}

}
