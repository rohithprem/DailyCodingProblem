package com.rohithprem.dcp.problem2;

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

public class Problem2 {

    //With division
    public Integer[] executeWithDivision(Integer[] input){
        Integer[] output = new Integer[input.length];
        int totalProduct = 1;
        int countOfZeroes = 0;
        for(int value : input){
            if(value != 0){
                totalProduct *= value;
            } else {
                countOfZeroes++;
                if(countOfZeroes > 1){
                    java.util.Arrays.fill(output, 0);
                    return output;
                }
            }
        }
        for(int i=0 ; i<input.length ; i++){
            int number = input[i];
            if(number != 0){
                output[i] = countOfZeroes == 0 ? totalProduct/input[i] : 0;
            } else {
                output[i] = totalProduct;
            }
        }
        return output;
    }

    //TODO: arrive at solution without division
}
