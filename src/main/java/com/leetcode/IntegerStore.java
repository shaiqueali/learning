package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Returns true if any pair of numbers in the store add up to the given sum.
 */

public class IntegerStore {

    public static void main(String[] args) {
        int[] array = {2,7,9,11};
        System.out.println(twoSum(array, 20));
        System.out.println((twoSumWithHash(array, 20)));
    }


    public static boolean twoSum(final int[] array, final int target) {

        int tempSum;
        for (int i = 0; i < array.length; i++) {
            tempSum = array[i];
            for (int j = i + 1; j < array.length; j++) {
                int temp2;
                temp2 = tempSum + array[j];
                if (temp2 == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean twoSumWithHash(final int[] array, final int target) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            int diff = target - array[i];
            if(hash.containsKey(diff)) {
                return true;
            }
            hash.put(array[i], i);
        }
        return false;
    }
}
