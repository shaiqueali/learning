package com.leetcode;

import java.util.Arrays;

public class RemoveDuplicates2 {

    public static void main(String[] args) {
//        final int[][] array = new int[][]{
//                {1, 1, 2, 2, 3, 4, 5},
//                {1, 1, 1, 1, 1, 1, 1},
//                {1, 2, 3, 4, 5, 6, 7},
//                {1, 2, 1, 1, 1, 1, 1},};
        final int[] array = {1, 1, 2, 2, 3, 4, 5};
        System.out.println(Arrays.toString(removeDuplicates(array)));

    }

    public static int[] removeDuplicates(int[] array) {
        int temp = 0;
        for(int i=0; i<array.length; i++) {
            if(temp == array[i]) {
                array[i] = 0;
            }
            temp = array[i];
        }
        return array;
    }


}
