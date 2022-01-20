package com.logical;

import com.logical.classes.NoClassDefFoundErrorExample;

public class ClassNotFoundExceptionVsNoClassDefFoundError {

    public static void main(String[] args) {
        try {
            /**
             * ClassNotFoundException is a checked exception which occurs when an application
             * tries to load a class through its fully-qualified name and
             * can not find its definition on the classpath.
             */
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Case - 1: " + e.getMessage());
        }

        /**
         * NoClassDefFoundError is a fatal error. It occurs when JVM can not find the definition of the class while trying to:
         *
         * Instantiate a class by using the new keyword
         * Load a class with a method call
         */
        NoClassDefFoundErrorExample sample = new NoClassDefFoundErrorExample();
        sample.getClassWithInitErrors();
    }
}
