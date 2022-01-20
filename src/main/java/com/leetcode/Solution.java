package com.leetcode;

import java.util.Scanner;

public class Solution {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0;i<t;i++){
            int n = in.nextInt();
            long a[] = new long[n];
            for(int j=0;j<n;j++)
                a[j] = in.nextLong();
            System.out.println(profit(a));
        }
    }

    public static long profit(long a[]){
        long maxSoFar = a[a.length-1];
        long profit = 0L;
        for(int i = a.length-2;i>=0;i--){
            if(a[i]>maxSoFar)
                maxSoFar = a[i];
            else
                profit+=maxSoFar-a[i];
        }
        return profit;
    }
}
