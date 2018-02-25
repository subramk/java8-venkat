package com.java8.function.predicate;

import java.util.function.Predicate;

import com.java8.function.examples.Apple;

public class HealthApplePredicate implements Predicate<Apple> {

	@Override
	public boolean test(Apple t) {
		// TODO Auto-generated method stub
		return t.getWeight() > 88 && t.getColour().equalsIgnoreCase("RED") ; 
	}
	

}
