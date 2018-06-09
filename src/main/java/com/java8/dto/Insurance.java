package com.java8.dto;

public class Insurance {
	
	private String name ; 
	private Long premium ; 
	
	
	public Insurance(String insurer, Long premium) {
		super();
		this.name = insurer;
		this.premium = premium;
	}

	public Insurance() {
		
	}

	public String getInsurer() {
		return name;
	}


	public void setInsurer(String insurer) {
		this.name = insurer;
	}


	public Long getPremium() {
		return premium;
	}


	public void setPremium(Long premium) {
		this.premium = premium;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
