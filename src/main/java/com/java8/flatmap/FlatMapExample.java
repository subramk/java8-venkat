package com.java8.flatmap;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.java8.dto.Actor;
import com.java8.dto.ActorHelper;
import com.java8.dto.Movie;

public class FlatMapExample {

	public static void main(String z[]) {
//		FlatMapExample fme = new FlatMapExample() ;
//		fme.doWork() ;

	}

	private void doWork() {
//		List<Movie> moviesList = ActorHelper.createMovieWithActors();
//
//		// Stream<Actor>  actorsStream  = moviesWithActors.stream().flatMap( x -> x.getActors().stream());
//
//		// movieNames Collection
//		List<String> movieNames = moviesList.stream()
//		          .map(movie -> movie.getName() )
//		          .collect(Collectors.toList());
//
//		List<Date> movieDates = moviesList.stream()
//		          .map(movie -> movie.getReleaseDate() )
//		          .collect(Collectors.toList());
//
//		// Iterate through the movies and for each movie , pull out the Stream<Actor> in it. Using flatMap helps to iterate over this set
//		// to return a Collection<Actor> .
//		Set<Actor> actors  = moviesList.stream()
//		          .flatMap(movie -> movie.getActors().stream())
//		          .collect(Collectors.toSet());
//
//		actors.forEach( actor -> System.out.println("actor is " + actor));
//		// Using FlatMap
//
//
//		List<Actor> nonDuplicateActors = moviesList.stream()
//		                .flatMap( x -> x.getActors().stream())
//		                // movies has got a List<Actors> and this needs to be Flattened  out as well.
//		                .distinct()
//		                .collect(Collectors.toList());
//
//		// nonDuplicateActors.forEach(System.out::println);
//		String[] fruits = {"apples"  , "oragnes"};
//		String[] vegetables = {"onion"  , "cauliflower", "potatoes"};
//
//		Stream<List<String>> fruitsAndVegStream = Stream.of(Arrays.asList(fruits), Arrays.asList(vegetables));
//
//
//
//		List<String> fruitAndVegnames = fruitsAndVegStream.flatMap( item -> item.stream())
//						  .collect(Collectors.toList());
//
//		fruitAndVegnames.forEach(System.out::println);
//
//

	}


}
