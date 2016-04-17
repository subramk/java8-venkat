package java8.mooc.assignment.lesson.two;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class BiConsumerExample {

		
	public static void doWork(){
		
		Map<Integer,String> map = new HashMap<>();
	       map.put(1, "A");
	       map.put(2, "B");
	       map.put(3, "C");
	
	       BiConsumer<Integer,String> biConsumer = (k,v) -> System.out.println("Key:" +k  + "   Value  " + v);
		
	       map.forEach(biConsumer);
	     
	       BiFunction<Integer, Integer, String> biFunction = (num1, num2) -> "Result:" +(num1 + num2);
	       System.out.println(biFunction.apply(20,25));
	       
	       
		
	}
	
	public static void main(String[] args) {
		  doWork(); 
	}
	 
	 
	 
}
