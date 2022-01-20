package com.codility.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        String S = "id,name,age\n1,jack,66\n2,Ali,35\n2,Ali,77\n2,Ali,22";
        StringTokenizer tokens = new StringTokenizer(S);
        List<String> rows = new ArrayList<>();
        while (tokens.hasMoreTokens()) {
            rows.add(tokens.nextToken());
        }
        int index = 0;
        List<Integer> cols = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++) {
            if (i == 0) {
                index = Arrays.asList(rows.get(i).split(",")).indexOf("age");
                continue;
            }
            cols.add(Integer.parseInt(Arrays.asList(rows.get(i).split(",")).get(index)));
        }

        Integer max = cols
                .stream()
                .mapToInt(v -> v)
                .max().orElse(0);
        System.out.println(max);
    }

    public int solution(String S, String C) {

        return 0;
    }
}
