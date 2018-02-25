package com.stl.forEach;

import java.util.function.Function;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.stl.java8.examples.SimpleForEach;

public class SimpleForEachTest {
	
	
	private SimpleForEach simpleForEach;
	
	private Function<Integer,Integer> add = x -> x + 1 ; 
	private Function<Integer,Integer> doubleTheNumber  =  x -> x*2 ; 
	private Function<Integer,Integer> halveTheNumber = (Integer x ) ->  { return x/2;} ; 
	
	private Function<Integer, Function<Integer,Integer>> makeAdder = x -> y -> x +y ; 
	
	
	// @Before
	public void before(){
		simpleForEach = new SimpleForEach();
	}
	
	 //@Test
	public void testItearationOfCollectionsElements(){
		simpleForEach.useExternalIteartorToLoopThroughCollection();
	}
	
	@Test
	public void testAddOperations() {
		Assert.assertTrue(add.apply(2).equals(3));
		
		Assert.assertTrue(doubleTheNumber.apply(5).equals(10));
		Assert.assertTrue(halveTheNumber.apply(100).equals(50));
		
		Function<Integer,Integer> add1 = makeAdder.apply(1);
		Assert.assertTrue(add1.apply(100).equals(101)); 
		
		Assert.assertTrue(makeAdder.apply(1).apply(100).equals(101)); 
		
	}
	
	
}
