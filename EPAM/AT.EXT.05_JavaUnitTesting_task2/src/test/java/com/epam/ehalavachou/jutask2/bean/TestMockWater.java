package com.epam.ehalavachou.jutask2.bean;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;

import com.epam.ehalavachou.jutask2.interfaces.IAirBehavior;
import com.epam.ehalavachou.jutask2.interfaces.IWaterBehavior;

public class TestMockWater {

	Mockery context = null;
	
	@Before
	public void setUp() throws Exception{
		context = new JUnit4Mockery();
	}
	
	@Test
	public void tstWaterEvaporating() {
		final IWaterBehavior mockWater = context.mock(IWaterBehavior.class);
		
		Fire fire = new Fire();
		
		Quantities.setQuantity(fire, 40);
		Quantities.setQuantity(mockWater, 10);
		
		context.checking(
				new Expectations() {{
					oneOf(mockWater).evaporate();
					
				}}
			);
		fire.interaction(mockWater);
		context.assertIsSatisfied();
	}

}
