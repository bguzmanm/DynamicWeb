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
		String sql = "";
		try {

			sql = "insert into film (title, description, release_year, rating, special_features, language_id) " + "values ('"
					+ f.getTitle() + "', '" + f.getDescription() + "', " + f.getRelease_year() + ", '" + f.getRating()
					+ "', '" + f.getSpecial_features() + "', 1) ";

			Connection cnn = Conexion.getConnection();

			Statement stm = cnn.createStatement();

			stm.execute(sql);

		} catch (SQLException e) {
			System.out.println("Error al consiultar la BD: " + sql);
			e.printStackTrace();
		}
	}

	@Override
	public List<Film> read() {
		List<Film> lista = new ArrayList<Film>();

		try {

			String sql = "select film_id, title, description, release_year, " + "rating, special_features from film";

			Connection cnn = Conexion.getConnection();

			Statement stm = cnn.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				/*
				 * Film f = new Film(); f.setFilm_id(rs.getInt("film_id"));
				 * f.setTitle(rs.getString("title"));
				 * f.setDescription(rs.getString("description"));
				 * f.setRelease_year(rs.getInt("release_year"));
				 * f.setRating(rs.getString("rating"));
				 * f.setSpecial_features(rs.getString("special_features")); lista.add(f);
				 */

				lista.add(new Film(rs.getInt("film_id"), rs.getString("title"), rs.getString("description"),
						rs.getInt("release_year"), rs.getString("rating"), rs.getString("special_features")));
			}

		} catch (SQLException e) {
			System.out.println("Error al consiultar la BD");
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public Film read(int film_id) {
		Film film = new Film();

		try {

			String sql = "select film_id, title, description, release_year, "
					+ "rating, special_features from film where film_id = " + film_id;

			Connection cnn = Conexion.getConnection();

			Statement stm = cnn.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			if (rs.next()) {
				film = new Film(rs.getInt("film_id"), rs.getString("title"), rs.getString("description"),
						rs.getInt("release_year"), rs.getString("rating"), rs.getString("special_features"));
			}

		} catch (SQLException e) {
			System.out.println("Error al consiultar la BD");
			e.printStackTrace();
		}

		return film;
	}

	@Override
	public void update(Film f) {

		try {

			String sql = "update film set title = '" + f.getTitle() + "', description = '" + f.getDescription()
					+ "', release_year=" + f.getRelease_year() + ", rating = '" + f.getRating()
					+ "', special_features = '" + f.getSpecial_features() + "' where film_id = " + f.getFilm_id();

			Connection cnn = Conexion.getConnection();

			Statement stm = cnn.createStatement();

			stm.execute(sql);

		} catch (SQLException e) {
			System.out.println("Error al consiultar la BD");
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int film_id) {
		try {

			String sql = "delete from film where film_id = " + film_id;

			Connection cnn = Conexion.getConnection();

			Statement stm = cnn.createStatement();

			stm.execute(sql);

		} catch (SQLException e) {
			System.out.println("Error al consiultar la BD");
			e.printStackTrace();
		}
	}

}
