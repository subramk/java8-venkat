package com.stl.java8.examples;

import java.util.ArrayList;
import java.util.Comparator;
import static java.util.Comparator.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


import util.Utilities; 

public class FunctionalComparators {
	
	private static List<Person> personsList = new ArrayList<Person>(); 
	
	private Comparator<Person> personAgeAscendingComparator = (person1, person2) -> person1.ageDifference(person2);

	private Comparator<Person> personDescendingComparator = personAgeAscendingComparator.reversed() ; 
	
	// Passing Functions into Comparators so that multiple comparators can be chained to form a sequence of comparisons. 
	
	private Function<Person,Integer> byTheirAge = person -> person.getAge();
	private Function<Person,String> byTheirName = person -> person.getName();
	
	
	
	static {
		personsList.add( new Person("John", 20 )); 
		personsList.add( new Person("Angel", 21 )); 
		personsList.add( new Person("Sam", 22 )); 
		personsList.add( new Person("Beck", 23 ));
		personsList.add( new Person("Beatury", 26)); 
		personsList.add( new Person("Sally", 24 )); 
		personsList.add( new Person("Susie", 46 )); 
		
		
	}
	public static void main(String[] args) {
		FunctionalComparators fc = new FunctionalComparators();
		Utilities.print("Start");
		fc.performOps();
		fc.compartorsUsingFunctions();
		Utilities.print("End");
	}

	private void compartorsUsingFunctions() {
		List<Person> personSortedByNameAndAge = personsList.stream()
					.sorted(comparing(byTheirAge))
					.sorted(comparing(byTheirName))
					.collect(Collectors.toList()); 
		Utilities.print("~~~~~~~~~ Using Functions for Compators");			
		personSortedByNameAndAge.forEach( x -> System.out.println(x.getName() +  "-----"  +  x.getAge()));
		Utilities.print("Z~~~~~~~~~~~~~~~~~~");
		
	}

	private void performOps() {
		List<Person> result = personsList.stream().sorted(Person::ageDifference).collect(Collectors.toList()); 
		result.forEach( x -> System.out.println(x.getName() +  "-----"  +  x.getAge()));
		
		List<Person> sortedByAgeAsc = personsList
									.stream()
									.sorted(personAgeAscendingComparator)
									.collect(Collectors.toList()); 
		
		List<Person> sortedByAgeDesc = personsList
				.stream()
				.sorted(personDescendingComparator)
				.collect(Collectors.toList()); 

		Utilities.print(" ASC Comparator");
		sortedByAgeAsc.forEach(x -> System.out.println( x.getName() + ": " +x.getAge()) )  ; 
		Utilities.print(" ~~~~~~~~~~~~~~~");
		Utilities.print(" DESC  Comparator");
		sortedByAgeDesc.forEach(x -> System.out.println( x.getName() + ": " +x.getAge()) )  ; 
		Utilities.print(" ~~~~~~~~~~~~~~~");
		
	}

}
