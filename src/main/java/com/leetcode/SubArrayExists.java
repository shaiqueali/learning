package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class SubArrayExists {

    public static void main(String[] args) {
        int arr[] = null;
        if (subArrayExists(arr))
            System.out.println(
                    "Found a subarray with 0 sum");
        else
            System.out.println("No Such Sub Array Exists!");
    }

    /**
     * Time Complexity of this solution can be considered as O(n) under the assumption that we have good hashing function
     * that allows insertion and retrieval operations in O(1) time.
     * Space Complexity: O(n) .Here we required extra space for unordered_set to insert array elements.
     */

    public static boolean subArrayExists(final int[] array) {
        // Creates an empty hashset hs
        Set<Integer> hs = new HashSet<Integer>();
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            // Add current element to sum
            sum += array[i];
            // Return true in following cases
            // a) Current element is 0
            // b) sum of elements from 0 to i is 0
            // c) sum is already present in hash map
            if (array[i] == 0 || sum == 0 || hs.contains(sum)) return true;
            // Add sum to hash set
            hs.add(sum);
        }
        // We reach here only when there is
        // no subarray with 0 sum
        return false;
    }
}
