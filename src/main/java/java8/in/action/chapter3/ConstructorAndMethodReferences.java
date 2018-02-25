package java8.in.action.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorAndMethodReferences {

	private static final int HEAVY =  500;
	private static final int LIGHT =  100;

	
	public static void main(String[] args) {
		// run examples 
		// filterFruits();
	}
	
	public static void doWork(){
		List<Apple> apples  = orderApples(); 
		apples.forEach( x -> x.getColour());
		
		// Using Supplier to create a Apple instance 
		Supplier<Apple> c1 = () -> new Apple(100);
		
		List<Integer> weights = Arrays.asList(7,3,4,10,15); 
		
		List<Apple> applesWithWeight = populateAppleWithWeights(weights, Apple::new); 
		
		// using BiFunction to pass in 2 parameters as well as  constructor reference to create the instance of the Target -- Apple 
		
		BiFunction<String,Integer,Apple> c3  = Apple::new ; 
		
		// Parameterzie the Overloaded ctor.
		Apple redHeavyApple =  c3.apply("Red", 1250);
		
		
		
	
	}

	public static List<Apple> populateAppleWithWeights(List<Integer> weights, Function<Integer,Apple> f) {
		List<Apple> apples = new ArrayList<Apple>(); 
		
		for(Integer weight : weights){
			apples.add(f.apply(weight));
		}
		return apples ; 
	}
	

	private static void filterFruits() {
		List<Apple> apples  = orderApples(); 
	}
	
	private static List<Apple> orderApples(){
		List<Apple> apples = new ArrayList<>();
		Apple mediumApple = new Apple(200);
		mediumApple.setColour("RED");
		mediumApple.setDescription("Medium");
		
		Apple heavyApple = new Apple(1000); 
		heavyApple.setColour("GREEN");
		heavyApple.setDescription("Heavy");
		
		Apple lightApple = new Apple(50); 
		lightApple.setColour("PINK");
		lightApple.setDescription("LIGHT");
		
		apples.add(mediumApple);
		apples.add(heavyApple);
		apples.add(lightApple);
		
		return apples; 
	}
	
}
