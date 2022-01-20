package com.interview.q;

import java.util.Arrays;

/**
 * Splitting a Java String by Multiple Delimiters
 */
public class SplitString {

    public static void main(String[] args) {
        String example = "Mary;Thomas:Jane-Kate";
        String[] names = example.split(";|:|-");
        System.out.println(Arrays.toString(names));

        /**
         * Guava Solution
         */
        // Iterable<String> names = Splitter.on(Pattern.compile(";|:|-")).split(example);

        /**
         * Apache Commons Solution
         */

//        String[] names = StringUtils.split(example, ";:-");

    }
}
