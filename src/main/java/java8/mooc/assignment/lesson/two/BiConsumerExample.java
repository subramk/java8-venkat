package java8.mooc.assignment.lesson.two;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class BiConsumerExample {

		
	public static void doWork(){
		
		Map<Integer,String> map = new HashMap<>();
	       map.put(1, "A");
	       map.put(2, "B");
	       map.put(3, "C");
	
	       BiConsumer<Integer,String> biConsumer = (k,v) -> System.out.println("Key:" +k  + "   Value  " + v);
		
	       map.forEach(biConsumer);
	}
	
	public static void main(String[] args) {
		  doWork(); 
	}
	 
}
