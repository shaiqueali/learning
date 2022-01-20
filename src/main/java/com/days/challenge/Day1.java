package com.days.challenge;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * comparing / checking equality against multiple Strings.
 */
public class Day1 {
    public static void main(String args[]) {
        String fileType = "png";
        if (Arrays.asList("jpg", "png", "avi", "mpeg", "docx").contains(fileType)) {
            System.out.println("File found!");
        }

        if(Stream.of("jpg", "png", "avi", "mpeg", "docx").anyMatch(fileType::equalsIgnoreCase)) {
            System.out.println("File found!");
        }
    }
}
