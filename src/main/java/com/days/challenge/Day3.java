package com.days.challenge;

import java.util.Objects;
import java.util.Optional;

/**
 * Using Objects.requireNonNullElse() where Optional not being able to be used
 */
public class Day3 {

    public static void main(String[] args) {

        String type = Objects.requireNonNull(getFileExtension(), "got null");
        System.out.println(type);
    }

    // will cause NullPointerException when get() is called on returned Object
    public static Optional<String> getFileExtensionOpt() {
        return Optional.of(null);
    }

    // without Optional
    public static String getFileExtension() {
        return null;
    }
}
