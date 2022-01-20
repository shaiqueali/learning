package com.javachallengers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

public class ParallelChallenge {

    public static void main(String... args) {

        List<Simpson> simpsons = Arrays.asList(new Simpson(10), new Simpson(15), new Simpson(11),
                new Simpson(20), new Simpson(22), new Simpson(23), new Simpson(16),
                new Simpson(13));

        simpsons.stream().parallel()
                .filter(simpson -> simpson.age > 10)
                .map(simpson -> simpson + ", ")
                .forEachOrdered(System.out::print);

        System.out.println();
        simpsons.stream().parallel()
                .filter(simpson -> simpson.age > 10)
                .map(simpson -> simpson + ", ")
                .forEach(System.out::print);

    }

    public static class Simpson {
        private int age;

        public Simpson(final int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "" + age;
        }
    }
}
