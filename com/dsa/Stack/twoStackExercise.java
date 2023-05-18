package com.dsa.Stack;

public class twoStackExercise{
    private final int[] items = new int[5];

    private int stack1;
    private int stack2;

    public twoStackExercise() {
        stack1=stack2=items[0];
    }

    public void push1(int item) {
        if (stack1 < stack2){
            shift(stack2,stack1);
            stack2++;
        }

        items[stack1++] = item;
    }

    public void push2(int item) {
        if (stack2 < stack1){
            shift(stack1,stack2);
            stack1++;
        }

        items[stack2++] = item;
    }


    private void shift(int pointer1,int pointer2) {
        for (int i = pointer1; i > pointer2 ; i--) {
            items[i] = items[i-1];
        }
    }

}
