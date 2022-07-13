package model.service;

import java.util.List;

import model.dao.FilmDAO;
import model.dao.IFilmDAO;
import model.entity.Film;

public class FilmServiceImpl implements FilmService{

	
	IFilmDAO dao = new FilmDAO();
	
	@Override
	public List<Film> read() {
		
		return dao.read();
		
		
	}

}
