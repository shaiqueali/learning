package com.string.immutable;

import lombok.Getter;

/**
 * Advantages:
 * It gives benefit for multi-threaded environment
 * Disadvantages:
 * Memory Consumption is more because on each modification of them a new object is created in the memory.
 */


/**
 * By making our Employee class final, this class cannot be extended by any other class,
 * and hence the object of our final class cannot be modified by any other classes as no other classes would be able to extend it.
 */
@Getter
public final class ImmutableEmployee {
    private final int id;
    private final String name;
    private final Age age;

    //Parameterized Constructor
    public ImmutableEmployee(int id, String name, Age age) {
        this.name = name;
        this.id = id;
//        this.age = age;
        /**
         * 2. Passing Mutable Objects to Immutable Class
         */
        Age cloneAge = new Age();
        cloneAge.setDay(age.getDay());
        cloneAge.setMonth(age.getMonth());
        cloneAge.setYear(age.getYear());
        this.age = cloneAge;
    }


//    public Age getAge() {
//        Age cloneAge = new Age();
//        cloneAge.setDay(this.age.getDay());
//        cloneAge.setMonth(this.age.getMonth());
//        cloneAge.setYear(this.age.getYear());
//        return cloneAge;
//    }

    @Override
    public String toString() {
        return "ImmutableEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}