package java8.mooc.assignment.lesson.one;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lesson1 {
	  /**
	   * Run the exercises to ensure we got the right answers
	   */
	  public static  void runExercises() {
	    System.out.println("JDK 8 Lambdas and Streams MOOC Lesson 1");
	    
	    System.out.println("Running exercise 1 solution...");
	    exercise1();
	    System.out.println("Running exercise 2 solution...");
	    exercise2();
	    System.out.println("Running exercise 3 solution...");
	     exercise3();
	    System.out.println("Running exercise 4 solution...");
	    exercise4();
	    System.out.println("Running exercise 5 solution...");
	    exercise5();
	  
	  }

	  /**
	   * All exercises should be completed using Lambda expressions and the new
	   * methods added to JDK 8 where appropriate. There is no need to use an
	   * explicit loop in any of the code. Use method references rather than full
	   * lambda expressions wherever possible.
	   */
	  /**
	   * Exercise 1
	   *
	   * Create a string that consists of the first letter of each word in the list
	   * of Strings provided.
	   */
	  static  void exercise1() {
		
	    List<String> list = Arrays.asList(
	        "alpha", "bravo", "charlie", "delta", "echo", "foxtrot","Gorilla","Horse","Inkbottle");

	    StringBuilder sbr = new StringBuilder(); 
	    list.forEach( n ->  sbr.append(n.charAt(0)));
	 
	    String result = sbr.toString() ; 
	    System.out.println(" value of the result " + result );
	  	
	  
	  }
	  
	  /**
	   * Exercise 2
	   *
	   * Remove the words that have odd lengths from the list.
	   */
	  static  void exercise2() {
			
		  final List<String> names = Arrays.asList(
			        "alpha", "bravo", "charlie", "delta", "echo", "foxtrot");
		
		  final Predicate<String> oddNumberNamesPredicate  = name -> name.length() % 2 == 1; 
		  
		  List<String> filteredNames = names.stream()
				  							.filter(oddNumberNamesPredicate)
				  							.collect(Collectors.toList()); 
		 filteredNames.forEach(n -> System.out.println(n));
		  
	  }
	  
	  /**
	   * Exercise 3
	   *
	   * Replace every word in the list with its upper case equivalent.
	   */
	  static void   exercise3() {
		  
		 List<String> names = Arrays.asList(
			        "alpha", "bravo", "charlie", "delta", "echo", "foxtrot");
		 
		 // Can be done this way as well 
		 // names.replaceAll(String::toUpperCase);
		
		 // or Using a Function which takes input and Returns output 
		 Function<String,String> convertToUpperCase = n -> n.toUpperCase();
		 
		 List<String> wordsCapitalized = 		names	.stream()
				 										.map(convertToUpperCase)
				 										.collect(Collectors.toList());
		 wordsCapitalized.forEach(System.out::println);
	  }
	

	  /**
	   * Exercise 4
	   *
	   * Convert every key-value pair of the map into a string and append them all
	   * into a single string, in iteration order.
	   */
	  
	  static  void exercise4() {
		  
	    Map<String, Integer> map = new TreeMap<>();
	    map.put("c", 3);
	    map.put("b", 2);
	    map.put("a", 1);
	    
	    StringBuilder sbr = new StringBuilder();
	    
	    map.forEach((k,v) -> sbr.append(k+v));
	    String result = sbr.toString(); 
	    
	    System.out.println( "result is " +  result );
	    
   	  }
	  
	  
	  /**
	   * Exercise 5
	   *
	   * Create a new thread that prints the numbers from the list.
	   */
	  static  void exercise5() {
	    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

	    	new Thread( () ->   list.forEach(System.out::println)).start(); 
	  }
	  
	  //Main to run this as a Java Application 
	  
	  public static void main(String[] args) {
		  runExercises(); 
	}
	  
}