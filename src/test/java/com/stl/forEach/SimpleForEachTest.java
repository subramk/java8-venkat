package com.stl.forEach;

import org.junit.Before;
import org.junit.Test;

import com.stl.java8.examples.SimpleForEach;

public class SimpleForEachTest {
	
	
	private SimpleForEach simpleForEach; 
	
	@Before
	public void before(){
		simpleForEach = new SimpleForEach();
	}
	
	@Test
	public void testItearationOfCollectionsElements(){
		simpleForEach.useExternalIteartorToLoopThroughCollection();
	}
	

}
