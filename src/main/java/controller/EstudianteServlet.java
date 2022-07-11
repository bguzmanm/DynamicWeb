package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entity.Estudiante;
import model.service.EstudianteService;

@WebServlet("/estudiante")
public class EstudianteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EstudianteServlet() {
        super();
    }
    
    
    EstudianteService es = new EstudianteService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = request.getParameter("op");
		
		/*//código ejemplo de uso de cookies.
		for (Cookie cookie: request.getCookies()) {
			if (cookie.getName().equals("nombre")) {
				request.setAttribute("nombre", cookie.getValue());
			}
		}*/
		
		if (op == null) {
			op = "list";
		}
		
		if (op.equalsIgnoreCase("list")) {
			HttpSession sesion = request.getSession(true);
			
			request.setAttribute("apellido", sesion.getAttribute("apellido"));
			
			if (sesion.getAttribute("estudiantes") == null) {
				System.out.println("Pido datos estudiatnes a BD.");
				sesion.setAttribute("estudiantes", es.getEstudiantes());
			}
			
			request.setAttribute("estudiantes", sesion.getAttribute("estudiantes"));
			
			getServletContext().getRequestDispatcher("/view/estudiantes.jsp").forward(request, response);
		} else {
			if (op.equalsIgnoreCase("new")) {
				getServletContext().getRequestDispatcher("/view/estudiante.jsp").forward(request, response);
			}
		}
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		
		if (op.equalsIgnoreCase("new")) {
			HttpSession sesion = request.getSession(true);
			List<Estudiante> estudiantes = (List<Estudiante>) sesion.getAttribute("estudiantes");
			
			Estudiante estudiante = new Estudiante();
			estudiante.setNombre(request.getParameter("nombre"));
			estudiante.setApellido(request.getParameter("apellido"));
			estudiante.setRut(request.getParameter("rut"));
			String startDateStr = request.getParameter("nacimiento");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			
			try {
				estudiante.setNacimiento(sdf.parse(startDateStr));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//estudiante.setNacimiento(Date.parse(request.getParameter("nacimiento")));
			estudiante.setIngresos(Double.parseDouble(request.getParameter("ingresos")));
			
			estudiantes.add(estudiante);
			
			sesion.setAttribute("estudiantes", estudiantes);
			
			request.setAttribute("estudiantes", sesion.getAttribute("estudiantes"));
			
			getServletContext().getRequestDispatcher("/view/estudiantes.jsp").forward(request, response);
			
		}
		
	}

}
