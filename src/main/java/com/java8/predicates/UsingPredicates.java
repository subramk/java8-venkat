package com.java8.predicates;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 
 * {@link java.util.function.Predicate} is a Functional Interface (FI ) in Java 8 that has a Single Abstract Method (SAM) called test() . The method 
 * test() that takes in one parameter and returns a  Boolean . 
 * 
 * Normal usage . As a parameter to Stream’s methods, like filter() and anyMatch()
 * 
 * 
 * A Function<T, R> represents a function that takes a parameter of type T and returns a result of
 * type R. This is more general than a Predicate that always returns a boolean . We can use a Function anywhere we want to 
 * transform an input to another value, it’s quite logical that the map() method of the Stream Interface  uses it as its parameter.
 * 
 * 
 * 
 *  @author kasi
 *
 */
public class UsingPredicates {

	public static void main(String z[]){
		printAllFriends();
	}
	
	final static List<String> friends =  Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
	final static List<String> comrades = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");
	final static List<String> editors =  Arrays.asList("Brian", "Jackie", "John", "Mike");
	
	final static long  friends_names_startsWith_B = friends
													.stream()
													.filter( name -> name.startsWith("N")).count() ; 
	// using Method REference 
	final static long  friends_names_startsWith_N = friends
													.stream()
													.filter(UsingPredicates::filterByName)
													.count() ; 
	
	
	final Function<String, Predicate<String>> startsWithLetter4 =	letter -> name -> name.startsWith(letter);
	
		
	long countOfNamesBeginningWithLetterN  = 
			friends
			.stream()
			.filter(startsWithLetter4.apply("n")) // passing a Function as a parmeter to Filter which is also another Function - this is what is called higher order functions. 
			.count() ; 
	
	
	
	// We can remove duplication by assigning the test condition to a Predicate 
	final Predicate<String> startsWithN = name -> name.startsWith("N");
	final Predicate<String> startsWithB = name -> name.startsWith("B");
	
		
	final long countFriendsStartN = friends.stream().filter(startsWithN).count();
	final long countFriendsStartB = friends.stream().filter(startsWithB).count();

	// .... But doing it the Above way will duplicate a predicate for each Letter . 
	
	// We can remove this duplication, by Parameterizing the letter that we want to check on ....
	
	public static Predicate<String> checkIfWordStartsWith(final String letter){
		return name  -> name.startsWith(letter);
	}
	
	
	// Now we can go like this. 
	final long startingWith_N  = friends.stream().filter(checkIfWordStartsWith("N")).count(); 
	final long startingWith_B  = friends.stream().filter(checkIfWordStartsWith("B")).count(); 
							    

	// Note : checkIfStartsWith() is a higher order Function , as its ReturnType a Function as and as it is passed  like a  parameter to the Filter method
	// the streams Interface. 
	
	
	// More Refactoring 
	// checkIfStartsWith() takes a String as a parameter and returns a Predicate<String> , 
	// ie there is a Input of a String and an Output of a Predicate .  
	// In Java 8 , there is a FunctionalInterface for this type  ... 
	// This FI is called java.util.function.Function<I,O> or in API terms it is called Function(T,R) 
	
	// Input STring , return Predicate<String> 	
	final Function<String, Predicate<String>> startsWithLetter = 	(String letter) -> {
			Predicate<String> checkStartsWith = 	(String name) -> name.startsWith(letter);
			return checkStartsWith;
			};
	
	// We can remove Type information as Java 8 will infer this .  
	final Function<String, Predicate<String>> startsWithLetter2 =
					letter -> {
					Predicate<String> checkStartsWith = 	name -> name.startsWith(letter);
					return checkStartsWith;
					};
	
	// removing redundant return keyword and Predicate<String> checkStartsWith	- Very very concise....		
	//final Function<String, Predicate<String>> startsWithLetter3 =	letter -> name -> name.startsWith(letter);
	
	
		
	public static boolean filterByName(String name){
		return name.startsWith("N") ? true : false; 
			
	}
	
	public static void printAllFriends(){
		System.out.println("Printing using the normal Java 5+ way");
		for(String str : friends){
			System.out.print(" " +  str + " ");
		}
		System.out.println("....");
		System.out.println(" ~~~~~~~~~ Using the JAva 8 forEach ~~~~~~~~~~~");
		friends.forEach( friend -> System.out.println("   " + friend + "   "));
		
	}
	
	
}