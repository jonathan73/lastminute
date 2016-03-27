package com.lastminute.salestaxes.utils;

import junit.framework.Assert;

import org.junit.Test; 

public class TestRound {
	/**
	 * Test if the number will be round to the nearest value of 0.5. 
	 */
	@Test
	public void testRoundNearest() {
		{
			double value = 0.01;
			double result = NumberUtils.roundNearest(value);
			Assert.assertEquals(result, 0.05d);
		}
		{
			double value = 0.07;
			double result = NumberUtils.roundNearest(value);
			Assert.assertEquals(result, 0.10);
		}
		{
			double value = 0.00;
			double result = NumberUtils.roundNearest(value);
			Assert.assertEquals(result, 0.00);
		} 
		
	}
	/**
	 * Test if the number will be rounded with two decimals.
	 */
	@Test
	public void testRound2Decimals() {
		{
			double value = 0.234d;
			double result = NumberUtils.round(value);
			Assert.assertEquals(result, 0.23d);
		}
		{
			double value = 0.278d;
			double result = NumberUtils.round(value);
			Assert.assertEquals(result, 0.28d);
		}
		{
			double value = 0.222d;
			double result = NumberUtils.round(value);
			Assert.assertEquals(result, 0.22d);
		}
	}
	
}
