package com.test.thread.runnable;

import com.test.thread.dao.user.UserDAO;
import com.test.thread.model.User;
import lombok.AllArgsConstructor;

import java.util.StringTokenizer;
import java.util.concurrent.Callable;

@AllArgsConstructor
public class UserProcessor implements Callable<Integer> {

    private String userRecord;
    private UserDAO dao;

    @Override
    public Integer call() throws Exception {
        StringTokenizer stringTokenizer = new StringTokenizer(userRecord, ",");
        System.out.println(Thread.currentThread().getName() + " processing record for " + userRecord);
        while (stringTokenizer.hasMoreTokens()) {
            User user = User.builder().email(stringTokenizer.nextToken()).name(stringTokenizer.nextToken()).id(Integer.valueOf(stringTokenizer.nextToken())).build();
            return dao.saveUser(user) == 1 ? user.getId() : 0;
        }
        return null;
    }
}
