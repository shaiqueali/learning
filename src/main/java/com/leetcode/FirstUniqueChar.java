package com.leetcode;

public class FirstUniqueChar {

    public static void main(String[] args) {
        System.out.println(firstUniqueChar("sshaique"));
    }

    public static int firstUniqueChar(String s) {
        int[] count = new int[26];
        int n = s.length();
        // build char count bucket : <charIndex, count>
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            count[index]++;
        }
        // find the index
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            if (count[index] == 1) {
                return i;
            }
        }
        return -1;
    }
}
