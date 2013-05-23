package com.epam.ehalavachou.jutask2.bean;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;

import com.epam.ehalavachou.jutask2.interfaces.IAirBehavior;

public class TestMockAir {

	Mockery context = null;
	
	@Before
	public void setUp() throws Exception{
		context = new JUnit4Mockery();
	}
	
	@Test
	public void tstAirBurning() {
		final IAirBehavior mockAir = context.mock(IAirBehavior.class);
		
		Fire fire = new Fire();
		
		Quantities.setQuantity(fire, 10);
		Quantities.setQuantity(mockAir, 1);
		
		context.checking(
				new Expectations() {{
					oneOf(mockAir).burn();
				}}
			);
		fire.interaction(mockAir);
		context.assertIsSatisfied();
	}

}
