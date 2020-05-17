package com.java8.function.examples;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;


// 
public class GenericPredicateFilter {
	
	
	// A method that takes  a Collection of items of type T and runs a Predicate of that Type on it 
	// and returning a List<T> as a result ; 
	
	// T extends Collection<T> - defines what T is 
	// List<T> - this is the return type 
	// 
	
	public  <T extends Collection<T>> List<T> genericFilter( final Collection<T> listOfItems,  final Predicate<T> predicate){
		
		if(Objects.nonNull(listOfItems)) {
			return listOfItems.stream()
							  .filter( x -> predicate.test(x))
							  .collect(Collectors.toList()); 
		}
		
		return Collections.emptyList()  ; 
		
	}

}
