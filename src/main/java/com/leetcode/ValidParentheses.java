package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class ValidParentheses {

    public boolean isValidParentheses(final String parentheses) {
        Deque<Character> queue = new ArrayDeque<>();
        for (char ch : parentheses.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                queue.push(ch);
                continue;
            }
            // If current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (queue.isEmpty())  return false;
            char check;
            switch (ch) {
                case ')':
                    check = queue.pop();
                    if (check == '{' || check == '[') return false;
                    break;
                case '}':
                    check = queue.pop();
                    if (check == '(' || check == '[')  return false;
                    break;
                case ']':
                    check = queue.pop();
                    if (check == '(' || check == '{') return false;
                    break;
            }
        }
        return (queue.isEmpty());
    }
}
