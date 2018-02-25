package java8.mooc.assignment.lesson.two;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class BiFunctionExample {

	
	/*
	 * A BiFunction , BiFunction<Integer, Integer, String> is A Function that takes 2 arguments of say type T and U and returns 
	 * and returns a Type V 
	 * 
	 * 
	 */
	
public static void doWork(){

	BiFunction<Integer, Integer, String> biFunction = (num1, num2) -> "Result:" +(num1 + num2);
	
	System.out.println(	biFunction.apply(20,25)	);
	
	Supplier<Integer> noOfHoursSupplier = () -> (Integer.valueOf(24)) ;  
	
	System.out.println(" Number of Hours in a day is  " + noOfHoursSupplier.get() ) ;  
	
		
	
    BiFunction<Integer, Integer, Integer> sumTwoNumbers= (num1, num2) -> num1 + num2; 
    BiFunction<Integer, Integer, Integer> sumNumbersAndThenDoubleIt= (num1, num2) -> (num1 + num2)*2 ; 
    BiFunction<Integer,Integer,Integer>  sumNumbersAndTripleIt  = ( x , y) -> ( (x+y) *3) ; 
    
    System.out.println(" Sum of the numbers and then Tripling it is " + sumNumbersAndTripleIt.apply(7, 2)) ; 
    
 
    Function<Integer,Integer> reduceByTen = x -> x - 10;
    
    System.out.println("Adding 2 Numbers ...5 and 100 == " +  sumTwoNumbers.apply(100, 5) );
    
    System.out.println("Adding 2 Numbers And Then Double it  ...5 and 95 == " +  sumNumbersAndThenDoubleIt.apply(5, 95) );
    
    
}

public static void main(String[] args) {
		  doWork(); 
}


}
