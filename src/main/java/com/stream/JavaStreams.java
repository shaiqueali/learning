package com.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.System.out;

public class JavaStreams {

    public static final String DATA_FILE = "./src/main/resources/data.txt";
    public static final String BANDS_FILE = "./src/main/resources/bands.txt";
    public static final List<Integer> list = Arrays.asList(1, 7, 8, 9, 5, 2, 36, 4, 78, 222, 24, 9);

    public static void main(String[] args) throws IOException {
        // 1. Integer Stream
        IntStream
                .range(1, 10)
                .forEach(out::print);
        out.println();

        // 2. Integer Stream with skip
        IntStream
                .range(1, 10)
                .skip(5)
                .forEach(x -> out.println(x));
        out.println();

        // 3. Integer Stream with sum
        out.println(
                IntStream
                        .range(1, 5)
                        .sum());
        out.println();

        // 4. Stream.of, sorted and findFirst
        Stream.of("Ava", "Aneri", "Alberto")
                .sorted()
                .findFirst()
                .ifPresent(out::println);

        // 5. Stream from Array, sort, filter and print
        String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah"};
        Arrays.stream(names)    // same as Stream.of(names)
                .filter(x -> x.startsWith("S"))
                .sorted()
                .forEach(out::println);

        // 6. average of squares of an int array
        Arrays.stream(new int[]{2, 4, 6, 8, 10})
                .map(x -> x * x)
                .average()
                .ifPresent(out::println);

        // 7. Stream from List, filter and print
        List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah");
        people
                .stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("a"))
                .forEach(out::println);

        // 8. Stream rows from text file, sort, filter, and print
        Stream<String> bands = Files.lines(Paths.get(BANDS_FILE));
        bands
                .sorted()
                .filter(x -> x.length() > 13)
                .forEach(out::println);
        bands.close();

        // 9. Stream rows from text file and save to List
        List<String> bands2 = Files.lines(Paths.get(BANDS_FILE))
                .filter(x -> x.contains("jit"))
                .collect(Collectors.toList());
        bands2.forEach(x -> out.println(x));

        // 10. Stream rows from CSV file and count
        Stream<String> rows1 = Files.lines(Paths.get(DATA_FILE));
        int rowCount = (int) rows1
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .count();
        out.println(rowCount + " rows.");
        rows1.close();

        // 11. Stream rows from CSV file, parse data from rows
        Stream<String> rows2 = Files.lines(Paths.get(DATA_FILE));
        rows2
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .forEach(x -> out.println(x[0] + "  " + x[1] + "  " + x[2]));
        rows2.close();

        // 12. Stream rows from CSV file, store fields in HashMap
        Stream<String> rows3 = Files.lines(Paths.get(DATA_FILE));
        Map<String, Integer> map = new HashMap<>();
        map = rows3
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .collect(Collectors.toMap(
                        x -> x[0],
                        x -> Integer.parseInt(x[1])));
        rows3.close();
        for (String key : map.keySet()) {
            out.println(key + "  " + map.get(key));
        }

        // 13. Reduction - sum
        double dSum = Stream.of(7.3, 1.5, 4.8)
                .reduce(0.0, (Double a, Double b) -> a + b);
        out.println("13. Reduction - sum: Total = " + dSum);

        // 14. Reduction - summary statistics
        IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)
                .summaryStatistics();
        out.println("14. Reduction - summary statistics" + summary);

        /**
         * 15. Given a list of numbers, return the sum of all numbers.
         * Approach: We can use reduce() method whenever we want to produce a single resultant value as output, for example, maximum, minimum, sum, product, etc.
         */

        Integer iSum = list.stream().reduce((a, b) -> a + b).orElse(0);
		out.println("15. sum is: "+iSum);

        /**
         * 16. Given a list of numbers, return the average of all numbers
         * Approach: We can use mapToInt() followed by average() whenever we want to perform an average on the list of integers.
         */

        double avg = list.stream().mapToInt(value -> value).average().orElse(0);
        out.println("16. Avg is: " + avg);

        /**
         * 17.  Given a list of numbers, square them and filter the numbers which are greater 100 and then find the average of them
         *
         * Approach: Here we need to do 3 things
         *
         * We need to square each number ( We can use map())
         * Filter whose value is greater than 100 (we can use filter())
         * Find average of those (we can use mapToInt() and average() together)
         */

        avg = list.stream().map(a -> a * a).filter(a -> a > 100).mapToInt(a -> a).average().orElse(0);
        out.println("17. Avg is: " + avg);

        /**
         * 18) Given a list of numbers, return the even and odd numbers separately
         *
         * Approach: We can use filter() and Collectors.toList() to get both even and odd numbers as two separate lists.
         */

        List<Integer> numbers = list.stream().filter(a -> a % 2 == 0).sorted().collect(Collectors.toList());
        out.println("Even Numbers: " + numbers);
        numbers = list.stream().filter(a -> a % 2 == 1).sorted(Collections.reverseOrder()).collect(Collectors.toList());
        out.println("Odd Numbers: " + numbers);

        /**
         * 19) Given a list of numbers, find out all the numbers starting with 2
         *
         * Approach: Here we need to do 4 things
         *
         * Convert Integer to String to perform startsWith operation on it
         * Filter the strings that starts with 2
         * Convert String to Integer on filtered data
         * Collect the final Integers as List and store
         */

        List<String> sList = list.stream().map(String::valueOf).filter(str -> str.startsWith("2")).sorted().collect(Collectors.toList());
        out.println("Start with: "+  sList);

        /**
         * 20) Given a list of numbers, print the duplicate numbers
         *
         * Approach 1: Using frequency() method of Collections class. It counts the frequency of the specified element in the given list.
         * If count > 1 then that element is duplicate one
         */

        Set<Integer> duplicates = list.stream().filter(a-> Collections.frequency(list, a) > 1).collect(Collectors.toSet());
        out.println("Duplicates: " + duplicates);

        /**
         * 21) Given a list of numbers, print the maximum and minimum values
         *
         * Approach: Using max() and min() we can get maximum and minimum values from a list along with Comparator.comparing().
         */

        final int max = list.stream().max(Comparator.comparing(Integer::valueOf)).orElse(0);
        out.println("Max: " + max);

        final int min = list.stream().min(Comparator.comparing(Integer::valueOf)).orElse(0);
        out.println("Min: " + min);

        /**
         * 22) Given a list of numbers, return the first 5 elements and their sum
         *
         * Approach: We can use limit() followed by reduce().
         */

        final int fiveSum = list.stream().limit(5).reduce(Integer::sum).orElse(0);
        out.println(fiveSum);

        /**
         * 23) Given a list of numbers, skip the first 5 numbers and return the sum of the remaining numbers
         *
         * Approach: We can use skip() to skip the first n numbers in a list.
         */

        final int lastFiveSum = list.stream().skip(5).reduce(Integer::sum).orElse(0);
        out.println(lastFiveSum);
    }
}