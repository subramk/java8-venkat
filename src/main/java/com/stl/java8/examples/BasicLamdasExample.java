package com.stl.java8.examples;

import java.util.Arrays;
import java.util.List;

public class BasicLamdasExample {

	static List<String> strList = Arrays.asList("kasi","subram", "uthra");  
	
	public static void main(String[] args) {
		usingForEach_Without_Lambda();
		loop_with_Lamdas(); 
		usingForEach_with_Consumer();

	}

	private static void usingForEach_Without_Lambda() {
		System.out.println("using ");
		strList .stream().
				forEach( element -> System.out.println("name is "+ element));
		
		List<String> stocks = Arrays.asList("GOOG","AMAZ","ORCL"); 
		
	}


	private void doSomeChecks(){

	final List<String> lists = Arrays.asList( "kasi","af"); 
	lists.forEach( x -> System.out.println(x));

	}
	
	private static void loop_with_Lamdas(){
		strList
			.stream()
			.forEach(element -> System.out.println("name is "+ element)) ; 
	}

	private static void usingForEach_with_Consumer(){
		strList
			.stream()
			.forEach(e -> printValues(e)) ; 
	}
		
	private static <T> void printValues(T t ){
		System.out.println("using method 2 print  ");
		System.out.println("using printValues...." + t);
		strList
		.stream()
		// method Reference  :: used here....
		.forEach(BasicLamdasExample::printValueMethodReference) ;  // note No lambda ( No syntax of type e -> sysout(e) .... required here ) . 
		
	}
	
	
	//Method 
	private static <T> void printValueMethodReference(T t ){
		System.out.println("using Method Reference to print  ");
		System.out.println(t + "  ");
		
	}
	
}