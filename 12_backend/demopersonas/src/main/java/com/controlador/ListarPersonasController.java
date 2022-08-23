package com.controlador;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.modelo.dao.DAOFactory;
import com.modelo.entidades.Persona;

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
	
	private void procesarSolicitud(HttpServletRequest req, HttpServletResponse resp) {
		
		
		try {
			List<Persona> personas =DAOFactory.getFactory().getPersonaDAO().get();
						
			//Llamar a vista y entregar los datos
			req.setAttribute("personas", personas);
			getServletContext().getRequestDispatcher("/login/listarPersonas.jsp").forward(req, resp);
			
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
