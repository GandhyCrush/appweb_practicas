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
		procesar(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesar(request, response);

	}

	private void procesar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("usuario") == null && request.getParameter("password") == null) {
			request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
		} else {
			System.out.println("ingreso");
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
				System.out.println("al login");
				request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
			}
		}

	}

}
