package com.test.thread.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RunnableMain {

    public static final String FILE_PATH = "/Users/shaique/test.txt";

    public static void main(String args[]) {

        Runnable runnable = () -> {
            String line;
            try (BufferedReader reader = new BufferedReader(new FileReader(new File(FILE_PATH)))) {
                while ((line = reader.readLine()) != null) {
                    System.out.println(Thread.currentThread().getName() + " reading line: " + line);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(runnable);
    }
}
