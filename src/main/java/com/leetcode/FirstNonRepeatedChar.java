package com.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class FirstNonRepeatedChar {


    /**
     *
     * Using the indexOf() and lastIndexOf() method, we can find the first non-repeating character in a string in Java.
     * The method indexOf() returns the position of the first occurrence of a given character in a string whereas method lastIndexOf()
     * returns the position of the last occurrence of a given character in a string.
     */
    public char FirstNonRepeatedChar(final String inputStr) {
        char found = 0;
        for (char i : inputStr.toCharArray()) {
            if (inputStr.indexOf(i) == inputStr.lastIndexOf(i)) {
                return i;
            }
        }
        return found;
    }

    public static Character findFirstNonRepeatableChar(String str) {
        char found = 0;
        Map<Character,Integer> map = new LinkedHashMap();
        for (Character ch : str.toCharArray()) {
            map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);
        }

        Optional<Map.Entry<Character, Integer>> mFound = map.entrySet().stream().filter(x -> x.getValue() == 1).findFirst();
        if(mFound.isPresent()) {
            found = mFound.get().getKey();
        }
        return found;
    }

    public Character firstNonRepeatedCharacter(final String inputStr) {
        HashMap<Character,Integer> characterhashtable = new LinkedHashMap<Character ,Integer>();
        int length ;
        Character ch;
        length= inputStr.length();  // Scan string and build hash table
        for (int i=0;i < length;i++) {
            ch = inputStr.charAt(i);
            if(characterhashtable.containsKey(ch))  {
                // increment count corresponding to ch
                characterhashtable.put(  ch ,  characterhashtable.get(ch) +1 );
            }
            else {
                characterhashtable.put( ch , 1 ) ;
            }
        }
        for(Map.Entry<Character,Integer> entry: characterhashtable.entrySet())
        {
            if(entry.getValue() == 1)
                return entry.getKey();
        }
        return null;
    }
}
