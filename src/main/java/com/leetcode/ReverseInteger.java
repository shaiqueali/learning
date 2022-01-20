package com.leetcode;

public class ReverseInteger {

    public static void main(String args[]) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        int result;
        boolean isMinus = false;
        String number = String.valueOf(x);
        StringBuilder input1 = new StringBuilder();
        if (number.startsWith("-")) {
            number = number.replace("-", "");
            isMinus = true;
        }
        try {
            input1.append(number);
            result = Integer.parseInt(input1.reverse().toString());
        } catch (Exception e) {
            return 0;
        }

        return isMinus ? result * -1 : result;
    }
}
