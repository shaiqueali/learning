package com.codility.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {

    private static int solution(String[] T, String[] R) {
        final Map<String, String> map = new HashMap<>();
        int totalGroupsPassed;
        double score;
        String group;
        int i = 0;
        while (i < T.length) {
            group = parseName(T[i]);
            if (map.containsKey(group)) {
                final String newResult = map.get(group).concat(convertResult(R[i]));
                map.put(group, newResult);
            } else {
                map.put(group, convertResult(R[i]));
            }
            i++;
        }
        totalGroupsPassed = (int) map.values().stream().filter(groupResult -> !groupResult.contains("0")).count();
        score = totalGroupsPassed * 100 / (double) map.size();
        return (int) score;
    }

    private static String parseName(String fullTestName) {
        String groupName;
        final char[] word = fullTestName.trim().toCharArray();
        final int suffixIndex = word.length - 1;
        if (!Character.isDigit(word[suffixIndex])) {
            groupName = fullTestName.substring(0, fullTestName.length() - 1);
        } else {
            groupName = fullTestName;
        }
        return groupName;
    }

    private static String convertResult(final String name) {
        return "OK".equalsIgnoreCase(name) ? "1" : "0";
    }


    public int solution1(final int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        final Set<Integer> frequency = Arrays.stream(A).boxed().collect(Collectors.toSet());
        for (int i = 0; i < A.length; i++) {
            frequency.remove(A[i]);
            if (frequency.isEmpty()) {
                return i;
            }
        }
        return A.length - 1;
    }

    public int solution33(int[] A) {
        final Set<Integer> all = Arrays.stream(A).boxed().collect(Collectors.toSet());
        final Map<Integer, Integer> map = new HashMap<>(all.size());
        int minLength = A.length;
        int idx = A.length - all.size();
        int t = 0;
        int i = 0;
        while (t <= idx) {
            for (; map.size() < all.size() && i < A.length; i++)
                map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            if (map.size() != all.size())
                break;
            minLength = Math.min(minLength, i - t);
            int tail = A[t];
            int tailCount = map.get(tail);
            if (tailCount == 1)
                map.remove(tail);
            else if (tailCount > 1)
                map.put(tail, tailCount - 1);
            if (minLength == all.size())
                break;
            t++;
        }
        return minLength;
    }

    private int caterpillarAlg(int[] arr, Set<Integer> all) {
        Map<Integer, Integer> tmp = new HashMap<>(all.size());  // value to it's cardinality
        int minLength = arr.length;
        int lastTailIdx = arr.length - all.size();
        for (int t = 0, h = 0; t <= lastTailIdx; t++) {

            for (; tmp.size() < all.size() && h < arr.length; h++)
                tmp.put(arr[h], tmp.getOrDefault(arr[h], 0) + 1);

            if (tmp.size() != all.size())
                break;

            minLength = Math.min(minLength, h - t);

            int tail = arr[t], tailCount = tmp.get(tail);
            if (tailCount == 1)
                tmp.remove(tail);
            else if (tailCount > 1)
                tmp.put(tail, tailCount - 1);
            else
                throw new IllegalStateException();

            if (minLength == all.size())
                break;
        }
        return minLength;
    }
}
