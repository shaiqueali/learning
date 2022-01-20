package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class MinSwapArray {

    public int minSwaps(int[] nums) {
        final int length = nums.length;
        final HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++)
            map.put(nums[i], i);

        Arrays.sort(nums);
        // To keep track of visited elements. Initialize
        // all elements as not visited or false.
        boolean[] visited = new boolean[length];
        // Initialize result
        int ans = 0;
        for (int i = 0; i < length; i++) {
            // already swapped and corrected or
            // already present at correct pos
            if (visited[i] || map.get(nums[i]) == i)
                continue;
            int j = i;
            int cycleSize = 0;
            while (!visited[j]) {
                visited[j] = true;
                // move to next node
                j = map.get(nums[j]);
                cycleSize++;
            }
            // Update answer by adding current cycle.
            if (cycleSize > 0) {
                ans += (cycleSize - 1);
            }
        }
        return ans;
    }
}
