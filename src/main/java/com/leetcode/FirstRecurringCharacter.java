package com.leetcode;

import java.util.HashSet;

public class FirstRecurringCharacter {

    public char firstRecurringCharacter(final String input) {
        char found = 0;
        HashSet<Character> list = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (list.contains(ch))
                return ch;
            list.add(ch);
        }
        return found;
    }

    public char firstRecurringCharacter2(final String input) {
        char found = 0;
        char[] chars = new char[256];

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (chars[ch] != ch)
                return ch;
            chars[ch] = ch;
        }
        return found;
    }
}
