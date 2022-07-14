package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.service.FilmService;
import model.service.FilmServiceImpl;
import model.entity.Film;

@WebServlet("/films")
public class FilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	private FilmService service = new FilmServiceImpl();
	
    public FilmServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = request.getParameter("op");
		String jsp = "";
		
		if (op==null) {
			op = "list";
		}
		
		switch (op) {
		case "list": {
			request.setAttribute("films", service.read());
			jsp = "/view/films.jsp";
			break;
		}
		case "edit": {
			String film_id = request.getParameter("id");
			request.setAttribute("film", service.read(Integer.parseInt(film_id)));
			
			
			jsp = "/view/film.jsp";
			
			break;
		}
		case "new":{
			
			jsp = "/view/film.jsp";
			
			break;
		}
		
		case "del": {
			String film_id = request.getParameter("id");
			service.delete(Integer.parseInt(film_id));
			request.setAttribute("films", service.read());
			jsp = "/view/films.jsp";
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + op);
		}

		request.setAttribute("op", op);		
		getServletContext().getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		String jsp = "/view/films.jsp";
		
		Film film;
		if (op == null) {
			op = "new";
		}
		
		switch (op) {
		case "edit":
			
			film = service.read(Integer.parseInt(request.getParameter("film_id")));
			
			//film.setFilm_id(Integer.parseInt(request.getParameter("film_id")));
			film.setTitle(request.getParameter("title"));
			film.setDescription(request.getParameter("description"));
			film.setRelease_year(Integer.parseInt(request.getParameter("release_year")));
			film.setRating(request.getParameter("rating"));
			film.setSpecial_features(request.getParameter("special_features"));
			
			service.update(film);
			
			break;
		case "new":
			
			film = new Film();
			film.setTitle(request.getParameter("title"));
			film.setDescription(request.getParameter("description"));
			film.setRelease_year(Integer.parseInt(request.getParameter("release_year")));
			film.setRating(request.getParameter("rating"));
			film.setSpecial_features(request.getParameter("special_features"));
			
			service.create(film);
			
			break;
		default:
			break;
		}
		
		request.setAttribute("op", "list");		
		request.setAttribute("films", service.read());
		getServletContext().getRequestDispatcher(jsp).forward(request, response);
		
		

	}

}
