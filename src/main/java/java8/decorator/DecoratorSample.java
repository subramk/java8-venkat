package java8.decorator;

import java.util.function.Function;

public class DecoratorSample {


    // higher order function , ie a function that takes another function as a parameter
    public static void compute(int value , Function<Integer,Integer> operator){
        System.out.println(" Value of the operation == "+operator.apply(value)) ;
    }

    public static void main(String[] args) {
        Function<Integer,Integer> increment = e -> e +1  ;
        Function<Integer,Integer> doubleIt  = e -> e * 2  ;

        compute(5, increment ) ;
        compute(10, doubleIt ) ;

        // chaining Function
        compute(5,increment.andThen(doubleIt).andThen(increment));

    }


}
