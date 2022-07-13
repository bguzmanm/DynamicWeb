package model.dao;

import java.util.List;

import model.entity.Film;

/**
 * C -> Create 	| Crear
 * R -> Read 	| Leer
 * U -> Update 	| Actualizar
 * D -> Delete 	| Borrar
 */
public interface IFilmDAO {

	public void create(Film f);
	public List<Film> read();
	public Film read(int film_id);
	public void update(Film f);
	public void delete(int film_id);
	
	
}
