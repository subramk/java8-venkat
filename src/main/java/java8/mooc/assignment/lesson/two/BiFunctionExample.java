package java8.mooc.assignment.lesson.two;

import java.util.function.BiFunction;

public class BiFunctionExample {

	
public static void doWork(){

	BiFunction<Integer, Integer, String> biFunction = (num1, num2) -> "Result:" +(num1 + num2);
	System.out.println(	biFunction.apply(20,25)	);
		
}

public static void main(String[] args) {
		  doWork(); 
}


}
