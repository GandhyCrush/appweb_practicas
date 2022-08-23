package com.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.modelo.dao.DAOFactory;
import com.modelo.entidades.Persona;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Validar que las credenciales de la persona sean válidas

		// 1.- Obtengo los parámetros
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");

		// 2.- Verifico que las idenficiaciones correspondne con una persona en la BDD

		Persona personaAutenticada = DAOFactory.getFactory().getPersonaDAO().autorizarPersona(usuario, password);
		

		if (personaAutenticada != null) {
			// Creamos la sesión
			HttpSession misession = request.getSession(true);
			misession.setAttribute("usuario", personaAutenticada);
			request.getRequestDispatcher("listarPersonasController").forward(request, response);
		} else {
			response.sendRedirect("login/login.jsp");
		}

	}

}
