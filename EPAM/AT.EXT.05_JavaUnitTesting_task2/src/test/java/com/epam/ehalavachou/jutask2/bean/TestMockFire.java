package com.epam.ehalavachou.jutask2.bean;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;

import com.epam.ehalavachou.jutask2.interfaces.IFireBehavior;


public class TestMockFire {

Mockery context = null;
	
	@Before
	public void setUp() throws Exception{
		context = new JUnit4Mockery();
	}
	
	@Test
	public void tstFireInglufing() {
		final IFireBehavior mockFire = context.mock(IFireBehavior.class);
		
		Earth earth = new Earth();
		
		Quantities.setQuantity(earth, 50);
		Quantities.setQuantity(mockFire, 40);
		
		context.checking(
					new Expectations() {{
						oneOf(mockFire).ingulf();
					}}
				);
		earth.interaction(mockFire);
		context.assertIsSatisfied();
	}
	
	@Test
	public void tstFireQuench(){
		final IFireBehavior mockFire = context.mock(IFireBehavior.class);
		
		Water water = new Water();
		
		Quantities.setQuantity(water, 100);
		Quantities.setQuantity(mockFire, 30);
		
		context.checking(
				new Expectations() {{
					oneOf(mockFire).quench();
					one(mockFire).sizzleLoudly();
				}}
			);
		water.interaction(mockFire);
		context.assertIsSatisfied();
	}

}
