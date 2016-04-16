package com.stl.java8.examples;

import java.util.function.BiFunction;



/**
 * 
 * 
 * BiFunction is a FI that takes one two input parameters and returns one output parameter. 
 * All of them must be of the SAME TYPE . 
 * 
 * 
 * 
 * @author kasi
 *
 */
public class BiFunctionExample {

	static void main(String z[]){
		
		bifunctionExample(); 
	}

	private static void bifunctionExample() {
		
	}
	
	public static String testStringCombiner(BiFunction<String ,String,String> biFunc){
		return "Hello World" ; 
	}
	
	
	
}