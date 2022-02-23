package com.rohithprem.dcp.problem4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Daily Coding Problem: Problem #4 [Hard]
 * 
 * This problem was asked by Stripe.
 * 
 * Given an array of integers, find the first missing positive integer in linear time and constant space. 
 * In other words, find the lowest positive integer that does not exist in the array. 
 * The array can contain duplicates and negative numbers as well.
 * 
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 * 
 * You can modify the input array in-place.
 *
 */

public class MissingPositiveIntegerTests {

	protected MissingPositiveInteger problem = new MissingPositiveInteger();
	
	@Test
	public void testGivenExample1() {
		int[] intput = {3,4,-1,1};
		int expectedOutput = 2;
		int response = problem.execute(intput);
		Assert.assertEquals(expectedOutput, response);
	}
	
	@Test
	public void testGivenExample2() {
		int[] intput = {1,2,0};
		int expectedOutput = 3;
		int response = problem.execute(intput);
		Assert.assertEquals(expectedOutput, response);
	}
	
}
