package com.controlador;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.modelo.dao.DAOFactory;

@WebServlet("/listarPersonasController")
public class ListarPersonasController extends HttpServlet{


	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		procesarSolicitud(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		procesarSolicitud(req, resp);
	}
	
	private void procesarSolicitud(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
			req.setAttribute("personas", DAOFactory.getFactory().getPersonaDAO().get());
			getServletContext().getRequestDispatcher("/jsp/listarPersonas.jsp").forward(req, resp);
			
		
		
	}
	

}
