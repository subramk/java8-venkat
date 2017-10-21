package com.stl.java8.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


// taken from the Examples from Venkat S videos on youtube . 

public class HigherOrderFunctions {
	
		
		
		public static void main(String[] args) {
			HigherOrderFunctions hof = new HigherOrderFunctions(); 
			hof.doWork() ;
		}
		
		public static int totalValues(List<Integer> values, Predicate<Integer> selector) {
//			int result = 0 ; 
//			for(int e : values) {
//			if(selector.test(e))
//				result += e;
//			}
//			//return result;
			
			//return values.stream().filter(selector).reduce(0, Integer::sum); 
			return values.stream()
						 .filter(selector)
						 .mapToInt(e -> e).sum() ; 
			
		}

		// When we pass in e -> e % 2  ==  0 into the totalValues method , we are passing in BEHAVIOR into the selector Predicate<Integer>.
		
		private void doWork() {
			List<Integer> numbers =  Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13)	; 
			System.out.println(totalValues( numbers, e -> true)); // all numbers 
			System.out.println(totalValues( numbers, e -> e % 2  ==  0 ));// even numbers
			System.out.println(totalValues( numbers, e -> e % 2  !=  0 )); // Odd numbers 
			
			//
			numbers.stream().map(e -> String.valueOf(e)) // convert from in toString 
							.map(String::toString) // toString 
							.forEach(System.out::println); // print the String. 
			
			// using BinaryOperator , note here that the two parameters of the reduce method get passed into the lambda very differently . 
			// ie the first parameter 'carry' gets used as a target (ie carry.xxx ) while the second parameter of 'str' gets used as a parameter. 
			System.out.println(
					numbers.stream()
					.map(String::valueOf)
					.reduce("" , (carry,str) -> carry.concat(str))
			);
			
			Predicate<Integer> evenNumberPredicate = x -> (x%2 == 0) ; 
			
			System.out.println(" Choose the even numbers and double it ...... " +
					numbers.stream()
					.filter(evenNumberPredicate)
					.mapToInt(e -> e * 2)
					.reduce(Integer::sum));
			
		}
}