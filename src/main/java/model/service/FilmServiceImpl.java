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

	@Override
	public Film read(int film_id) {
		return dao.read(film_id);
	}

	@Override
	public void update(Film film) {
		dao.update(film);
	}

	@Override
	public void create(Film f) {
		dao.create(f);
		
	}

	@Override
	public void delete(int film_id) {
		dao.delete(film_id);
	}

}
