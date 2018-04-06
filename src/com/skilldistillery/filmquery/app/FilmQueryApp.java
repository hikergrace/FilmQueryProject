package com.skilldistillery.filmquery.app;

import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
  
  DatabaseAccessor db = new DatabaseAccessorObject();

  public static void main(String[] args) {
    FilmQueryApp app = new FilmQueryApp();
    app.test();
//    app.launch();
  }

  private void test() {
    Film film = db.getFilmById(1);
    System.out.println(film);
  }

  private void launch() {
    Scanner input = new Scanner(System.in);
    
    startUserInterface(input);
    
    input.close();
  }

  private void startUserInterface(Scanner input) {
    Scanner kb = new Scanner(System.in);
    System.out.println("Hello! Welcome to the Awesome Film Database (AFDB)");

    DatabaseAccessorObject dbo = new DatabaseAccessorObject();
    
    int choice = kb.nextInt();
    
    System.out.println("Please choose from the following options: ");
    System.out.println("1. Look a film up by it's ID.");
    System.out.println("2. Look a film up by a search keyword.");
    System.out.println("3. Exit");
    
    switch(choice) {
    case 1:
    		dbo.getFilmById(int);
    		break;
    case 2: 
    	
    		break;
    case 3: 
    		System.out.println("Goodbye");
    		System.exit(1);
    		break;
    }
  }

}
