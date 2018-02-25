package com.java8.function.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {
	
	public static void main(String[] args) {
		FunctionExample fe = new FunctionExample();
		fe.doWork(); 
		
	}

	private void doWork() {
		// TODO Auto-generated method stub
		Function<Integer, Integer> doubleIt = x -> x * 2 ; 
		// declarative way 
		// Function<Integer,Integer> halfIt = (Integer x)  ->  { return x/2 ;}  ; 
		Function<Integer,Integer> halfIt = (Integer x)  ->  x/2 ; 
		
		List<Integer> numbers = Arrays.asList(2,4,6,8,10); 
		
		// we pass the behaviour to a Function  ( ie the Function halfIt or doubleIt represents the behaviour. ) 
		performOperationOn(numbers, doubleIt); 
		performOperationOn(numbers, halfIt); 
		
	
		
		
		
		
	}

	private void performOperationOn(List<Integer> numbers, Function<Integer, Integer> f) {
		numbers.forEach( x -> System.out.println("The Number " + x + "  After operation is equal to " +  f.apply(x)) ) ;
		
	}

}
