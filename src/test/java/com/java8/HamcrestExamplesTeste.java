package com.java8;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class HamcrestExamplesTeste {
	
	@Test
	public void mapShouldContainsValues() {
	 Map<Long,String> valuesMap = mapOfTestData(); 
	 // assert with hamcrest matchers instead of junit assert matchers. 
	 // assertThat(map.get(41L), 
	 Assert.assertEquals(valuesMap.get(41L), "Devavalue");
		
	}
	
	
	@Test
	public void testDummy() {
		Assert.assertTrue(true);
	}

	
	
	private Map<Long,String> mapOfTestData() {
		
		Map<Long,String> namesAndAgesMap = new HashMap();
		namesAndAgesMap.put(41L, "Devavalue") ; 
		namesAndAgesMap.put(42L, "Ramananevavalue") ; 
		namesAndAgesMap.put(43L, "DilipoDevavalue") ; 
		
		return namesAndAgesMap;
		
		
		
	}

}
