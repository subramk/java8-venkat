package com.stl.java8.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import util.Utilities;

public class UsingCollectors {

	private static List<Person> personsList = new ArrayList<Person>(); 
	
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
		UsingCollectors uc = new UsingCollectors();
		Utilities.print("Start");
		uc.usingCollectors();
	
		Utilities.print("End");
	}
	
	
	
	private void usingCollectors() {

		// using a Collector.collect(Supplier, Accumulator, Combiner ) as parameters . 
		List<Person> result = personsList.stream()
			.filter(p -> p.getAge() > 20)
			.collect(ArrayList::new , ArrayList::add , ArrayList::addAll); 
			 
		result.forEach(person -> System.out.println(person));
		
		// GroupingBy Age 
		Utilities.print("Grouping by Age");
		Map<Integer,List<Person>>   groupPeopleOlderThan_20 = personsList.stream()
				.filter(p -> p.getAge() > 20)
				.collect(Collectors.groupingBy(p -> p.getAge()));
		
		groupPeopleOlderThan_20.forEach((k,v) -> {
			System.out.println("Age: "+ k + " Name:" + v );
		});		 
		

		
	}
}
