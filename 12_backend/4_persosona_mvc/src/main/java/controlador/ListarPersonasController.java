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
 * Servlet implementation class ListarPersonasController
 */
@WebServlet("/ListarPersonasController")
public class ListarPersonasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListarPersonasController() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.- Obtener Parametros
		//2.- Hablar con el Modelo
		Persona personaModelo = new Persona();
		List<Persona> personas = personaModelo.getPersonas();
		//3.- Envio a la Vista
		request.setAttribute("personas", personas);
		request.getRequestDispatcher("jsp/listarPersona.jsp").forward(request, response);
	}

}
