package java8.in.action.chapter3;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class SortUsingComparators {

	
	private static  Comparator<Apple> compareWeightDescending  = (Apple a1,Apple a2) -> a1.differenceInWeight(a2)  ;
	private static  Comparator<Apple> compareWeightAscending = compareWeightDescending.reversed() ; 
	
	
	public static void main(String[] args) {
		sortingOptions();
		
		fluentComparisons(); 
		
	}
	
	

	public static void sortingOptions(){
			List<Apple> listOfApples = new ArrayList<>();
	        listOfApples.addAll(Arrays.asList(new Apple("green",80), new Apple("pink",155), new Apple("red",212)));
	        //inventory.sort(new AppleComparator());
	        //System.out.println(inventory);
	        
	        
	        // 1) traditional way 
	        listOfApples.sort(new AppleComparator());
	       
	        // 2) using comparing static method 
	        listOfApples.sort(comparing(Apple::getWeight));
	        
	                   		
	       // 3) Reverse the comparing logic Using .reversed
	        		listOfApples.sort(	comparing(Apple::getWeight)
	        						.reversed()
	        			   		  );
	       // 4) Using stream , we can do this .  
	        		listOfApples	.stream()
	        					.sorted(compareWeightDescending)
	        					.collect(toList());
	        
	        //	5) Pasing a Function to the comparing() method that returns a Comparator. 
	        	Function<Apple,Integer> compareByName = apple -> apple.getWeight();
	        	listOfApples.stream().sorted(comparing(compareByName));
	        		
	        		
	     	
	        		
	        //		
	        
	        // Print the List after Sorting 
	        listOfApples.forEach(SortUsingComparators::print); 
	  
	}
	
	private static void fluentComparisons() {
		List<Apple> listOfApples = new ArrayList<>();
        listOfApples.addAll(Arrays.asList(new Apple("green",80), new Apple("pink",155), new Apple("red",212)));
        
        Function<Apple,Integer> byWeight = apple -> apple.getWeight() ; 
        Function<Apple,String>  byDescription = apple -> apple.getDescription() ;
        Function<Apple,String>  byColour  = apple -> apple.getColour() ;
        
        
        // 1 
        List<Apple> applesSortedByWeightColour = new ArrayList<>();
        applesSortedByWeightColour = listOfApples
        			.stream()
        			.sorted(
        					comparing(byWeight)
        					.thenComparing(byColour)).collect(toList()); 
        
        
        //2 Chaining Comparators using thenComparing 
        
		listOfApples.sort(	comparing(Apple::getWeight)
							.thenComparing(Apple::getDescription)
	   		  	 	  	 );

     
		
	}
	
	public static void print(Apple apple){
		System.out.println( apple );
	}
	
	
	  static class AppleComparator implements Comparator<Apple> {
		  
	        public int compare(Apple a1, Apple a2){
				if(a1.getWeight() > a2.getWeight() ){
					return 1;
				}else if(a1.getWeight() < a2.getWeight()){
					return -1;
				}else if(a1.getWeight() == a2.getWeight()){
					return 0 ; 
				}
				// NPE Etc 
				return 0;
	        }
	
	
}

}
