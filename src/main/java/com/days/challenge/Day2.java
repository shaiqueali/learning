package com.days.challenge;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.*;

/**
 * Getting the last element of the list
 */
public class Day2 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("jpg", "png", "avi", "mpeg", "docx");

        // list.stream().collect(Collectors.joining(", "));

        // using reduce
        out.println(list.stream().reduce((s, s2) -> s2).get());

        // using skip
        out.println(list.stream().skip(list.size()-1).findFirst().get());

        /**
         * I don't get it why using reduce and skip to get the last element rather then directly get by last index
         */
        out.println(list.get(list.size()-1));
        }
}
