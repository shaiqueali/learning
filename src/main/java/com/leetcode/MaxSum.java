package com.leetcode;

public class MaxSum {

    public static int maxSum(int arr[], int k)  {
        int len = arr.length;
        // k must be greater
        if (len < k) {
            return -1;
        }
        // Compute sum of first window of size k
        int res = 0;
        for (int i=0; i<k; i++)
            res += arr[i];
        // Compute sums of remaining windows by
        // removing first element of previous
        // window and adding last element of
        // current window.
        int currSum = res;
        for (int i=k; i<len; i++)  {
            currSum += arr[i] - arr[i-k];
            res = Math.max(res, currSum);
        }
        return res;
    }
}
