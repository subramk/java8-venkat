package com.stl.java8.examples;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class FlatMapExample {
	
	
	public static void main(String args[]) {
		FlatMapExample fme = new FlatMapExample();
		fme.flatMapScenario(); 
		
	}

	private void flatMapScenario() {
	 	
	 	District district_1 = new District(1L, "Coimbatore", 12341234 , "CBJ");
	 	District district_2 = new District(2L, "Nellai", 151234 , "TNJ");
	 	District district_3 = new District(3L, "Madurai", 878744 , "MDJ");
	 	District district_4 = new District(3L, "Sivagangai", 878744 , "SVJ");
	 	
	 	
	 	Set<District> tnDistrict = new HashSet<>();
	 	tnDistrict.add(district_1);  tnDistrict.add(district_2); tnDistrict.add(district_3); tnDistrict.add(district_4); 
	 	
	 	State TN = new State("TamilNadu", 22343, "TN");
	 	TN.setDistricts(tnDistrict);
	 	
	 	List<State> statesList = new ArrayList<State>(); 
	 	statesList.add(TN) ; 
	 	
	 	List<String> districtsInTamilNadu  = statesList.stream()
	 			  .filter( st -> Objects.nonNull(st.getCode()))
	 			  .flatMap(st -> st.getDistricts().stream()) // returns a Stream<District>
	 			  .map(dist -> dist.getName()) // Maps  from Stream<District> to String ( ie districtName )  
	 			  .map(x -> x.toUpperCase())
	 			  .distinct()
	 			  .collect(toList()); 
	 	
	 	districtsInTamilNadu.forEach(x -> System.out.println( x ));	
	}
	
	
	public class State {
		private String name; 
		private long population ; 
		private String code ;
		private Set<District> districts = new HashSet<>(); 
		
		public State(String name , long population , String code) {
			this.name = name ; this.population = population ; this.code = code ; 
		}
		public State() {
			
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public long getPopulation() {
			return population;
		}
		public void setPopulation(long population) {
			this.population = population;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public Set<District> getDistricts() {
			return districts;
		}
		public void setDistricts(Set<District> districts) {
			this.districts = districts;
		} 
		
		
	}
	
	public class District {
		private Long id;
		private String name;
		private long population ; 
		private String code;
		
		public District(Long id , String name, long  population , String code) {
			this.id  =id ; this.name = name ; this.population = population ; this.code = code ; 
		}
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public long getPopulation() {
			return population;
		}
		public void setPopulation(long population) {
			this.population = population;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		
	}
	
	

}
