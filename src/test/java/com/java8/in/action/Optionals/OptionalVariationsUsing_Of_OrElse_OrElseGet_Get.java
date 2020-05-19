package com.java8.in.action.Optionals;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Test;



/**
 * 
 * 
 * Optional.of()
 * Optional.orElse()
 * Optional.orElseGet()
 * Optional.get()
 * 
 * creating an optCar which can hold a null value.
 * Optional<Car> optCar = Optional.ofNullable(car);
 * 
 * Optional.isNullable()
 * 
 * Optional<Car> optCar = Optional.empty();
 * Optional<Car> optCar = Optional.of(car);
 * 
 * 
 * 
 * 
 * @author Admin
 *
 */
public class OptionalVariationsUsing_Of_OrElse_OrElseGet_Get {
	
	public String getMyDefault() {
	    System.out.println("Inside the getMyDefault() method");
	    return "Default Value";
	}
	
	
	@Test
	public void when_the_checked_Object_isNull_then_OrElseGet_And_OrElse_behave_same() {
	    String text = null ;
	 
	    System.out.println("Using orElseGet:");
	    String defaultText = 
	      Optional.ofNullable(text).orElseGet(this::getMyDefault);
	    assertEquals("Default Value", defaultText);
	 
	    System.out.println("Using orElse:");
	    defaultText = Optional.ofNullable(text).orElse(getMyDefault());
	    assertEquals("Default Value", defaultText);
	}
	
	@Test
	public void using_Optional_orElseGet_More_efficient_Than_using_Optional_orElse() {
	    String text = "Text present";
	 
	    String defaultText =null;
	   
	    System.out.println("Using orElse: Less Efficient ");
	    defaultText=Optional.ofNullable(text).orElse(getMyDefault());
	    assertEquals("Text present", defaultText);
	    
	    //
	    System.out.println("Using orElseGet: More Efficient since getMyDefault() not called");
	    defaultText=Optional.ofNullable(text).orElseGet(this::getMyDefault);
	    assertEquals("Text present", defaultText);
	 
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void throwingException_in_the_Else_Block() {
	    String nullName = null;
	    String name = Optional.ofNullable(nullName).orElseThrow(
	      IllegalArgumentException::new);
	}
	
	
	@Test
	public void givenOptional_whenGetsValue_thenCorrect() {
	    Optional<String> opt = Optional.of("baeldung");
	    String name = opt.get();
	 
	    assertEquals("baeldung", name);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void given_Optional_WithNull_when_Get_is_Called_Exception_thrown() {
		String text = null ; 
		
	    Optional<String> opt = Optional.ofNullable(text);
	    String name = opt.get();
	    
	      
	}

	
	@Test
	public void using_Optional_with_Filter() {
	    Integer year = 2016;
	    Optional<Integer> yearOptional = Optional.of(year);
	    
	    boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
	    assertTrue(is2016);
	    boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
	    assertFalse(is2017);
	}
	
	
	

}
