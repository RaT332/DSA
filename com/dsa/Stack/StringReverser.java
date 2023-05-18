package com.dsa.Stack;

import java.util.Stack;

public class StringReverser {
    public String reverse(String input) {
        if (input == null) throw new IllegalArgumentException();

        var stack = new Stack<Character>();

        for (char ch : input.toCharArray()) stack.push(ch);

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }

}
