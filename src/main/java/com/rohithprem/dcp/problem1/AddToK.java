package com.rohithprem.dcp.problem1;

import java.util.List;

/**
 *
 Daily Coding Problem: Problem #1 [Easy]


 This problem was recently asked by Google.

 Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

 For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

 Bonus: Can you do this in one pass?

 */

public class AddToK {

    public boolean execute(List<Integer> numbers, int k){

        for (int i = 0 ; i < numbers.size() - 1 ; i++) {
            Integer number = numbers.get(i);
            for(int j = 0 ; j < numbers.size() ; j++){
                if(j == i){
                    continue;
                } else {
                    Integer number2 = numbers.get(j);
                    Integer sum = number + number2;
                    if(sum == k){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
