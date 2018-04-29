package com.java8.function.examples;

import java.util.function.Function;

import java8.in.action.Apple;

public class UsingReferences {
	
	public static void main(String[] args) {
		UsingReferences ur = new UsingReferences() ; 
		ur.doWork() ; 
		
	}

	private void doWork() {
		// TODO Auto-generated method stub
	
	Function<Integer,Apple> createAppleWithWeight = Apple::new ; 
	Apple appleWeight = createAppleWithWeight.apply(200); 
	
		
	}

	
	
}
