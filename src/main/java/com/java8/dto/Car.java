package com.java8.dto;

import java.util.Optional;

public class Car {

	private String name ; 
	private String model ; 
	private int ageInMonths ; 
	private Optional<Insurance> insurance ; 
	
	
	public Car(String name) {
		this.name = name; 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getAgeInMonths() {
		return ageInMonths;
	}

	public void setAgeInMonths(int ageInMonths) {
		this.ageInMonths = ageInMonths;
	}

	public Optional<Insurance> getInsurance() {
		return insurance;
	}

	public void setInsurance(Optional<Insurance> insurance) {
		this.insurance = insurance;
	}
	
}
