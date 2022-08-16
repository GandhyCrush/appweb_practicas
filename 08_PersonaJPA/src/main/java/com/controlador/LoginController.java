package com.controlador;

/**
 * @author CI
 * @version 1.0
 * @created 08-ago-2022 16:26:04
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.modelo.dao.DAOFactory;
import com.modelo.entidades.Departamento;
import com.modelo.entidades.Persona;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginController() {

	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.- Obtener Parametros
		// 2.- Hablar con el Modelo
		// 3.- Hablar con la Vista
		request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// 1.- Obtener Parametros
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		// 2.- Hablar con el Modelo

		//Persona modelo = new Persona();
		//PersonaDAO modelo = new JDBCPersonaDAO();
		Persona p =  DAOFactory.getFactory().getPersonaDAO().autorizar(usuario, password);
		
		List<Departamento> lista = DAOFactory.getFactory().getDepartamentoDAO().getByPersona(p);
		//Persona p = modelo.autorizar(usuario, password);
		
		
		
		
		if (p != null) {

			HttpSession sesion = request.getSession();
			sesion.setAttribute("usuarioLogeado", p);
			System.out.println("Logeado");
			// 3.- Enviar los datos a la Vista
			response.sendRedirect("ListarPersonasController");
		} else {
			System.out.println("No Logeado");
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		}
	}

}