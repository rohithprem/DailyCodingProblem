package com.rohithprem.dcp.problem1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 *
 Daily Coding Problem: Problem #1 [Easy]


 This problem was recently asked by Google.

 Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

 For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

 Bonus: Can you do this in one pass?

 */
public class AddToKTest {

    private final AddToK addToK = new AddToK();

    @Test
    public void addToKTrueSimple(){
        Integer[] numbers = {1,2,10,20};
        int k = 30;
        boolean response = addToK.execute(Arrays.asList(numbers), k);
        Assert.assertTrue(response);
    }

    @Test
    public void addToKFalseSimple(){
        Integer[] numbers = {1,2,10,20};
        int k = 31;
        boolean response = addToK.execute(Arrays.asList(numbers), k);
        Assert.assertFalse(response);
    }

}
