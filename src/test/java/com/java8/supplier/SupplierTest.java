package com.java8.supplier;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

import org.junit.Assert;
import org.junit.Test;

public class SupplierTest {
	
	@Test
	public void testDummy()
	{
		Assert.assertTrue(true);
	}
	

	@Test 
	public void supplierTest() {
		AtomicInteger count = new AtomicInteger(65);
		Supplier<Character> charSupplier = () -> (char) count.getAndIncrement();
		//Assert.assertEquals(charSupplier.get(), "A");
	}
	
	
	

}
