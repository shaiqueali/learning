package com.dsa.algorthim.search.linear;

/**
 * Linear search is a sequential searching algorithm where we start from one end and check every element of the list until the desired element is found. It is the simplest searching algorithm
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class LinearSearch {

    public static void main(String[] args) {
        int array[] = {2, 4, 0, 1, 9};
        int x = 1;

        int result = linearSearch(array, x);

        if (result == -1)
            System.out.print("Element not found");
        else
            System.out.print("Element found at index: " + result);
    }

    public static int linearSearch(int[] array, int x) {

        // Going through array sequentially
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x)
                return i;
        }
        return -1;
    }
}
