package com.java8.Predicates;

import java.util.function.Function;

public class FunctionsBasic {
	
	private Function<Integer,Integer> add = x -> x + 1 ; 
	private Function<Integer,Integer> doubleTheNumber  =  x -> x*2 ; 
	private Function<Integer,Integer> halveTheNumber = (Integer x ) ->  { return x/2;} ; 
	
	
	public static void main() {
		FunctionsBasic tester = new FunctionsBasic();
		
		tester.runExamples();
		
	}
	private void runExamples() {
	 
		System.out.println(" Add operation on Integer 89 " + add.apply(89 )) ;
		
		
	}
	

}
