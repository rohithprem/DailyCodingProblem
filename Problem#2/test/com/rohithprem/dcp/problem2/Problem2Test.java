package com.rohithprem.dcp.problem2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Daily Coding Problem: Problem #2 [Hard]
 *
 * This problem was asked by Uber.
 *
 * Given an array of integers, return a new array such that each element at index i of the new array is the product of
 * all the numbers in the original array except the one at i.
 *
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
 * If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 *
 * Follow-up: what if you can't use division?
 */

public class Problem2Test {

    private static final Problem2 productOfRest = new Problem2();

    @Test
    public void testProductOfRestSimpleGivenExample1(){
        Integer[] input = {1,2,3,4,5};
        Integer[] output = productOfRest.executeWithDivision(input);
        Integer[] expectedOutput = {120,60,40,30,24};
        Assert.assertArrayEquals(output, expectedOutput);
    }

    @Test
    public void testProductOfRestSimpleGivenExample2(){
        Integer[] input = {3,2,1};
        Integer[] output = productOfRest.executeWithDivision(input);
        Integer[] expectedOutput = {2,3,6};
        Assert.assertArrayEquals(output, expectedOutput);
    }

    @Test
    public void testProductOfRestWithSingleZero(){
        Integer[] input = {0,4,10};
        Integer[] output = productOfRest.executeWithDivision(input);
        Integer[] expectedOutput = {40,0,0};
        Assert.assertArrayEquals(output, expectedOutput);
    }

    @Test
    public void testProductOfRestWithMultipleZeroes(){
        Integer[] input = {20,1,30,0,400,2,0,15};
        Integer[] output = productOfRest.executeWithDivision(input);
        Integer[] expectedOutput = {0,0,0,0,0,0,0,0};
        Assert.assertArrayEquals(output, expectedOutput);
    }

}
