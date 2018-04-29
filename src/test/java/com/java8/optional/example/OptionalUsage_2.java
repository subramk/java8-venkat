package com.java8.optional.example;

import java.util.NoSuchElementException;
import java.util.Optional;


import org.junit.Assert;
import org.junit.Test;

import java8.in.action.chapter10.Car;
import java8.in.action.chapter10.Insurance;
import java8.in.action.chapter10.Person;

public class OptionalUsage_2 {
	
	@Test(expected = NoSuchElementException.class)
	public void using_Optional_With_Creation() {
		
		Optional<Car> optCar = Optional.empty();
		
		Car carObject  = optCar.get();
		Assert.assertNull(carObject);
	}
	
	@Test
	public void using_Optional_With_FlatMap() {
		
		Insurance aviva = new Insurance();
		aviva.setName("Aviva");
		
		Optional<Insurance> optInsurance = Optional.ofNullable(aviva); 
		Assert.assertEquals("Aviva", optInsurance.get().getName());
	}
	

	@Test
	public void test_A_Null_Optional_Reference() {
		
		Insurance invalid = new Insurance();
		invalid.setName(null);
		
		Optional<Insurance> optInsurance = Optional.ofNullable(invalid); 
		Assert.assertNull(optInsurance.get().getName());
		
	}
	
	
	@Test
	public void test_when_using_Optional_on_a_chain_Of_Objects() {
		Person person = new Person();
		Car car = new Car();
		
		Optional<Car>  optCar = Optional.ofNullable(car);
		person.setCar(optCar);
		
		
		Optional<Person> optPerson = Optional.of(person);
		
		Optional<String> name =
							  optPerson.flatMap(Person::getCar)
		             		 .flatMap(Car::getInsurance)
		                     .map(Insurance::getName);

		
		// Detailed step by Step View of the above Pipeline
		Optional<Car> car1  = optPerson.flatMap(Person::getCar); 
		Optional<Insurance> insurance = car1.flatMap(x -> x.getInsurance()) ; 
				Optional<String>  insuranceName = insurance.map( x -> x.getName()); 
		
		// when using orElse , the return Type is a Definitive type , like a String in this case. 
		String defaultName =
						  optPerson.flatMap(Person::getCar)
	             		 .flatMap(Car::getInsurance)
	                     .map(Insurance::getName)
	                     .orElse("default");
		
		Assert.assertEquals("default",defaultName);
			
	}
	
	public Car defaultCar() {
		return new Car();
	}
	
	public Optional<Insurance> nullSafeFindCheapestInsurance(final Optional<Person> person, final Optional<Car> car) {
		
		if (person.isPresent() && car.isPresent()) {
			return Optional.of(findCheapestInsurance(person.get(), car.get()));
		} else {
			return Optional.empty();
		} 

	}
	
	public Optional<Insurance> nullSafeFindCheapestInsurance_using_FlatMap(Optional<Person> person, Optional<Car> car) {
		
		return person.flatMap ( p -> car.map(c -> findCheapestInsurance(p, c))); 
		
	}

	// Some external WebService ( expensive call ) 
	private Insurance findCheapestInsurance(Person person, Car car) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
