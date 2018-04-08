package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;
import com.skilldistillery.filmquery.entities.Language;

public class DatabaseAccessorObject implements DatabaseAccessor {

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid";
	private static final String user = "student";
	private static final String pass = "student";

	@Override
	public Film getFilmById(int filmId) {
		Film film = null;
		String sql = "SELECT film.id, title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features FROM film WHERE film.id = ?";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			int id = 0;
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int fid = rs.getInt(1);
				String title = rs.getString(2);
				String description = rs.getString(3);
				int releaseYear = rs.getInt(4);
				int languageId = rs.getInt(5);
				int rentalDur = rs.getInt(6);
				double rentalRate = rs.getDouble(7);
				int length = rs.getInt(8);
				double replaceCost = rs.getDouble(9);
				String rating = rs.getString(10);
				String specialFeatures = rs.getString(11);
				film = new Film(fid, title, description, releaseYear, languageId, rentalDur, rentalRate, length,
						replaceCost, rating, specialFeatures, getActorsByFilmId(filmId));
				film.setLanguage(getLanguagesByFilmLangId(languageId));
				// List<Actor> cast = getActorsByFilmId(filmId);
				// film.setCast(cast);
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("Error retrieving film with film ID " + filmId);
			e.printStackTrace();
		}

		return film;
	}

	@Override
	public Actor getActorById(int actorId) {
		Actor actor = null;
		String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int aid = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				actor = new Actor(aid, firstName, lastName);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("Error retrieving actor with actor ID " + actorId);
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Film> getFilmByKeyword(String keyword) {
		List<Film> films = new ArrayList<>();
		String sql = "select title, description, release_year, rating, film.id, film.language_id from film where title like ? or description like ?";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String title = rs.getString(1);
				String description = rs.getString(2);
				int year = rs.getInt(3);
				String rating = rs.getString(4);
				films.add(new Film(title, description, year, rating, getActorsByFilmId(rs.getInt(5)),
						getLanguagesByFilmLangId(rs.getInt(6))));
			}
		} catch (SQLException e) {
			System.err.println("Error retrieving film with keyword: " + keyword);
			e.printStackTrace();
		}
		return films;
	}

	@Override
	public List<Actor> getActorsByFilmId(int filmId) {
		List<Actor> cast = new ArrayList<>();
		String sql = "SELECT id, first_name, last_name FROM actor JOIN film_actor ON actor.id = film_actor.actor_id WHERE film_id = ?";

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				Actor actor = new Actor(id, firstName, lastName);
				cast.add(actor);
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			System.err.println("Error retrieving actor with film ID " + filmId);
			e.printStackTrace();
		}

		return cast;
	}

	public Language getLanguagesByFilmLangId(int filmLangId) {
		Language language = null;
		String sql = "SELECT id, name FROM language WHERE id = ?";
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmLangId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				language = new Language(name, id);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println();
			e.printStackTrace();
		}
		return language;
	}

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Unable to load database driver. Exiting.");
			e.printStackTrace();
			System.exit(1);
		}

	}

}
