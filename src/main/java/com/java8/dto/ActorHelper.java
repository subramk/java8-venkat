package com.java8.dto;

import java.util.ArrayList;
import java.util.List;

public final class ActorHelper {

	public  static List<Actor> populateListOfActors() {
		Actor actor1 = new Actor("rajini", 66 , "Male"); 
		Actor actor2 = new Actor("Kamal", 60 , "Male"); 
		Actor actor3 = new Actor("sreepriya", 64 , "Female"); 
		Actor actor4 = new Actor("bhanupriya", 46 , "Female"); 
		Actor actor5 = new Actor("Vadivel", 44 , "Male");
		
		List<Actor> actors = new ArrayList<Actor>(); 
		actors.add(actor1); 
		actors.add(actor2); 
		actors.add(actor3); 
		actors.add(actor4); 
		actors.add(actor5); 
		
		return actors; 
	}
	
	public static List<Movie> createMovieWithActors() {
		List<Movie> movies = new ArrayList<Movie>(); 
		List<Actor> actors = populateListOfActors() ;
		
		Movie m1 = new Movie("Raiders of the lost ARk", 23);
		m1.setActors(actors);
		
		Movie m2 = new Movie("Tomb Raiders", 24);
		m2.setActors(actors); 
		
		Movie m3 = new Movie("Superman2", 25);
		List<Actor> actorsList3 = new ArrayList<Actor>();
		Actor actor3 = new Actor("sreepriya", 64 , "Female"); 
		Actor actor3_1 = new Actor("Micheal", 64 , "MAle"); 
		
		actors.add(actor3);
		actors.add(actor3_1);
		
		m3.setActors(actorsList3);
		
		Movie m4 = new Movie("The Predators", 28);
		List<Actor> actorsList4 = new ArrayList<Actor>();
		Actor actor4 = new Actor("Rocky", 64 , "Male");
		Actor actor4_1 = new Actor("Rambo", 44 , "Female");
		
		actorsList4.add(actor4);
		actorsList4.add(actor4_1);
		
		m4.setActors(actorsList4);
		
		movies.add(m1); 
		movies.add(m2); 
		movies.add(m3); 
		movies.add(m4); 
		
		return movies;
	}
}
