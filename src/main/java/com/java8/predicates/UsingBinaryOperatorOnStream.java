package com.java8.predicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class UsingBinaryOperatorOnStream {

	private List<String> friends =  Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
	private List<String> comrades = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");
	private List<String> editors =  Arrays.asList("Brian", "Jackie", "John", "Mike");
	
	  
	public static void main(String[] args) {
		UsingBinaryOperatorOnStream biOps = new UsingBinaryOperatorOnStream(); 
		biOps.mapOperationOnAStream(); 
		
	}

	

	private void mapOperationOnAStream() { 
		
		Optional<String> aLongName = 
				comrades
				.stream()
				.reduce((name1,name2) -> name1.length() >= name2.length() ? name1 : name2);
		
		aLongName.ifPresent(name  -> System.out.println( "longest name " +  name ));

		User user1 = new User("kasi", "subram", UserGender.M) ;
		User user2 = new User("MEGAL", "KAN", UserGender.F) ;
		User user3 = new User("RUK", "LAKS", UserGender.F) ;
		
		List<User> userList = new ArrayList<>(); 
		userList.add(user1);userList.add(user2);userList.add(user3);
		
		
		System.out.println( " ~~~~~~~~~  ");
		List<String> userNames = userList
				.stream()
				.map(user -> user.firstName + user.lastName + " " + user.gender.toString())
				.collect(Collectors.toList()); 
		
		
		userNames.forEach( name -> System.out.println(  name ));
	}
	
	public class User{
		private String firstName ; 
		private String lastName ; 
		private UserGender gender;
		
		
		User(String firstName,  String lastName, UserGender userGender){
			this.firstName = firstName ; 
			this.lastName = lastName; 
			this.gender = userGender ;
			
		}
		
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public UserGender getGender() {
			return gender;
		}
		public void setGender(UserGender gender) {
			this.gender = gender;
		}
	}
	
	public enum UserGender {
		M , F ;
	}
	
	
	
}
