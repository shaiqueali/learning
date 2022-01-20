package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15, 18};
        System.out.println(Arrays.toString(twoSum(array, 18)));
        System.out.println(Arrays.toString(twoSumBruteForce(array, 18)));
    }

    public static int[] twoSum(final int[] array, final int target) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            Integer diff = target - array[i];
            if (hash.containsKey(diff)) {
                return new int[]{hash.get(diff), i};
            }
            hash.put(array[i], i);
        }
        return new int[0];
    }

    public static int[] twoSumBruteForce(final int[] array, final int target) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + i; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
