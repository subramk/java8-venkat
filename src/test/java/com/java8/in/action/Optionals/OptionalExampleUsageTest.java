package com.java8.in.action.Optionals;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static  org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;


import com.java8.dto.Car;
import com.java8.dto.Insurance;
import com.stl.java8.examples.Person;

public class OptionalExampleUsageTest {

	private Person person ; 
	Car car ; 
	Insurance insurance ; 
	private Optional<Person> nullPerson ; 
	private Optional<Car> optCar ; 
	private Optional<Insurance> optInsurance;
	
	@BeforeEach
	public void initializeTest() {
		
	}
	
	@Test
	 void testAssertions() {
	
		 person = new Person();
		 person.setAge(23);
		 person.setName("Kasi Subream");
		 
		 car = new Car("Skoda");
		 car.setAgeInMonths(44);
		 car.setModel("Octavia");
		 
		 insurance = new Insurance();
		 insurance.setInsurer("Aviva PLC");
		 insurance.setPremium(321L);
		 
		 Optional<Person> optPerson = Optional.of(person);
		 Optional<Car> optCar = Optional.of(car); 
		 Optional<Insurance> optInsurance =  Optional.of(insurance); 
		 
		 // set Optional<Car> on person
		 person.setCar(optCar);
		 
		 // set Optional<Insurance> on Car 
		 car.setInsurance(optInsurance);
		 
		 if(optCar.isPresent()) {
			 System.out.println("Car is ready to be used ");
		 }else {
			 Assert.fail("should not reach here");
			 System.out.println("Car is not Ready  ");
		 }
		
		 optPerson = Optional.of(person); 
		 // does not compile 
		 // as doing a map on an optional returns Optional< Optional<T> >
		 // Optional<String> name =  optPerson.map(Person::getCar)
				 			//				.map(Car::getInsurance)
				 			//				.map(Insurance::getName);
		 System.out.println("Insurance Company Name is " + getCarInsuranceName(optPerson) ) ; 
	
		 Person voidPerson = null ; 
		 Optional<Person> emptyPerson = Optional.ofNullable(voidPerson); 
		 
		 System.out.println("Insurance Company Name for Empty Person is " + getCarInsuranceName(emptyPerson) ) ;
		 
		 
	 }
	
	@Test 
	 void test_AbsenceOfValue_in_Optional_with_ofNullable() {
		
		 Car car2 = null; 
		 Optional<Car> emptyCar = Optional.ofNullable(car2) ; 
		 // emptyCar is not null , but is an Optional<Car> with value absent. 
		 Assert.assertNotNull(emptyCar); 
		 
		 if(!emptyCar.isPresent()) {
			 System.out.println(" emptyCar:::: Car optional is empty , ie absent ");
		 }else {
			 Assert.fail("should not reach here....");
		 }
	
	}
	
	@Test
	 void test_ifPresent_method() {
		Car skoda = new Car("SkodaOctavia");
		Optional<Car> emptyCar = Optional.ofNullable(skoda) ;
		
		 // Same logic of above can be done neatly by using the IfPresent method to to check condition neatly . 
		 emptyCar.ifPresent( x -> {
			 Assert.assertTrue(x.getName().equals("SkodaOctavia"));
			
		 });
	}
	
	@Test
	public void testGetCarInsuranceName_when_person_is_Null() {
		Person p = null; 
		Optional<Person> nullPerson = Optional.ofNullable(p);
		
		Optional<Person> optPersonNull = Optional.empty();
		Assert.assertEquals(optPersonNull, nullPerson);
		Assert.assertEquals("UnknownInsurance",getCarInsuranceName(nullPerson) ) ; 
		
	}
	
	@Test
	 void test_That_Calling_NullablePerson_will_Not_Throw_Exception() {
		
		try {
			Person p = null; 
			Optional<Person> nullPerson = Optional.ofNullable(p);
			
			Person personKasi = new Person("kasi", 42); 
			Optional<Person> optKasi = Optional.ofNullable(personKasi);
			Assert.assertThat(optKasi.get().getName(), is("kasi"));
			
		}catch(Exception e) {
			Assert.fail("should not reach here"); 
		}
		
		
	}
	 
	 
	// This method replaces the chained calls of 
		// if(person !=null) {
			// if(person.getCar() !=null ) {
				// if(car.getInsurance !=null) {
					 //  String insurer = car.getInsurance() ; 
//			} 
		//}	
//		}
	
	 public String getCarInsuranceName(Optional<Person> person) {
		 
		 return person.flatMap(Person::getCar) // getCar returns an Optional<Car> , that s why we use a flatMap
				 	  .flatMap(Car::getInsurance) // getInsuracne returns an Optional<Insurance> , that s why we use a flatMap.
				      .map(insurance -> insurance.getInsurer()) // we use map here as we are returning a String from Insurance.getInsurer() ; 
				      .orElse("UnknownInsurance"); // defaults if any of the chain of calls above is broken. 
	 }
	 
	 
	 
//	 public Optional<String> getCarInsuranceName2(Optional<Person> person) {
//		 final String EMPTY_STRING = "";
//		 return person.flatMap(Person::getCar) // getCar returns an Optional<Car> , that s why we use a flatMap
//				 	  .flatMap(Car::getInsurance) // getInsuracne returns an Optional<Insurance> , that s why we use a flatMap.
//				      .map(insurance -> insurance.getInsurer()) // we use map here as we are returning a String from Insurance.getInsurer() ; 
//				      .orElse(Optional.of(EMPTY_STRING)) ; // defaults if any of the chain of calls above is broken. 
//	 }
	  
	
	 public Optional<Insurance> nullSafeFindCheapestCarInsurance(Optional<Person> optPerson , Optional<Car> optCar){
		 
		 // checking if the optional is present or empty and then using the .get() method to pass to the insurancePolicyWebService. 
		 // Safe way for checking is to use a isPresent() followed by a .get() on the optional.
		 if(optPerson.isPresent() && optCar.isPresent()) {
			 return Optional.of(insurancePolicyWebService(optPerson.get(), optCar.get())) ; 
		 }else
		 {
			 return Optional.empty();
		 }
	 }
	 
	 // COMBINING TWO OPTIONALS IN ONE GO .  Elegant Approach 
	 // Alternative method using flatMap 
	 
	 public Optional<Insurance> nullSafeFindCheaperInsurance_withFlatMap(Optional<Person> optPerson , Optional<Car> optCar){
			
		 return optPerson.flatMap( 
				 					p -> optCar.map( c -> insurancePolicyWebService(p,c))
				 		         );
		 
	 }

	 public Insurance insurancePolicyWebService(Person person , Car car ) {
		 
		  // some business calls 
		 // return a Insurance policy 
		 
		 Insurance cheapestInsurance  = new Insurance(); 
		 cheapestInsurance.setInsurer("LondonVictoria");
		 cheapestInsurance.setPremium(233L);
		 
		 return cheapestInsurance;
	 }
	 

}
