package com.java8.in.action.Optionals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


/**
 * 
 * Run this class as a Junit Test 
 * 
 * @author kasi
 *
 */

public class OptionalExample {

	public static void runExercises(){
		// If you want 2 run these as a java application remove the @Test annotations on all methods and uncomment the lines below
		
		// usingOptional();
		// usingDistintOnStreams();
		// usingFlatMaps();
		
	}
	
	@Test
	  void usingDistintOnStreams(){
		List<String> list = Arrays.asList(
		        "alpha", "bravo", "charlie", "delta", "echo", "foxtrot","Gorilla","Horse","Inkbottle", "alpha");
		
		Stream<String>  distinctStream = list.stream().distinct();
		// assert.assertTrue(distinctStream.coun);
	}
	
	@Test
	 void usingOptional(){
		List<String> list = Arrays.asList(
		        "alpha", "bravo", "charlie", "delta", "echo", "foxtrot","Gorilla","Horse","Inkbottle");
		
		List<String> list2 = new ArrayList<>();

		Function<String,String> mapper = n -> n.toUpperCase();
		
		Optional<String> topName  = list.stream().map(mapper).findFirst();
		
		System.out.println("first elemet in the list is " +  topName);
		
		if(!topName.isPresent()){
			System.out.println("list is empty");
			//Assert.assertTrue(topName.isPresent() == Boolean.FALSE);
		}
	}

}
	


