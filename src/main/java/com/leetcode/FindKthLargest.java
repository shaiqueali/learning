package com.leetcode;

import java.util.PriorityQueue;

/**
 * Example: https://levelup.gitconnected.com/patterns-for-coding-interviews-top-k-elements-1a1368c4cbf0
 *
 * Patterns for Coding Interviews — Top ‘K’ Elements
 */

public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        // Create a min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

        // Insert the array elements into the min heap.
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
            // Pop out the root element if the min heap size is larger than k
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
