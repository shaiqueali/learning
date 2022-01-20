package com.dsa.datastructure.linear.array;

import com.leetcode.ArrayReverse;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArrayReverseTest {

    @Test
    public void testReverseWithEvenLengthOfArray() {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        ArrayReverse.reverse(numbers);
        assertArrayEquals(new int[]{6, 5, 4, 3, 2, 1}, numbers);
    }

    @Test
    public void testReverseWithOddLengthOfArray() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        ArrayReverse.reverse(numbers);
        assertArrayEquals(new int[]{7, 6, 5, 4, 3, 2, 1}, numbers);
    }

    @Test
    public void testReverseWithEmptyArray() {
        int[] numbers = {};
        ArrayReverse.reverse(numbers);
        assertArrayEquals(new int[]{}, numbers);
    }

    @Test
    public void testReverseWithNullArray() {
        int[] numbers = null;
        ArrayReverse.reverse(numbers);
        assertArrayEquals(null, numbers);
    }

    @Test
    public void testReverseWithJustOneElementArray() {
        int[] numbers = {1};
        ArrayReverse.reverse(numbers);
        assertArrayEquals(new int[]{1}, numbers);
    }

}
