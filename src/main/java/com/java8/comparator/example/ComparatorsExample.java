package com.java8.comparator.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import java8.in.action.Apple;

public class ComparatorsExample {
	public static void main(String[] args) {
		ComparatorsExample ce = new ComparatorsExample(); 
		ce.performAction();
	}


public  List<Apple> performAction(){
	
	// we have to autobox the getWeight() method otherwise the compareTo cannot be invoked. 
	Comparator<Apple> sortAppleByWeightAsc = (a1,a2)  -> new Integer(a1.getWeight()).compareTo(new Integer(a2.getWeight()));
	List<Apple> applesList = populateApples() ; 
	applesList.sort(sortAppleByWeightAsc);
	applesList.forEach(  apple -> System.out.println( " Apple " + apple.getWeight() + " name " + apple.getDescription() ));
	
	System.out.println(" Reversing the Sortingn now  ");
	applesList.sort(sortAppleByWeightAsc.reversed());
	applesList.forEach(  apple -> System.out.println( " Apple " + apple.getWeight() + " name "  + apple.getDescription() ));
	
	
	
	return null; 
	
	
	
}



private static List<Apple> populateApples() {
	List<Apple> applesList = new ArrayList<Apple>();
	applesList.add( new Apple(150 , "Green" , "GreenApple150")); 
	applesList.add( new Apple(100 , "Red" , "RedApple100")); 
	applesList.add( new Apple(75 , "Pink" , "PinkApple75")); 
	applesList.add( new Apple(75 , "Blue" , "BlueApple75")); 
	
	return applesList ; 
}

}
