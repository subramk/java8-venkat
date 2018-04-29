package com.java8.constructor.references;

import java.util.function.BiFunction;
import java.util.function.Function;
import com.java8.constructor.references.TriFunction;

import java8.in.action.Apple;

public class ConstructorReferences {

	
	public static void main(String[] args) {
		ConstructorReferences crt = new ConstructorReferences() ; 
		crt.doWork() ; 
	}

	public  void doWork() {
		
		Function<Integer,Apple> appleConstructor_WeightOnly= Apple::new;
		BiFunction<Integer,String,Apple> appleConstructor_WeightAndDescription= Apple::new;
		//TriFunction<String,Integer,String,Apple> appleConstructor_ColorWeightDescription= Apple::new;
		
		
		Apple myApple = appleConstructor_WeightOnly.apply(200); 
		
		Apple appleWithWeightAndDescription = appleConstructor_WeightAndDescription.apply(100,"MyApple"); 
		
		//Apple appleWithColourWeightDescription = appleConstructor_ColorWeightDescription.apply("ReD", 100, "description"); 
		
				
				
	
		
	}
	
	
	
}
