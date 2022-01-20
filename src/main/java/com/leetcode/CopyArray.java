package com.leetcode;

import java.util.Arrays;

public class CopyArray {

    public static void main(String args[]) {
        ConcatenateTwoArrays();
    }

    public static void arraycopy() {
        int[] n1 = {2, 3, 12, 4, 12, -2};

        int[] n3 = new int[5];

        // Creating n2 array of having length of n1 array
        int[] n2 = new int[n1.length];

        // copying entire n1 array to n2
        System.arraycopy(n1, 0, n2, 0, n1.length);
        System.out.println("n2 = " + Arrays.toString(n2));

        // copying elements from index 2 on n1 array
        // copying element to index 1 of n3 array
        // 2 elements will be copied

        /**
         * Params:
         * src – the source array.
         * srcPos – starting position in the source array.
         * dest – the destination array.
         * destPos – starting position in the destination data.
         * length – the number of array elements to be copied.
         */
        System.arraycopy(n1, 2, n3, 1, 2);

        System.out.println("n3 = " + Arrays.toString(n3));
    }

    public static void copyOfRange() {
        int[] source = {2, 3, 12, 4, 12, -2};

        // copying entire source array to descopyOftination
        int[] destination1 = Arrays.copyOfRange(source, 0, source.length);
        System.out.println("destination1 = " + Arrays.toString(destination1));

        // copying from index 2 to 5 (5 is not included)
        /**
         * Params:
         * original – the array from which a range is to be copied
         * from – the initial index of the range to be copied, inclusive
         * to – the final index of the range to be copied, exclusive. (This index may lie outside the array.)
         */
        int[] destination2 = Arrays.copyOfRange(source, 2, 5);
        System.out.println("destination2 = " + Arrays.toString(destination2));
    }

    public static void copying2dArrays() {
        int[][] source = {
                {1, 2, 3, 4},
                {5, 6},
                {0, 2, 42, -4, 5}
        };

        int[][] destination = new int[source.length][];

        for (int i = 0; i < destination.length; ++i) {

            // allocating space for each row of destination array
            destination[i] = new int[source[i].length];

            for (int j = 0; j < destination[i].length; ++j) {
                destination[i][j] = source[i][j];
            }
        }

        // displaying destination array
        System.out.println(Arrays.deepToString(destination));
    }

    public static void ConcatenateTwoArrays() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};

        int length  = array1.length + array2.length;
        int[] result;
        result = Arrays.copyOf(array1, length);
        for (int i=0, j=array1.length; j<length; i++, j++) {
            result[j] = array2[i];
        }
        System.out.println(Arrays.toString(result));
    }
}
