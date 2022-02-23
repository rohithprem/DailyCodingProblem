package com.rohithprem.dcp.problem1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 Daily Coding Problem: Problem #1 [Easy]


 This problem was recently asked by Google.

 Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

 For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

 Bonus: Can you do this in one pass?

 */

public class Problem1 {

    //n^2 iterations
    boolean execute1(List<Integer> numbers, int k){
        int count = 0;
        for (int i = 0 ; i < numbers.size() - 1 ; i++) {
            Integer number = numbers.get(i);
            for(int j = 0 ; j < numbers.size() ; j++){
                if(j != i){
                    Integer number2 = numbers.get(j);
                    int sum = number + number2;
                    if(sum == k){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //One Pass?
    //List contains is still a hinderance but much better than previous
    boolean execute(List<Integer> numbers, int k){
        List<Integer> completedNumbers = new ArrayList<>();
        for(Integer number : numbers){
            int difference = k-Math.abs(number);
            if(completedNumbers.contains(difference)){
                return true;
            }
            completedNumbers.add(number);
        }
        return false;
    }

}
