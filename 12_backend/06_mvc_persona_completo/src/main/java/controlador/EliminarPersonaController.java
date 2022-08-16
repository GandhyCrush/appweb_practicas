package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Persona;

/**
 * Servlet implementation class EliminarPersonaController
 */
@WebServlet("/EliminarPersonaController")
public class EliminarPersonaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EliminarPersonaController() {
        super();
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.- Obtener parámetros
		int id = Integer.parseInt(request.getParameter("idPersona"));
		//2.- Llamar al Modelo
		Persona personaModelo = new Persona();
		personaModelo.delete(id);
		
		//3.- Llamar a la Vista
		request.getRequestDispatcher("ListarPersonasController").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
