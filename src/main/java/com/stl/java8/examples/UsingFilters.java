package com.stl.java8.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.java8.predicates.UsingPredicates;

public class UsingFilters {
	
	final static List<String> friends =  Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
	final static List<String> comrades = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");
	
	
	public static void main(String z[]){
		UsingFilters uf = new UsingFilters();
		uf.countNumberOfFriends(friends);
		
	}


	private void countNumberOfFriends(List<String> friends) {
	
		long size = 		friends.stream()
							// Filter names starting with 'N'
					       .filter(e -> e.startsWith("N"))
					       // store in a List
					       .collect(Collectors.toList())
					       // Find out Size.
					       .size();
		       
		
	}
	
	


}
