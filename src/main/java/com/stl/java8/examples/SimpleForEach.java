package com.stl.java8.examples;

import java.util.Arrays;
import java.util.List;

public class SimpleForEach {

	public  void useExternalIteartorToLoopThroughCollection() {

		List<String> names = Arrays.asList("Kasi", "Jaggi", "Sai", "Reddy"); 

		//External Iteration where we use the normal iterator 
		for (String name  : names) {
			System.out.println(" Pre Java 8 ---- printing out the names " + name  );
		}

		// Internal Iterator  - Tell the compiler WHAT  to do , not HOW 

		// forEach takes a lambda expression ... this lambda accepts a Consumer FI as its parameter ( FI -- functional Interface ) . 
		names.forEach(e -> System.out.println(e));
		//USING METHOD REFERENCES
		
		System.out.println("~~~~~~~~~~~~~~~~ Using Method References to print names...");
		names.forEach(SimpleForEach::printInCaps);
		
		
		
	}
	
	// We mimic a Consumer here , Consumer is a FI that takes an argument and returns Nothing , the printInCaps() just does that !! 
	
	private static void printInCaps(final String name){
		System.out.println(name.toUpperCase()) ; 
		
		
	}


}


