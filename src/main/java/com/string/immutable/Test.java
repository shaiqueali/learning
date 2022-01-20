package com.string.immutable;


import java.util.Objects;

public class Test {

    public static void main(String[] args) {
        Age age = new Age();
        age.setDay(1);
        age.setMonth(1);
        age.setYear(1994);
        ImmutableEmployee employee = new ImmutableEmployee(1, "Rax", age);
        System.out.println("Rax age year before modification = " + employee.toString());
        age.setYear(1995);
        System.out.println("Rax age year after modification = " + employee.toString());
    }
}
