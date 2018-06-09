package com.java8.supplier;

public class HolderNaive { 
	
private Heavy heavy;

public HolderNaive() 
{ 
	System.out.println("Holder created");
}

public Heavy getHeavy() 
{ 
	if(heavy == null) {
		heavy = new Heavy(); 
	}


return heavy;

}

}