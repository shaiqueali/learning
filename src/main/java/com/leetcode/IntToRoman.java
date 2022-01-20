package com.leetcode;

import java.util.TreeMap;

import static com.Constant.intToRomainMap;

public class IntToRoman {

    public static void main(String[] args) {
        System.out.println(integerToRoman(99));
        System.out.println(toRoman2(99));
    }

    public static String integerToRoman(int num) {

        System.out.println("Integer: " + num);
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLiterals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(romanLiterals[i]);
            }
        }
        System.out.println("Roman: " + roman.toString());
        System.out.println("---------------------------------------------------");
        return roman.toString();
    }

    public static String toRoman(int number) {
        int l = intToRomainMap().floorKey(number);
        if (number == l) {
            return intToRomainMap().get(number);
        }
        return intToRomainMap().get(l) + toRoman(number - l);
    }

    public static TreeMap<Integer, String> intToRomainMap() {
        TreeMap<Integer, String> intToRomainMap = new TreeMap<>();
        intToRomainMap.put(1000, "M");
        intToRomainMap.put(900, "CM");
        intToRomainMap.put(500, "D");
        intToRomainMap.put(400, "CD");
        intToRomainMap.put(100, "C");
        intToRomainMap.put(90, "XC");
        intToRomainMap.put(50, "L");
        intToRomainMap.put(40, "XL");
        intToRomainMap.put(10, "X");
        intToRomainMap.put(9, "IX");
        intToRomainMap.put(5, "V");
        intToRomainMap.put(4, "IV");
        intToRomainMap.put(1, "I");
        return intToRomainMap;
    }

    public static String toRoman2(int number) {
        final TreeMap<Integer, String> map = intToRomainMap();
        StringBuilder roman = new StringBuilder();
        while (number != 0) {
            int l = map.floorKey(number);
            roman.append(map.get(l));
            number = number - l;
        }
        return roman.toString();
    }


}
