package com.java8.predicates;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 
 * {@link java.util.function.Predicate} is a FI in Java 8 that has a SAM test() that takes in one parameter and returns a
 * Boolean . 
 * 
 * Normal usage . As a parameter to Stream’s methods, like filter() and anyMatch()
 * 
 * 
 * A Function<T, R> represents a function that takes a parameter of type T and returns a result of
 * type R. This is more general than a Predicate that always returns a boolean . We can use a Function anywhere we want to 
 * transform an input to another value, it’s quite logical that the map() method uses it as its parameter.
 * 
 *  @author kasi
 *
 */
public class UsingPredicates {
	
	
	
	final static List<String> friends =  Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
	final static List<String> comrades = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");
	final static List<String> editors =  Arrays.asList("Brian", "Jackie", "John", "Mike");
	
	final static long  friends_names_startsWith_B = friends
													.stream()
													.filter( name -> name.startsWith("N")).count() ; 
	// using Method REference 
	final static long  friends_names_startsWith_N = friends
													.stream()
													.filter(UsingPredicates::filterNames).count() ; 
	
	// We can remove duplication by assigning the test condition to a Predicate 
	final Predicate<String> startsWithN = name -> name.startsWith("N");
	final Predicate<String> startsWithB = name -> name.startsWith("B");
	
		
	final long countFriendsStartN = friends.stream().filter(startsWithN).count();
	final long countFriendsStartB = friends.stream().filter(startsWithB).count();

	// .... But doing it the Above way will duplicate a predicate for each Letter . 
	
	// We can remove this duplication, by Parameterizing the letter that we want to check on ....
	public static Predicate<String> checkIfStartsWith(final String letter){
		return name  -> name.startsWith(letter);
	}
	
	// Now 
	final long startingWith_N  = friends.stream().filter(checkIfStartsWith("N")).count(); 
	final long startingWith_B  = friends.stream().filter(checkIfStartsWith("B")).count(); 
	
	// Note : checkIfStartsWith() is a higher order Function , as it returns a Function
	
	// checkIfStartsWith() takes a String as a parameter and returns a Predicate<String> , 
	// We can model this behaviour as a java.util.function.Function
	
	
	final Function<String, Predicate<String>> startsWithLetter =
			(String letter) -> {
			Predicate<String> checkStartsWith = 	(String name) -> name.startsWith(letter);
			return checkStartsWith;
			};
	
	// This can be refactored further like this by removing the type information ( ie String ) 
	final Function<String, Predicate<String>> startsWithLetter2 =
					letter -> {
					Predicate<String> checkStartsWith = 	name -> name.startsWith(letter);
					return checkStartsWith;
					};
	
	// removing redundant return and Predicate<String> checkStartsWith	- Very very concise....		
	final Function<String, Predicate<String>> startsWithLetter3 =	letter -> name -> name.startsWith(letter);
							
	
	
	public static boolean filterNames(String name){
		return name.startsWith("N") ? true : false; 
			
	}
	
	public static void printAllFriends(){
		System.out.println("Printing using the normal Java 5+ way");
		for(String str : friends){
			System.out.print(" " +  str + " ");
		}
		System.out.println();
		
		
	}
	
	
	
	
	public static void main(String z[]){
		UsingPredicates dd = new UsingPredicates();
		dd.printAllFriends();
		
	}

}
