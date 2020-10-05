package com.java8.function.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.java8.dto.Actor;

public class FunctionExample {
	
	private  static Function<Integer,Integer> incrementByOne = x -> {
		return x + 1;
	};

	private  static BiFunction<Integer,Integer,String> biFunction  = (x,y) -> {
		return x + y  + "number ";
	};


	private static Function<Integer,Integer> doubleIt = x -> x*2 ;
	
	private Function<Integer,Integer> halfIt = (Integer x )  -> { 
																return x/2 ; } ; 
	
	Function<Integer, Function<Integer,Integer>> makeAdder = x -> y -> x + y;
																

	public static void main(String[] args) {
		FunctionExample fe = new FunctionExample(); 
		// fe.printValues();
		fe.printFunction( incrementByOne);

		
	}


	private void doWork() {

		List<Integer> numbers = Arrays.asList(1, 2, 3 , 5 , 100);

		List<Integer> result = numbers
								.stream()
								.map( halfIt)
								.collect(Collectors.toList());

	}

	public void printValues() {
    	System.out.println( " IncrementByOne the number  100 is == " + incrementByOne.apply(100));
   
    	System.out.println(" double the number 25 is ==  " + doubleIt.apply(25));
    }
	

    public Integer printFunction(Function<Integer,Integer> myFunction){

		return myFunction.apply(5);


	}

}
