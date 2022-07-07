package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/estudiante")
public class EstudianteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EstudianteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//String[] estudiantes = new String[2];
		
		List<String> estudiantes = new ArrayList<String>();
		
		estudiantes.add("Pamela Correa");
		estudiantes.add("Mauricio Seguel");
		estudiantes.add("Sergio Terán");
		
		
		request.setAttribute("estudiantes", estudiantes);
		
		getServletContext().getRequestDispatcher("/view/estudiantes.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
