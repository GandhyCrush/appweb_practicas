package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Persona;

/**
 * Servlet implementation class InsertarPersonaController
 */
@WebServlet("/InsertarPersonaController")
public class InsertarPersonaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertarPersonaController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.- obtener parámetros
		// 2.- Llamar al modelo
		// 3.- Llamar a la vista
		request.getRequestDispatcher("jsp/insertarPersona.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.- obtener parámetros
		//int id = Integer.parseInt(request.getParameter("txtId"));
		String nombre = request.getParameter("txtNombre");
		String clave = request.getParameter("txtClave");
		
		// 2.- Llamar al modelo
		Persona personaModelo = new Persona();
		
		Persona p = new Persona();
		p.setNombre(nombre);
		p.setPassword(clave);
		
		if(personaModelo.create(p)) {
			System.out.println("Persona insertada");
			// 3.- Llamar a la vista
			request.getRequestDispatcher("ListarPersonasController").forward(request, response);;
		}else {
			System.out.println("No se insertó.");
		}
	}

}
