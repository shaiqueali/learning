package com.dsa.algorthim.search.binary;

/**
 * Binary Search is a searching algorithm for finding an element's position in a sorted array.
 * Binary Search Algorithm can be implemented in two ways which are discussed below.
 *
 * Iterative Method
 * Recursive Method
 * The recursive method follows the divide and conquer approach.
 *
 * Time Complexities
 *
 * Best case complexity: O(1)
 * Average case complexity: O(log n)
 * Worst case complexity: O(log n)
 * Space Complexity
 *
 * The space complexity of the binary search is O(1)
 *
 * Binary Search Applications
 * In libraries of Java, .Net, C++ STL
 * While debugging, the binary search is used to pinpoint the place where the error happens.
 */
public class BinarySearch {

    public static void main(String args[]) {
        int array[] = {5, 9, 17, 23, 25, 45, 59, 63, 71, 89};
//        printRecursive(1);
        System.out.println(" -> " + binarySearchRecursive(array, 71));
        System.out.println(" -> " + binarySearchIterative(array, 70));
    }

    public static void printRecursive(int i) {
        if (i < 10) {
            System.out.println("i = " + i++);
            printRecursive(i);
        }
    }

    public static int binarySearchRecursive(int array[], int search) {
        return binarySearchRecursive(array, search, 0, array.length - 1);
    }

    public static int binarySearchRecursive(int array[], int search, int left, int right) {
        if (left > right) {
            return -1; // no elements
        }

        int middle = (left + right) / 2; // find the middle
//        int middle = left + ((right - left) / 2); // prevent the overflow
        int middleElement = array[middle];

        if (middleElement == search) { // case 1: Where search is on your middle position
            return array[middle];
        } else if (search > middleElement) { // case 2 - search is greater then middle position. Then left will be middle + 1 and right will be same;
            return binarySearchRecursive(array, search, middle + 1, right);
        } else { // case 3: search is less then middle position. then left is
            return binarySearchRecursive(array, search, left, middle - 1);
        }
    }

    public static int binarySearchIterative(int array[], int search) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2; // find the middle
//        int middle = left + ((right - left) / 2); // prevent the overflow
            int middleElement = array[middle];
            if (middleElement == search) { // case 1: Where search is on your middle position
                return array[middle];
            } else if (search > middleElement) { // case 2 - search is greater then middle position. Then left will be middle + 1 and right will be same;
                left =  middle + 1;
            } else { // case 3: search is less then middle position. then left is same and right will be middle - 1
                right = middle - 1;
            }
        }
        return -1;
    }

    public static int binarySearch(int array[], int x, int low, int high) {

        // Repeat until the pointers low and high meet each other
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == x)
                return mid;

            if (array[mid] < x)
                low = mid + 1;

            else
                high = mid - 1;
        }

        return -1;
    }
}
