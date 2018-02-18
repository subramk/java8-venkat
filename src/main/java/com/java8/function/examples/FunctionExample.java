package com.java8.function.examples;

import java.util.function.Function;

public class FunctionExample {
	
	private Function<Integer,Integer> incrementByOne = x -> x + 1;
	private Function<Integer,Integer> doubleIt = x -> x*2 ; 
	
	private Function<Integer,Integer> halfIt = (Integer x )  -> { 
																return x/2 ; } ; 
	
	Function<Integer, Function<Integer,Integer>> makeAdder = x -> y -> x + y;
																

	public static void main(String[] args) {
		FunctionExample fe = new FunctionExample(); 
		fe.printValues();
		
	}
																
    public void printValues() {
    	System.out.println( " IncrementByOne the number  100 is == " + incrementByOne.apply(100));
   
    	System.out.println(" double the number 25 is ==  " + doubleIt.apply(25));
    }
	

}
