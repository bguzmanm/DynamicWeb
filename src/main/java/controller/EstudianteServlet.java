package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.service.EstudianteService;

@WebServlet("/estudiante")
public class EstudianteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EstudianteServlet() {
        super();
    }
    
    
    EstudianteService es = new EstudianteService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setAttribute("estudiantes", es.getEstudiantes());
		
		getServletContext().getRequestDispatcher("/view/estudiantes.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
