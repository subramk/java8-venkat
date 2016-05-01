package java8.in.action.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;


public class SortUsingComparators {

	
	public static void main(String[] args) {
		doWork();
		
	}
	
	public static void doWork(){
		
	
			List<Apple> inventory = new ArrayList<>();
	        inventory.addAll(Arrays.asList(new Apple("green",80), new Apple("pink",155), new Apple("red",212)));
	        //inventory.sort(new AppleComparator());
	        //System.out.println(inventory);
	        
	        
	        // traditional way 
	        inventory.sort(new AppleComparator());
	       
	        // using comparing static method 
	        inventory.sort(comparing(Apple::getWeight));
	        
	                   		
	       // Reverse the comparing logic Using .reversed
	        		inventory.sort(	comparing(Apple::getWeight)
	        						.reversed()
	        			   		  );
	       
	       // Chaining Comparators using thenComparing
	        		inventory.sort(	comparing(Apple::getWeight)
	        						.thenComparing(Apple::getDescription)
    			   		  	 	  );
	        
	        
	        // Print the List after Sorting 
	        inventory.forEach(SortUsingComparators::print); 
	       
	        
	        
		
	
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
