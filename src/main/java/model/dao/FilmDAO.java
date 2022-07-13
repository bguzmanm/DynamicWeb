package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.conn.Conexion;
import model.entity.Film;

public class FilmDAO implements IFilmDAO {

	@Override
	public void create(Film f) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Film> read() {
		List<Film> lista = new ArrayList<Film>();
		
		try {
			
			String sql = "select film_id, title, description, release_year, "
					+ "rating, special_features from film";
			
			Connection cnn = Conexion.getConnection();
			
			Statement stm = cnn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				/*
				Film f = new Film();
				f.setFilm_id(rs.getInt("film_id"));
				f.setTitle(rs.getString("title"));
				f.setDescription(rs.getString("description"));
				f.setRelease_year(rs.getInt("release_year"));
				f.setRating(rs.getString("rating"));
				f.setSpecial_features(rs.getString("special_features"));
				lista.add(f);
				*/

				lista.add(new Film(rs.getInt("film_id"), rs.getString("title"), 
						rs.getString("description"), rs.getInt("release_year"),
						rs.getString("rating"), rs.getString("special_features")));
			}
			
			
		} catch (SQLException e) {
			System.out.println("Error al consiultar la BD");
			e.printStackTrace();
		}
		
		
		return lista;
	}

	@Override
	public Film read(int film_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Film f) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int film_id) {
		// TODO Auto-generated method stub

	}

}
