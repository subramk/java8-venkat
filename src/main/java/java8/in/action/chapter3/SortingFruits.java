package java8.in.action.chapter3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static java.util.List.of;

import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.Integer.valueOf;

public class SortingFruits {

	private static final int HEAVY =  500;
	private static final int LIGHT =  100;


	public static void main(String[] args) {
		// run examples
		// doWork();
		filterFruits();
	}


	List<Apple> inventory = of(new Apple("Green",200),
							   new Apple("Blue", 300),
							   new Apple("Red", 400));


	class AppleComparator implements Comparator<Apple>{
		@Override
		public int compare(Apple a1, Apple a2) {
			return  valueOf(a1.getWeight()).compareTo(valueOf(a2.getWeight()))  ;
		}
	}


	private static void filterFruits() {
		List<Apple> apples  = orderApples();
		final Predicate<Apple> heavyAppleFilter = x -> x.getWeight() > HEAVY ;

		// Use Filter and then Collect
		List<Apple> heavyApplesList	= apples.stream()
								  			.filter(heavyAppleFilter)
								  			.collect(Collectors.toList());

		System.out.println("Using Filter ...Number of heavy apples " + heavyApplesList.size());


		// Using Method References and the Collect
		List<Apple> heavyApplesList2	 = apples
												.stream()
												.filter(Apple::isHeavyApple)
												.collect(Collectors.toList());

		System.out.println("Using Method References ...Number of heavy apples " + heavyApplesList2.size() );


	}


	public static void doWork(){
		List<Apple> apples  = orderApples();
		apples.forEach( x -> x.getColour());

		System.out.println("...using method references .....");
		apples.forEach(Apple::getDescription);

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
