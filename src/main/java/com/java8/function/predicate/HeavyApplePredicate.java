package com.java8.function.predicate;

import java.util.function.Predicate;

import java8.in.action.Apple;

public class HeavyApplePredicate implements Predicate<Apple> {

	@Override
	public boolean test(Apple t) {
		
		return t.getWeight() > 99  ; 
	}
	

}
