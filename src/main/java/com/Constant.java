package com;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * TreeMap is an example of a SortedMap, which means that the order of the keys can be sorted, and when iterating over the keys,
 * you can expect that they will be in order.
 *
 * HashMap on the other hand, makes no such guarantee. Therefore, when iterating over the keys of a HashMap, you can't be sure what order they will be in.
 *
 * HashMap will be more efficient in general, so use it whenever you don't care about the order of the keys.
 */

@UtilityClass
public class Constant {

    public static Map<Character, Integer> romainToIntMap() {
        Map<Character, Integer> romainMap = new HashMap<>();
        romainMap.put('I', 1);
        romainMap.put('V', 5);
        romainMap.put('X', 10);
        romainMap.put('L', 50);
        romainMap.put('C', 100);
        romainMap.put('D', 500);
        romainMap.put('M', 1000);
        return romainMap;
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
}
