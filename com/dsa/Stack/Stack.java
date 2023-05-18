package com.dsa.Stack;

import java.util.Arrays;

public class Stack {

    private int[] stack;
    private int count;
    public Stack() {
        stack = new int[5];
    }

    public void push(int item) {
        if (stack.length == count) throw new StackOverflowError();

        stack[count++] = item;
    }

    public int pop() {
        if (isEmpty())
            throw new IllegalStateException();

        return stack[--count];
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(stack,0,count);
        return Arrays.toString(content);
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return stack[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }
}
