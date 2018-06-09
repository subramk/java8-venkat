package com.java8.lamdba.exception.wrapper;

import java.util.function.BiConsumer; 

public class LambdaExceptionWrapper {
	
	public static void main(String[] args) {
		LambdaExceptionWrapper lamdbWrapper = new LambdaExceptionWrapper(); 
		int[] numbers = {1,2,3,4,5,6,7,8}; 
		int key = 1 ; 
		process( numbers , key , (v,k) -> System.out.println( v/k)); 
		
	}

	private static void process(final int[] numbers, final int key,final BiConsumer<Integer,Integer> consumer) {
		for(int i: numbers) {
			consumer.accept(i, key);
		}
	}
	
	
	
	

}
