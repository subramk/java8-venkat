package com.java8.dto;

import java.util.Date;
import java.util.List;


/** *
 * 
 * Movie DTO , has a List<Actor> . 
 * 
 * 
 * 
 */
public class Movie {
	
	private String name ; 
	private Date releaseDate; 
	private List<Actor> actors; 
	private int crewSize ; 
	private List<String> languageCodes ;
	
	public Movie(String name, int crewSize) {
		this.name = name ; 
		this.crewSize = crewSize; 
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public List<Actor> getActors() {
		return actors;
	}
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	public int getCrewSize() {
		return crewSize;
	}
	public void setCrewSize(int crewSize) {
		this.crewSize = crewSize;
	}
	public List<String> getLanguageCodes() {
		return languageCodes;
	}
	public void setLanguageCodes(List<String> languageCodes) {
		this.languageCodes = languageCodes;
	}


	@Override
	public String toString() {
		return "Movie [name=" + name + " and the crewSize is =" + crewSize + "]";
	} 
	

}
