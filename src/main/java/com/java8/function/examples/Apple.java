package com.java8.function.examples;

public class Apple {

	private int weight ; 
	private String colour ; 
	private String description ;

	public Apple(int weight, String colour, String desc) {
		this.weight = weight; 
		this.colour = colour ; 
		this.description = desc ; 
	}

	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	} 

}
