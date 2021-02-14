package com.stl.java8.examples;

import java.util.Optional;

import com.java8.dto.Car;

public class Person {

	private String name ;
	private int age ;
	private Optional<Car> car ;




	public Person(String name , int age ) {
		this.name = name ;
		this.age = age ;
	}

	// default
	public Person() {

	}


	public int ageDifference(Person person ) {
		return age -  person.age ;
	}

	int ageDifferenceStatic(Person person){
	  return 100 - person.age ;
  }

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return String.format("(%s - %d)" , name , age );
	}

	public Optional<Car> getCar() {
		return car;
	}

	public void setCar(Optional<Car> car) {
		this.car = car;
	}

}
