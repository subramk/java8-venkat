package com.java8.strategy.pattern.in.lamdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class StrategyPatternUsingLambdasTest {

	
private StrategyPatternUsingLambdas simplStrategyPatternUsingLambdasTest; 
	
	private List<Integer> numbers = Arrays.asList(1,2,3,4,5); 
	private static Function<Integer,Integer> increment = e -> e +1 ; 
	private static Function<Integer,Integer> doubleIt = e -> e * 2 ; 
	

	@Before
	public void before(){
		simplStrategyPatternUsingLambdasTest = new StrategyPatternUsingLambdas();
	}
	
	@Test
	public void test_1(){
		int total = simplStrategyPatternUsingLambdasTest.totalAllValuesUsing_normalWay(numbers);
		Assert.assertEquals(total, 15);
	}
	
	//Java 7 
	
	@Test
	public void test_EVEN_Numbers_in_Collection(){
		int total = simplStrategyPatternUsingLambdasTest.totalOnlyEvenNumbersInCollection(numbers);
		Assert.assertEquals(6, total);
		
		
	}
	
	//Java 7 
	@Test
	public void test_ODD_Numbers_in_Collection(){
		int total = simplStrategyPatternUsingLambdasTest.totalOddNumbersInCollection(numbers);
		Assert.assertEquals(9, total);
		
		
	}
	
	//Java 8 versions 
	
	@Test
	public void test_Increment_Operation(){
		Integer value = simplStrategyPatternUsingLambdasTest.performAction(5, increment); 
		Assert.assertSame(6, Integer.valueOf(value));
		
	}
	
	@Test
	public void test_DoubleIt_Operation(){
		Integer value = simplStrategyPatternUsingLambdasTest.performAction(5, doubleIt); 
		Assert.assertSame(10, Integer.valueOf(value));
		
	}
	
	@Test
	// use the andThen() to combine both increment and doubleIt Calls.
	// the output of the call to increment which is a Function is passed as 
	// input to the doubleIt . 
	// This is an example of a higher order function . Passing one function as a parameter 
	// to another
	public void test_IncrementAndDouble_Operation(){
		int result = increment.andThen(doubleIt).apply(5) ; 
		Assert.assertSame(12, Integer.valueOf(result));
		
	}
	
}
