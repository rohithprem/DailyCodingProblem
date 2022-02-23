package com.rohithprem.dcp.problem4;

import java.util.Arrays;

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

public class MissingPositiveInteger {

	public int execute(int[] input) {
		Arrays.sort(input);
		int missing = -1;
		for (int i=0 ; i<input.length-1 ; i++) {
			int val = input[i];
			int nextVal = input[i+1];
			int expectedNext = val+1;
			if(val >= 0 && nextVal != expectedNext) {
				missing = expectedNext;
				break;
			}
		}
		if(missing == -1) {
			int val = input[input.length - 1];
			if(val < 0) {
				missing = 1;
			} else {
				missing = val+1;
			}
		}
		return missing;
	}
	
}
