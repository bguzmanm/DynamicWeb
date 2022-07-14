package model.service;

import java.util.List;

import model.entity.Film;

public interface FilmService {

	public void create(Film f);
	public List<Film> read();
	public Film read(int film_id);
	public void update(Film film);
	public void delete(int film_id);
	
}
