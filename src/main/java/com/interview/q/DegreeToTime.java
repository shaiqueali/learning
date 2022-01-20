package com.interview.q;

public class DegreeToTime {

    public static void main(String args[]) {
        System.out.println("time: " + problem3(270));
    }

    public static String problem3(int degree) {
        int temp = 12*60/360*degree;
        int hh = temp/60;
        int mm = temp%60;
        String hhStr = hh > 9 ? String.valueOf(hh): String.format("0%s", hh);
        String mmStr = mm > 9 ? String.valueOf(mm): String.format("0%s", mm);
        return String.format("%s:%s", hhStr, mmStr);
    }
}
