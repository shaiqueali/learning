package com.test.thread.main;

import com.test.thread.dao.user.UserDAO;
import com.test.thread.runnable.UserProcessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestExecutors {

    public static final String FILE_PATH = "/Users/shaique/test.txt";

    public static void main(String args[]) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        getUsersFromFile(FILE_PATH).forEach(user -> {
            Future<Integer> userId = executorService.submit(new UserProcessor(user, new UserDAO()));
            try {
                System.out.println("Record saved : " + userId.get()); // Future cause blocking. wait
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
        System.out.println("Main execution over.......");

    }

    public static List<String> getUsersFromFile(String fileName) {
        List<String> users = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            while ((line = reader.readLine()) != null) {
                System.out.println(Thread.currentThread().getName() + " reading line: " + line);
                users.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }
}
