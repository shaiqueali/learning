package com.heckerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution254 {
    public static int findFact(int n) {
        int ret = 1;
        for (int i = 1; i <= n; i++)
            ret *= i;
        return ret;
    }

    public static void main(String[] args) {

        Solution254 obj = new Solution254();
        Scanner scan = new Scanner(System.in);

        int q = scan.nextInt();
        while (scan.hasNextInt()) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int res = 0;
            for (int i = 1; i <= n; i++) {
                int g_of_i = obj.g(i);
                int sg_of_i = obj.s(g_of_i);
                res += sg_of_i;
            }
            System.out.println(res);
        }

    }

    public static long getSum(final List<Integer> query, final List<Integer> numbers ) {
        return IntStream.rangeClosed(query.get(0) - 1, query.get(1) - 1).map(numbers::get).mapToLong(number -> 0 != number ? number : query.get(2)).sum();
    }

    public static List<Long> findSum(List<Integer> numbers, List<List<Integer>> queries) {
        // Write your code here

        return queries.stream().map(query -> getSum(query, numbers)).collect(Collectors.toList());
    }

    // Road Repair
    public static long getMinCost(List<Integer> crew_id, List<Integer> job_id) {
        long cost = 0;
        Collections.sort(crew_id);
        Collections.sort(job_id);
        if (crew_id.size() == job_id.size()) {
            for (int i = 0; i < crew_id.size(); i++) {
                int job  = job_id.get(i);
                int crew = crew_id.get(i);
                if (job >= crew) cost = cost + (job - crew);
                else cost = cost + (crew - job);
            }
        }
        return cost;
    }

    public int f(int n) {
        int res = 0;
        while (n != 0) {
            int a = n % 10;
            res += findFact(a);
            n = n / 10;
        }
        return res;
    }

    public int s(int n) {
        int res = 0;
        while (n != 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }

    public int g(int n) {
        Solution254 obj = new Solution254();
        int res = 1;
        int temp = 1;
        int s_f_of_N = 0;
        while (s_f_of_N != n) {
            int f_of_N = obj.f(temp);
            s_f_of_N = obj.s(f_of_N);

            if (s_f_of_N == n) {
                res = temp;
                break;
            }
            temp += 1;
        }
        return res;
    }
}
