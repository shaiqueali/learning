package com.toptal;

import java.util.HashMap;
import java.util.Map;


/**
 * 1c, 5c, 10c, 25c, 50c
 */

public class Main {
    public static Map<Integer, Integer> mCoins = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(getChange(3.14, 1.99));
        mCoins.put(1, 1);
        mCoins.put(2, 5);
        mCoins.put(3, 10);
        mCoins.put(4, 25);
        mCoins.put(5, 50);
        mCoins.put(6, 100);
    }

//    getChange(3.14, 1.99) // should return [0,1,1,0,0,1]
//    getChange(3, 0.01) // should return [4,0,2,1,1,2]
//    getChange(4, 3.14) // should return [1,0,1,1,1,0]
//    getChange(0.45, 0.34) // should return [1,0,1,0,0,0]

    public static  int[] getChange(double money, double price) {
        int[] coins = new int[6];
        double remain = money - price;

        double multiple = remain * 1000;
        int rem = (int) multiple % 100;
        System.out.println(rem);
        if (rem>10) {
            coins[6] = rem / 100;
        }
        return coins;
    }

}
