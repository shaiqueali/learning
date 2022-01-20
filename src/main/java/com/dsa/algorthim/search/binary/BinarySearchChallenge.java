package com.dsa.algorthim.search.binary;

import java.util.Arrays;

public class BinarySearchChallenge {

    public static void main(String[] args) {
        String[] marvel = {"Spiderman", "Venom", "Carnage", "Mysterio"};
        Arrays.sort(marvel);
        System.out.println(Arrays.toString(marvel));
        System.out.println(Arrays.binarySearch(marvel, "Xavier"));
        System.out.println(Arrays.binarySearch(marvel, "Carnage"));
        System.out.println(marvel[Arrays.binarySearch(marvel, "Carnage")]);
        System.out.println(Arrays.binarySearch(marvel, "Lizard"));
        System.out.println(Arrays.binarySearch(marvel, "Apocalypse"));
        System.out.println(Arrays.binarySearch(marvel, "Spiderman"));
        System.out.println(Arrays.toString(marvel));
    }
}
