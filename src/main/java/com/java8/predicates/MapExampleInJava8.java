package com.java8.predicates;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MapExampleInJava8 {

	public static void main(String[] args) {
		MapExampleInJava8 obj = new  MapExampleInJava8();
		obj.doWork(); 
		
	}

	private void doWork() {
	Map<Integer,String> ranksInClass = new HashMap<>();
	ranksInClass.put(1, "Rukmitha"); 
	ranksInClass.put(2, "NikkiNayak"); 
	ranksInClass.put(3, "SanviJawaji"); 
	ranksInClass.put(4, "SarayaGanna"); 
	
	ranksInClass.entrySet()
				.stream()
				.sorted()
				.forEach((x -> System.out.println(x.getKey() + ":" + x.getValue()))); 
	
	Optional<Integer> findFirstAmongst  = ranksInClass.entrySet()
	.stream()
	.map(x -> x.getKey())
	.findFirst();
	 
	System.out.println(" the first person is " + findFirstAmongst.get());
	
	
	
	
	}
}
