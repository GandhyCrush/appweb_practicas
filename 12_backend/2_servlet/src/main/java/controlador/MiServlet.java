package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet")
public class MiServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("El servlet se ha inicializado");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doGet(req, resp);
		System.out.println("Ingres{o a GET");
		String parametro = req.getParameter("txtNombre");
		
		// Escribir el HTML
		PrintWriter out =  resp.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>Hola " + parametro + "</h1>" );
		out.print("</body>");
		out.print("</html>");
		out.close();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		System.out.println("Ingres{o a POST");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("Se ha destruido");
	}

	

	
}
