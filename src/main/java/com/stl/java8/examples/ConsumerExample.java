package com.stl.java8.examples;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 
 * Consumer FI has one method accept() that takes a parameter and returns nothing.
 * 
 * Usage : used as a parameter in forEach() method of the StreamsAPI 
 * 
 * 
 * @author kasi
 *
 */
public class ConsumerExample {

	final static List<String> friends =  Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
	
	public static void print_Using_Consumer_Functional_Interface(){
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Printing using a Consumer FI implementation ");
		
		// Supplier TAKES no Args and returns the desired type as speficied in Supplier<T>
		// Examples . 
		Supplier<String> stringSupply = () -> "someStringReturned" ; 
		
		Supplier<Date> todaysDate = () -> Calendar.getInstance().getTime() ; 
		
		
		// Consumer - just consumes , could have side effects. 
		//  Usage : used in forEach() method of the StreamsAPI 
		friends.forEach( new Consumer<String>() {
			@Override
			public void accept(String name) {
				System.out.print(" " +  name + " ");
				
			}
		});
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Printing with ForEach using a Consumer --- public void accept(T t) ");
		
		friends.forEach(ConsumerExample::printNames);
		
	}
	
	public static void printNames(String name){
		System.out.print(" " +  name + " ");
	}
	
	public static void main(String[] args) {
		 print_Using_Consumer_Functional_Interface();
	}
	
	
	
	

}
