package com.leetcode;

import java.util.Map;

import static com.Constant.romainToIntMap;

public class RomanToNumeric {

    public static void main(String[] args) {
        System.out.println(romanToInt("XCIX"));
        romanToDecimal("XCIX");
    }

    public static int romanToInt(final String roman) {
        Map<Character, Integer> romainMap = romainToIntMap();
        int result = 0;
        if (null == roman) {
            return result;
        }
        int last = 0;
        int current;
        int lastIndex = roman.length() - 1;
        for (int i = lastIndex; i >= 0; i--) {
            current = romainMap.get(roman.charAt(i));
            if (i == lastIndex) {
                last = current;
                result = last;
                continue;
            }
            if (last > current) {
                result -= current;
            } else {
                result += current;
            }
            last = current;
        }
        return result;
    }


    public static void romanToDecimal(final String romanNumber) {
        int decimal = 0;
        int lastNumber = 0;
        String romanNumeral = romanNumber.toUpperCase();
        /* operation to be performed on upper cases even if user
           enters roman values in lower case chars */
        for (int x = romanNumeral.length() - 1; x >= 0; x--) {
            char convertToDecimal = romanNumeral.charAt(x);

            switch (convertToDecimal) {
                case 'M':
                    decimal = processDecimal(1000, lastNumber, decimal);
                    lastNumber = 1000;
                    break;

                case 'D':
                    decimal = processDecimal(500, lastNumber, decimal);
                    lastNumber = 500;
                    break;

                case 'C':
                    decimal = processDecimal(100, lastNumber, decimal);
                    lastNumber = 100;
                    break;

                case 'L':
                    decimal = processDecimal(50, lastNumber, decimal);
                    lastNumber = 50;
                    break;

                case 'X':
                    decimal = processDecimal(10, lastNumber, decimal);
                    lastNumber = 10;
                    break;

                case 'V':
                    decimal = processDecimal(5, lastNumber, decimal);
                    lastNumber = 5;
                    break;

                case 'I':
                    decimal = processDecimal(1, lastNumber, decimal);
                    lastNumber = 1;
                    break;
            }
        }
        System.out.println(decimal);
    }

    public static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
        if (lastNumber > decimal) {
            return lastDecimal - decimal;
        } else {
            return lastDecimal + decimal;
        }
    }
}
