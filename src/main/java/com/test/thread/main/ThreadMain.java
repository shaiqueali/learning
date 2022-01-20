package com.test.thread.main;

import com.test.thread.runnable.ReadFileTestThread;

public class ThreadMain {

    public static void main(String args[]) {

        /**
         * Thread states
         */
        ReadFileTestThread thread1 = new ReadFileTestThread(); // NEW
        ReadFileTestThread thread2 = new ReadFileTestThread();
        ReadFileTestThread thread3 = new ReadFileTestThread();

        thread1.start(); // RUNNABLE
        thread2.start();
        thread3.start();

        // JVM execute // RUNNING

        // JOB completed // States is TERMINATED/DEAD
    }
}
