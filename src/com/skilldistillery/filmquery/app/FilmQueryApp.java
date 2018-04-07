package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		app.launch();
	}

//	 private void test() {
//	 Film film = db.getFilmById(1);
//	 System.out.println(film);
//	 }

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Hello! Welcome to the Awesome Film Database (AFDB)");

		while (true) {

			System.out.println("\nPlease choose from the following options: ");
			System.out.println("1. Look a film up by it's ID.");
			System.out.println("2. Look a film up by a search keyword.");
			System.out.println("3. Exit");

			int choice = kb.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Please enter an ID number.");
				int idChoice = kb.nextInt();
				displayFilmById(idChoice);
				break;
			case 2:
				System.out.println("Please enter a keyword");
				String keywordChoice = kb.next();
				displayFilmByKeyword(keywordChoice);
				break;
			case 3:
				System.out.println("Goodbye");
				System.exit(1);
				break;
			default:
				break;
			}
		}
	}

	public void displayFilmById(int id) {

		Film f1 = db.getFilmById(id);
		if (f1 == null) {
			System.out.println("Please enter a valid ID");
			System.out.println();
		} else {
			System.out.println("Title: " + f1.getTitle());
			System.out.println("Year released: " + f1.getYear());
			System.out.println("Rating: " + f1.getRating());
			System.out.println("Description: " + f1.getDescription());
			System.out.println("Cast: " + f1.getCast());
			System.out.println("Language: " + f1.getLanguage());
		}
	}

	public void displayFilmByKeyword(String keyword) {
		List<Film> f2 = db.getFilmByKeyword(keyword);
		System.out.println(f2.size());
		if (f2.size() == 0) {
			System.out.println("Please enter a valid keyword");
			System.out.println();
		} else {
			for (Film film : f2) {
				System.out.println("Title: " + film.getTitle());
				System.out.println("Year released: " + film.getYear());
				System.out.println("Rating: " + film.getRating());
				System.out.println("Description: " + film.getDescription());
				System.out.println("Cast: " + film.getCast());
				System.out.println("Language: " + film.getLanguage());
			}
		}
	}

}
