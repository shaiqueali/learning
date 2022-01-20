package com.test.thread.runnable;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileTestThread extends Thread {

    public static final String FILE_PATH = "/Users/shaique/test.txt";

    @Override
    public void run() {
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(FILE_PATH)))) {
            while ((line = reader.readLine()) != null) {
                System.out.println(Thread.currentThread().getName() + " reading line: " +line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
