package com.leetcode;

import java.util.Arrays;

public class FindFirstAndLastPosition {

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int index = 0;
        if (nums == null) return result;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result[index] = i;
                // only one position found. add same with last position
                if (index==0) {
                    result[index+1] = i;
                    index++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] array = {2, 5, 5, 5, 6, 6, 8, 9, 9, 9};
        int target = 5;
        FindFirstAndLastPosition obj = new FindFirstAndLastPosition();
        System.out.println(Arrays.toString(obj.searchRange(array, target)));
    }

}
