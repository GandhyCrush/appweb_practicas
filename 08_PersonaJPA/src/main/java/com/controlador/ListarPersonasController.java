package com.controlador;

/**
 * @author CI
 * @version 1.0
 * @created 08-ago-2022 16:26:04
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ListarPersonasController")
public class ListarPersonasController extends HttpServlet {

private static final long serialVersionUID = 1L;

	public ListarPersonasController(){

	}

	/**
	 * 
	 * @param request
	 * @param response
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		//1.- Obtener Parametros
		//2.- Hablar con el Modelo
		//3.- Hablar con la Vista
	}

	/**
	 * 
	 * @param request
	 * @param response
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		//1.- Obtener Parametros
		//2.- Hablar con el Modelo
		//3.- Hablar con la Vista
	}

}