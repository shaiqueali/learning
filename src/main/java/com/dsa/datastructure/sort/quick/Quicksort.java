package com.dsa.datastructure.sort.quick;


import java.util.Arrays;

public class Quicksort {

    public static void main(String args[]) {
        int[] array = {9, 20, 6, 5, 13, 45, 20, 24, 99, 75};
        System.out.println("Unsorted Array");
        System.out.println(Arrays.toString(array));
        // call quicksort() on array data
        quickSort(array, 0, array.length - 1);

        System.out.println("Sorted Array in Ascending Order ");
        System.out.println(Arrays.toString(array));


    }

    // baeldung solution - not perfect only work with when pivot is end
    // method to find the partition position
    public static int partition(int[] arr, int begin, int end) {
        // choose the rightmost element as pivot
        int pivot = arr[end];
        // pointer for greater element
        int i = (begin - 1);

        // traverse through all elements
        // compare each element with pivot
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                // if element smaller than pivot is found
                // swap it with the greater element pointed by i
                i++;

                // swapping element at i with element at j
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        // swapt the pivot element with the greater element specified by i
        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        // return the position from where partition is done
        return i + 1;
    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            // find pivot element such that
            // elements smaller than pivot are on the left
            // elements greater than pivot are on the right
            int partitionIndex = partition(arr, begin, end);

            // recursive call on the left of pivot
            quickSort(arr, begin, partitionIndex - 1);
            // recursive call on the right of pivot
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    /**
     * HackerRank - need to fix this
     */

    public static int partition(int[] array, int left, int right, int pivot) {
        // left is less and equal then right
        while (left < right) {
            while (array[left] < pivot) {
                left++;
            }
            while (array[right] > pivot) {
                right--;
            }
            if (left < right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public static void quickSortHackerRank(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        int pivot = array[(left + right) / 2];
        int partitionIndex = partition(array, left, right, pivot);
        quickSortHackerRank(array, left, partitionIndex - 1);
        quickSortHackerRank(array, partitionIndex + 1, right);
    }

    public static void swap(int[] array, int left, int right) {
        int swapTemp = array[left];
        array[left] = array[right];
        array[right] = swapTemp;
    }
}
