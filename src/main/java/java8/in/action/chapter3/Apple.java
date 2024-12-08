package java8.in.action.chapter3;


import java.util.function.IntPredicate;
import java.util.function.Predicate;


public class Apple {

	private int weight ;
	private String colour ;
	private String description ;
	private static final int HEAVY =  500;
	private static final int LIGHT =  100;
	private Predicate<String> myPredictate = s -> s.equals("kasi") ;
	private IntPredicate greaterThanPredicate =  n -> n > 100 ;

	public Apple(String colour, int weight){
		this.colour = colour;
		this.weight = weight;
	}

	public Apple(int weight){
		this.weight = weight;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public static boolean isHeavyApple(final Apple apple){
		return apple.getWeight() >= HEAVY ? true : false;

	}

	public static boolean isLightApple(Apple apple){
		return apple.getWeight() < LIGHT ? true : false;

	}

	public static boolean isMediumApple(Apple apple){
		return apple.getWeight() > LIGHT && apple.getWeight() < HEAVY? true : false;

	}

	public int differenceInWeight(final Apple other){
		return weight - other.weight ;

	}


	public String toString() {
        return "Apple{" +
               "Colour ='" + colour + '\'' +
               ", weight=" + weight +
               ", description=" + description +
               '}';
    }

}
