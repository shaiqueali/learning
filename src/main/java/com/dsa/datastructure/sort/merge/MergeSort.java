package com.dsa.datastructure.sort.merge;

public class MergeSort {

    public void mergeSort(int[] list, int lowIndex, int highIndex) {
        if (lowIndex == highIndex)
            return;
        else {
            int midIndex = (lowIndex + highIndex) / 2;
            mergeSort(list, lowIndex, midIndex);
            mergeSort(list, midIndex + 1, highIndex);
            merge(list, lowIndex, midIndex, highIndex);
        }
    }

    public void merge(int[] list, int lowIndex, int midIndex, int highIndex) {
        int[] left = new int[midIndex - lowIndex + 2];

        for (int i = lowIndex; i <= midIndex; i++) {
            left[i - lowIndex] = list[i];
        }
        left[midIndex - lowIndex + 1] = Integer.MAX_VALUE;
        int[] right = new int[highIndex - midIndex + 1];

        for (int i = midIndex + 1; i <= highIndex; i++) {
            right[i - midIndex - 1] = list[i];
        }
        right[highIndex - midIndex] = Integer.MAX_VALUE;
        int i = 0, j = 0;

        for (int k = lowIndex; k <= highIndex; k++) {
            if (left[i] <= right[j]) {
                list[k] = left[i];
                i++;
            } else {
                list[k] = right[j];
                j++;
            }
        }
    }
}
