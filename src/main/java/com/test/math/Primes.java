package com.test.math;

import java.util.ArrayList;

// version 1
public class Primes {

    public static void main(String[] args) {
        Primes p = new Primes();
        p.type1(10);
        p.type2(10);
        p.type3(10000);
        p.type4(200000);
    }

    public void type1(final int max) {
        for (int x = 2; x <= max; x++) {
            boolean isPrime = true;
            for (int y = 2; y < x; y++)
                if (x % y == 0)
                    isPrime = false;
            if (isPrime)
                System.out.println(x);
        }
    }

//--------------------------------------------
// version 2: break

    public void type2(final int max) {
        for (int x = 2; x <= max; x++) {
            boolean isPrime = true;
            for (int y = 2; y < x; y++)
                if (x % y == 0) {
                    isPrime = false;
                    break;
                }
            if (isPrime)
                System.out.println(x);
        }
    }
//--------------------------------------------
// version 3: break, add to list

    public void type3(final int max) {
        ArrayList<Integer> primeList = new ArrayList<>();

        for (int x = 2; x <= max; x++) {
            boolean isPrime = true;
            for (int y = 2; y < x; y++)
                if (x % y == 0) {
                    isPrime = false;
                    break;
                }
            if (isPrime)
                primeList.add(x);
        }
        System.out.println(primeList);
    }

    //--------------------------------------------
// version 4: break, add to list, square root
    public void type4(final int max) {
        ArrayList<Integer> primeList = new ArrayList<>();

        for (int x = 2; x <= max; x++) {
            boolean isPrime = true;
            for (int y = 2; y < Math.sqrt(x); y++)
                if (x % y == 0) {
                    isPrime = false;
                    break;
                }
            if (isPrime)
                primeList.add(x);
        }
        System.out.println(primeList);
    }
}
