package com.java8.strategy.pattern.in.lamdas;

import java.util.List;
import java.util.function.Function;

public class StrategyPatternUsingLambdas {


	private static Function<Integer,Integer> increment = e -> e +1 ; 
	private static Function<Integer,Integer> doubleIt = e -> e * 2 ; 
	
	
	//Adding Even and Odd numbers - Java 7 way 
	
	public  Integer totalAllValues_Java7(List<Integer> listOfNumbers) {
		Integer total = 0 ; 
		for(Integer number : listOfNumbers){
			total += number; 
		}
		return total ;
	}

	public int totalEvenNumbersJava7(List<Integer> numbers) {
		Integer total = 0 ; 
		for(Integer number : numbers){
			if( number % 2 == 0){
				total += number;
			}
		}
		return total ;
	} 
	
	public int totalOddNumbersJava7(List<Integer> numbers) {
		Integer total = 0 ; 
		for(Integer number : numbers){
			if( number % 2 != 0){
				total += number;
			}
		}
		return total ;
	} 
	
	// Java 8 Way 
	public Integer  performAction(int number, Function<Integer,Integer> func){
		return func.apply(number);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
