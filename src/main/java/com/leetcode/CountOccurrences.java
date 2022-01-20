package com.leetcode;

public class CountOccurrences {
    public static void main(String[] args) {
        int array[] = {1, 2, 2, 2, 2, 3, 4, 7 ,8 ,8 };
        System.out.println("linerSearch: " + linerSearch(array, 2));
        System.out.println("linerSearchWithRecursive: " + linerSearchWithRecursive(array, 2, 0, 0));
    }

    public static int linerSearch(final int[] array, int search) {
        int count = 0;
        for (int number : array) if (search == number) count++;
        return count;
    }

    public static int linerSearchWithRecursive(final int[] array, int search, int count, int index) {

        if (search == array[index++]) count++;
        if (index < array.length) {
            count = linerSearchWithRecursive(array, search, count, index);
        }
        return count;
    }

    public static int binarySearch(final int[] array, int search) {
        int count = 0;
        int right = array.length - 1;
        for (int left = 0; left <= right;) {
            // find the middle
            int middle =  (left + right) / 2;
            if (search == array[middle]){
                count++;  // case 1: Where search is on your middle position
            } else if (search > middle) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return count;
    }
}
