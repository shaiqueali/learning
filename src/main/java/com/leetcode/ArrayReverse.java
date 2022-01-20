package com.leetcode;

import java.util.Arrays;

public class ArrayReverse {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
        reverse(numbers);
    }

    /**
     * reverse the given array in place * @param input
     */
    public static void reverse(int[] input) {
        System.out.println("original array : " + Arrays.toString(input));
        // handling null, empty and one element array
        if (input == null || input.length <= 1) {
            return;
        }
        int lastIndex = input.length - 1;
        for (int i = 0; i < input.length / 2; i++) {
            int temp = input[i];
            // swap numbers
            input[i] = input[lastIndex - i];
            input[lastIndex - i] = temp;
        }
        System.out.println("reversed array : " + Arrays.toString(input));
    }

}
