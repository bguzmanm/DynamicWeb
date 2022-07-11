package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/")
public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InicioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie cookie = new Cookie("nombre", "Brian");		
		Cookie cookie2 = new Cookie("edad", "46");		
		cookie.setComment("No borres esta cookie");
		cookie.setMaxAge(3000);
		
		response.addCookie(cookie);
		response.addCookie(cookie2);
		
		request.setAttribute("nombre", "Brian");
		
		HttpSession sesion = request.getSession(true);
		
		sesion.setAttribute("apellido", "Guzmán");
		
		
		
		getServletContext().getRequestDispatcher("/view/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
