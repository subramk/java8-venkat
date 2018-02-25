package com.java8.function.examples;

import java.util.function.Function;

public class FunctionExample2 {
	
	private Function<Integer,Integer> incrementByOne = x -> x + 1;
	private Function<Integer,Integer> doubleIt = x -> x*2 ; 
	
	private Function<Integer,Integer> halfIt = (Integer x )  -> { 
																return x/2 ; } ; 
	
	Function<Integer, Function<Integer,Integer>> makeAdder = x -> y -> x + y;
																

	public static void main(String[] args) {
		FunctionExample2 fe = new FunctionExample2(); 
		fe.printValues();
		
	}
																
    public void printValues() {
    	System.out.println( " IncrementByOne the number  100 is == " + incrementByOne.apply(100));
   
    	System.out.println(" double the number 25 is ==  " + doubleIt.apply(25));
    	
    	System.out.println(makeAdder.apply(5).apply(10) ); 
    	
    }
	
    public static Function<Integer,Integer> adder(Integer x){
    	return y -> x + y ; 
    }

}
