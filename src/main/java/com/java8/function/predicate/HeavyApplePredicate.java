package com.java8.function.predicate;

import java.util.function.Predicate;

import com.java8.function.examples.Apple;

public class HeavyApplePredicate implements Predicate<Apple> {

	@Override
	public boolean test(Apple t) {
		
		return t.getWeight() > 99  ; 
	}
	

}
