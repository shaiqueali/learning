package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class FindFirstAndLastPositionTest {

    @Test
    public void searchRangeTest() {
        FindFirstAndLastPosition obj = new FindFirstAndLastPosition();
        int[] input = {1};
        int target = 1;
        int[] expected = {0,0};
        Assert.assertArrayEquals(expected, obj.searchRange(input, target));

//        input = new int[]{3, 3, 3};
//        target = 3;
//        expected = new int[]{0, 2};
//        Assert.assertArrayEquals(expected, obj.searchRange(input, target));
    }
}
