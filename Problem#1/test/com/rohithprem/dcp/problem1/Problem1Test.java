package com.rohithprem.dcp.problem1;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 Daily Coding Problem: Problem #1 [Easy]


 This problem was recently asked by Google.

 Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

 For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

 Bonus: Can you do this in one pass?

 */
public class Problem1Test {

    private final Problem1 addToK = new Problem1();

    @Test
    public void addToKEmpty(){
        Integer[] numbers = {};
        int k = 30;
        double start = System.currentTimeMillis();
        boolean response = addToK.execute(Arrays.asList(numbers), k);
        double end = System.currentTimeMillis();
        System.out.println("Time Taken: " + (end-start));
        Assert.assertFalse(response);
    }

    @Test
    public void addToKTrueSimple(){
        Integer[] numbers = {1,2,10,20};
        int k = 30;
        double start = System.currentTimeMillis();
        boolean response = addToK.execute(Arrays.asList(numbers), k);
        double end = System.currentTimeMillis();
        System.out.println("Time Taken: " + (end-start));
        Assert.assertTrue(response);
    }

    @Test
    public void addToKFalseSimple(){
        Integer[] numbers = {1,2,10,20};
        int k = 31;
        double start = System.currentTimeMillis();
        boolean response = addToK.execute(Arrays.asList(numbers), k);
        double end = System.currentTimeMillis();
        System.out.println("Time Taken: " + (end-start));
        Assert.assertFalse(response);
    }

    @Test
    public void addToKWithNegativeNumbersTrue(){
        Integer[] numbers = {-20,30,15,5};
        int k = 10;
        double start = System.currentTimeMillis();
        boolean response = addToK.execute(Arrays.asList(numbers), k);
        double end = System.currentTimeMillis();
        System.out.println("Time Taken: " + (end-start));
        Assert.assertTrue(response);
    }

    @Test
    public void addToKWithNegativeNumbersFalse(){
        Integer[] numbers = {-20,30,15,5};
        int k = 5;
        double start = System.currentTimeMillis();
        boolean response = addToK.execute(Arrays.asList(numbers), k);
        double end = System.currentTimeMillis();
        System.out.println("Time Taken: " + (end-start));
        Assert.assertFalse(response);
    }

    @Test
    public void addToKWithNegativeExpectationTrue(){
        Integer[] numbers = {-20,30,15,5};
        int k = -5;
        double start = System.currentTimeMillis();
        boolean response = addToK.execute(Arrays.asList(numbers), k);
        double end = System.currentTimeMillis();
        System.out.println("Time Taken: " + (end-start));
        Assert.assertTrue(response);
    }

    @Test
    public void addToKWithNegativeExpectationFalse(){
        Integer[] numbers = {-20,30,15,5};
        int k = -20;
        double start = System.currentTimeMillis();
        boolean response = addToK.execute(Arrays.asList(numbers), k);
        double end = System.currentTimeMillis();
        System.out.println("Time Taken: " + (end-start));
        Assert.assertFalse(response);
    }

    @Test
    public void addToKWithLargeArrayTrue(){
        List<Integer> numbers = new ArrayList<>();
        Random r = new Random();
        int low = 1;
        int high = 40000000;
        for(int i = 0 ; i < 1000 ; i++){
            numbers.add(r.nextInt(high-low) + low);
        }
        numbers.add(21);
        numbers.add(50);
        int k = 71;
        double start = System.currentTimeMillis();
        boolean response = addToK.execute(numbers, k);
        double end = System.currentTimeMillis();
        System.out.println("Time Taken: " + (end-start));
        Assert.assertTrue(response);
    }

    @Test
    public void addToKWithMassiveArrayTrue(){
        List<Integer> numbers = new ArrayList<>();
        Random r = new Random();
        int low = 1;
        int high = 40000000;
        for(int i = 0 ; i < 100000 ; i++){
            numbers.add(r.nextInt(high-low) + low);
        }
        numbers.add(21);
        numbers.add(50);
        int k = 71;
        double start = System.currentTimeMillis();
        boolean response = addToK.execute(numbers, k);
        double end = System.currentTimeMillis();
        System.out.println("Time Taken: " + (end-start));
        Assert.assertTrue(response);
    }

}
