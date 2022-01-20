package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class MinSwapArrayTest {

    @Test
    public void testMinSwapArray() {
        MinSwapArray minSwapArray = new MinSwapArray();
        int arr[] = new int[] { 101, 758, 315, 730, 472, 619, 460, 479 };
        Assert.assertEquals(5, minSwapArray.minSwaps(arr));
    }
}
