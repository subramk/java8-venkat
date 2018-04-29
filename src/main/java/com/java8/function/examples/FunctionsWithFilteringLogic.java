package com.java8.function.examples;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.java8.function.predicate.HealthApplePredicate;
import com.java8.function.predicate.HeavyApplePredicate;

import java8.in.action.Apple;

public class FunctionsWithFilteringLogic {

	public static void main(String[] args) {
		FunctionsWithFilteringLogic fe = new  FunctionsWithFilteringLogic(); 
		
		List<Apple> applesList = populateApples();
	
		Predicate<Apple> healthApple =  new HealthApplePredicate();
		Predicate<Apple> heavierApple  = new HeavyApplePredicate();
		
		List<Apple> healthyAppleList  = fe.filterApplesBasedOnPredicate(applesList, healthApple );
		//System.out.println( " Count  of  Health Apples " + healthyAppleList.size() );
		
		List<Apple> heavyAppleList    = fe.filterApplesBasedOnPredicate(applesList, heavierApple ); 
		//System.out.println( " Count  of  Heavy  Apples " + heavyAppleList.size() );
		
		// Sorting using Comparator 
		List<Apple> listOfApples = populateApples(); 
		
		// using Comparing 
		listOfApples.sort(comparing(Apple::getWeight));
		
		listOfApples.sort( (Apple a1, Apple a2) -> a1.getWeight() - (a2.getWeight()) ); 
		// After Sorting 
		System.out.println("After sorting of Apples ");
		listOfApples.forEach( a -> System.out.println(a.getWeight()));
		
	
		
		
		
	}

	// Generic Method that takes a list of Apples and runs a Predicate through them and returns a Collection of Apples. 
	private List<Apple>  filterApplesBasedOnPredicate(List<Apple> applesList , Predicate<Apple> p ) {
				return 	applesList	.stream()
									.filter( apple -> p.test(apple))
									.collect(Collectors.toList()); 
					
		
		
	}
	
	private static List<Apple> populateApples() {
		List<Apple> applesList = new ArrayList<Apple>();
		applesList.add( new Apple(150 , "Green" , "GreenApple150")); 
		applesList.add( new Apple(100 , "Red" , "RedApple100")); 
		applesList.add( new Apple(75 , "Pink" , "PinkApple75")); 
		applesList.add( new Apple(75 , "Blue" , "BlueApple75")); 
		
		return applesList ; 
	}
	
	
		
	
}
